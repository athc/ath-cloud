package com.gitee.auth

import com.spring4all.swagger.EnableSwagger2Doc
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/**
 * 认证中心sso
 */
@EnableJpaRepositories("com.gitee")
@EntityScan("com.gitee")
@SpringBootApplication(scanBasePackages = ["com.gitee"])
@EnableSwagger2Doc
open class AuthApplication

fun main(args: Array<String>) {
  SpringApplication.run(AuthApplication::class.java, *args)
}

