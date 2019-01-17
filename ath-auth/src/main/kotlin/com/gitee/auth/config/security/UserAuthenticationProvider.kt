package com.gitee.auth.config.security

import org.slf4j.LoggerFactory
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore
import org.springframework.stereotype.Component

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019/1/8
 * @since JDK1.8
 */
@Component
class UserAuthenticationProvider(
    private val userDetailsServiceImpl: UserDetailsServiceImpl,
    private val redisConnectionFactory: RedisConnectionFactory
) : AuthenticationProvider {

  override fun authenticate(authentication: Authentication): Authentication {
    logger.warn("--------UserAuthenticationProvider--------")
    val userDetails = userDetailsServiceImpl.loadUserByUsername(authentication.name)
    //check password
    if (!BCrypt.checkpw(authentication.credentials.toString(), userDetails.password)) {
      throw BadCredentialsException("error password")
    }
    val redisToken = RedisTokenStore(redisConnectionFactory)
    val tokens = redisToken.findTokensByClientIdAndUserName((authentication.details as LinkedHashMap<*, *>)["client_id"].toString(), authentication.principal.toString())
    //todo: 异地登录注销
    return UsernamePasswordAuthenticationToken(authentication.principal, authentication.credentials, userDetails.authorities)
  }

  /**
   *isAssignableFrom方法判断，equal方法和==不一定能判断
   */
  override fun supports(authentication: Class<*>): Boolean {
//    val b = UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication)
    return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication)
  }

  private val logger = LoggerFactory.getLogger(UserAuthenticationProvider::class.java)
}