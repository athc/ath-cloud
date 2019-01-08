package com.gitee.common.repo

import com.gitee.common.core.BaseRepository
import com.gitee.common.po.Clients
import java.util.*

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019/1/8
 * @since JDK1.8
 */
interface ClientRepository : BaseRepository<Clients, Long> {

  fun findByClientId(clientId: String): Optional<Clients>
}