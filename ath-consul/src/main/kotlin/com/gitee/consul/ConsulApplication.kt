package com.gitee.consul

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@EntityScan("com.gitee")
@EnableJpaRepositories("com.gitee")
@ComponentScan("com.gitee")
@SpringBootApplication
open class ConsulApplication

fun main(args: Array<String>) {
//  runApplication<ConsulApplication>(*args)
  SpringApplication.run(ConsulApplication::class.java, *args)
  val line = "---------------------------------------------"
  println("$line\nhttp://localhost:8011/swagger-ui.html\n$line")

}
