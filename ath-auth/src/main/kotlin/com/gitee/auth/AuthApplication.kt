package com.gitee.auth

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories("com.gitee")
@EntityScan("com.gitee")
@SpringBootApplication(scanBasePackages = ["com.gitee"])
open class AuthApplication

fun main(args: Array<String>) {
//  runApplication<AuthApplication>(*args)
  SpringApplication.run(AuthApplication::class.java, *args)
}

