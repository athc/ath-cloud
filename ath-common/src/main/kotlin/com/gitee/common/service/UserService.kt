package com.gitee.common.service

import com.gitee.common.po.AthcUser

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/18
 * @since JDK1.8
 */
interface UserService {

  fun all(): MutableList<AthcUser>?
}