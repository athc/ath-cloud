package com.gitee.auth.config.security

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/10/12
 * @since JDK1.8
 */
@Configuration
@EnableWebSecurity
open class SecurityConfig(
    private val userAuthenticationProvider: UserAuthenticationProvider,
    private val userDetailsServiceImpl: UserDetailsServiceImpl
) : WebSecurityConfigurerAdapter() {

  override fun configure(auth: AuthenticationManagerBuilder) {
    auth.authenticationProvider(userAuthenticationProvider)
        .userDetailsService(userDetailsServiceImpl)
        .passwordEncoder(passwordEncoder())
  }

  override fun configure(http: HttpSecurity) {
    http.requestMatchers()
        .anyRequest()
        .and()
        .authorizeRequests()
        .antMatchers("/oauth/**").permitAll()

  }

  @Bean
  open fun passwordEncoder(): BCryptPasswordEncoder {
    return BCryptPasswordEncoder()
  }

  @Bean
  @Throws(Exception::class)
  override fun authenticationManagerBean(): AuthenticationManager {
    return super.authenticationManagerBean()
  }
}
