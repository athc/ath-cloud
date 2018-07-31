package com.gitee.common.service.impl

import com.gitee.common.po.AthcUser
import com.gitee.common.repo.UserRepository
import com.gitee.common.service.UserService
import org.springframework.stereotype.Service

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/18
 * @since JDK1.8
 */
@Service
class UserServiceImpl(
    private var userRepository: UserRepository
) : UserService {

  override fun all(): MutableList<AthcUser> = userRepository.findAll()

}