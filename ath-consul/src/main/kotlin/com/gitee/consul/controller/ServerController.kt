package com.gitee.consul.controller

import com.gitee.common.po.AthcUser
import com.gitee.common.service.UserService
import io.swagger.annotations.Api
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.annotations.ApiIgnore

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/18
 * @since JDK1.8
 */
@RestController
class ServerController(
    private val userService: UserService
) {

  @GetMapping("/con")
  fun all(): MutableList<AthcUser> = userService.all()!!

  @GetMapping("/user")
  fun getUser(@ApiIgnore authentication: Authentication): Authentication {
    return authentication
  }
}