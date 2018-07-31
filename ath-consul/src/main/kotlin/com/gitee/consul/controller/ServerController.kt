package com.gitee.consul.controller

import com.gitee.common.po.AthcUser
import com.gitee.common.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

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
}