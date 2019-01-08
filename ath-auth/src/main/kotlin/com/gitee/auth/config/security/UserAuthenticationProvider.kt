package com.gitee.auth.config.security

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019/1/8
 * @since JDK1.8
 */
@Component
class UserAuthenticationProvider(
    private val userDetailsServiceImpl: UserDetailsServiceImpl
) : AuthenticationProvider {


  override fun authenticate(authentication: Authentication): Authentication {
    val userDetails = userDetailsServiceImpl.loadUserByUsername(authentication.name)
    return UsernamePasswordAuthenticationToken(authentication.principal, authentication.credentials, userDetails.authorities)
  }

  override fun supports(authentication: Class<*>): Boolean {
    return authentication.equals(UsernamePasswordAuthenticationToken::class)
  }
}