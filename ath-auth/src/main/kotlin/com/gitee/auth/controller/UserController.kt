package com.gitee.auth.controller

import com.gitee.common.domain.UserDomain
import com.gitee.common.po.AthcUser
import org.springframework.web.bind.annotation.*
import springfox.documentation.annotations.ApiIgnore
import java.security.Principal

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019/1/8
 * @since JDK1.8
 */
@RestController
@RequestMapping("user")
class UserController(
    private val userDomain: UserDomain
) {
  @PostMapping
  fun create(@RequestBody athcUser: AthcUser): AthcUser = userDomain.create(athcUser)

  @GetMapping()
  fun user(@ApiIgnore principal: Principal): Principal = principal
}