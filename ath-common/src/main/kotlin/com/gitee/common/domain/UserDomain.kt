package com.gitee.common.domain

import com.gitee.common.po.AthcUser
import com.gitee.common.repo.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/18
 * @since JDK1.8
 */
@Service
class UserDomain(
    private val userRepository: UserRepository
) {

  fun create(user: AthcUser): AthcUser {
    return userRepository.save(user.copy(status = 1, role = "ROLE_ADMIN", pwd = BCryptPasswordEncoder().encode(user.pwd)))
  }
}
