package com.gitee.common.po

import java.io.Serializable
import java.sql.Timestamp
import java.util.Objects
import javax.persistence.*

/**
 * @author [dujf](http://github.com/athc)
 * @date 2018/7/25
 * @since JDK1.8
 */
@Entity
@Table(name = "athc_comment", schema = "athc_blog", catalog = "")
data class AthcComment(
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Int = 0,
    @Column(name = "content")
    val content: String? = null,
    @Column(name = "user_id")
    val userId: Int = 0,
    @Column(name = "article_id")
    val articleId: Int = 0,
    @Column(name = "create_at")
    val createAt: Timestamp? = null,
    @Column(name = "pid")
    val pid: Int? = null
) : Serializable {

  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (o == null || javaClass != o.javaClass) return false
    val that = o as AthcComment?
    return id == that!!.id
  }

  override fun hashCode(): Int {

    return Objects.hash(id)
  }
}
