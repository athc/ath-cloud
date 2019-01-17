package com.gitee.auth.config.auth

import com.gitee.auth.config.security.ClientsDetailsImpl
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import com.gitee.auth.config.security.UserDetailsServiceImpl
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.http.HttpMethod
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore


/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/10/12
 * @since JDK1.8
 */
@Configuration
@EnableAuthorizationServer
open class Oauth2Config(
    private val clientsDetailsImpl: ClientsDetailsImpl,
    private val userDetailsServiceImpl: UserDetailsServiceImpl,
    private val redisConnectionFactory: RedisConnectionFactory,
    private val authenticationManager: AuthenticationManager
) : AuthorizationServerConfigurerAdapter() {

  @Throws(Exception::class)
  override fun configure(endpoints: AuthorizationServerEndpointsConfigurer?) {
    endpoints!!
        // .tokenStore(InMemoryTokenStore())
        .tokenStore(redisTokenStore())
        .authenticationManager(authenticationManager)
        //刷新token会用到userDetailsService
        .userDetailsService(userDetailsServiceImpl)
        .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
  }

  @Throws(Exception::class)
  override fun configure(clients: ClientDetailsServiceConfigurer?) {
    clients!!.withClientDetails(clientsDetailsImpl)
  }

  override fun configure(oauthServer: AuthorizationServerSecurityConfigurer?) {
    //允许token访问
    oauthServer?.tokenKeyAccess("permitAll()")?.checkTokenAccess("permitAll()")
    oauthServer!!.passwordEncoder(passwordEncoder())
    //允许表单认证
    oauthServer.allowFormAuthenticationForClients()
  }

  /**
   * 密码加密
   */

  @Bean
  open fun passwordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder()
  }

  @Bean
  open fun redisTokenStore(): RedisTokenStore = RedisTokenStore(redisConnectionFactory)
}