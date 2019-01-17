package com.gitee.auth.controller

import com.gitee.common.po.AthcUser
import com.gitee.common.service.UserService
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/18
 * @since JDK1.8
 */
@RestController
class LoginController(
    private val userService: UserService,
    private val tokenServices: ConsumerTokenServices
) {
  @GetMapping("auth")
  fun create(): MutableList<AthcUser>? = userService.all()

  @GetMapping("login/out")
  fun loginOut(@RequestParam token: String): Boolean = tokenServices.revokeToken(token)
}