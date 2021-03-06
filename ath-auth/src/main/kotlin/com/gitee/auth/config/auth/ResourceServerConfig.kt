package com.gitee.auth.config.auth

import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer


/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/10/12
 * @since JDK1.8
 */
@Configuration
@EnableResourceServer
open class ResourceServerConfig : ResourceServerConfigurerAdapter() {
  override fun configure(resources: ResourceServerSecurityConfigurer?) {
    resources!!.resourceId("API")
  }

  @Throws(Exception::class)
  override fun configure(http: HttpSecurity) {
    http
        .authorizeRequests()
        //配置order访问控制，必须认证过后才可以访问
        .antMatchers("/user/**").hasRole("USER")
        .anyRequest().permitAll()
  }
}

