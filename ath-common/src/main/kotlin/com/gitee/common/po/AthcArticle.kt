package com.gitee.common.po

import java.sql.Timestamp
import java.util.Objects
import javax.persistence.*

/**
 * @author [dujf](http://github.com/athc)
 * @date 2018/7/25
 * @since JDK1.8
 */
@Entity
@Table(name = "athc_article", schema = "athc_blog", catalog = "")
class AthcArticle {
  @Id
  @GeneratedValue
  @Column(name = "id")
  val id: Int = 0
  @Column(name = "title")
  val title: String? = null
  @Column(name = "remark")
  val remark: String? = null
  @Column(name = "content")
  val content: String? = null
  @Column(name = "ckick_count")
  val ckickCount: Int? = null
  @Column(name = "recommend")
  val recommend: Int? = null
  @Column(name = "user_id")
  val userId: Int? = null
  @Column(name = "category_id")
  val categoryId: Int? = null
  @Column(name = "create_at")
  val createAt: Timestamp? = null

  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (o == null || javaClass != o.javaClass) return false
    val that = o as AthcArticle?
    return id == that!!.id &&
        title == that!!.title &&
        remark == that.remark &&
        content == that.content &&
        ckickCount == that.ckickCount &&
        recommend == that.recommend &&
        userId == that.userId &&
        categoryId == that.categoryId &&
        createAt == that.createAt
  }

  override fun hashCode(): Int {

    return Objects.hash(id, title, remark, content, ckickCount, recommend, userId, categoryId, createAt)
  }
}
