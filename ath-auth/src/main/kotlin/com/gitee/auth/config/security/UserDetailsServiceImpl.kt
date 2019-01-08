package com.gitee.auth.config.security

import com.gitee.common.repo.UserRepository
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import java.util.stream.Collectors

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019/1/8
 * @since JDK1.8
 */
@Configuration
open class UserDetailsServiceImpl(
    private val userRepository: UserRepository
) : UserDetailsService {
  override fun loadUserByUsername(username: String): UserDetails {
    return userRepository.findByAccount(username).orElseThrow {
      UsernameNotFoundException("$username not found")
    }.let {
      User(it.account, it.pwd, getRoles(it.role ?: ""))
    }
  }

  private fun getRoles(role: String): List<GrantedAuthority> {
    return role.split(",").stream().map { SimpleGrantedAuthority(it) }.collect(Collectors.toList())
  }
}