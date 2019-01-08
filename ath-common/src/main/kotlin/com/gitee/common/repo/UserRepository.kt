package com.gitee.common.repo

import com.gitee.common.core.BaseRepository
import com.gitee.common.po.AthcUser
import java.util.*


/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/18
 * @since JDK1.8
 */
interface UserRepository : BaseRepository<AthcUser, Long> {

  fun findByAccount(account: String): Optional<AthcUser>
}

