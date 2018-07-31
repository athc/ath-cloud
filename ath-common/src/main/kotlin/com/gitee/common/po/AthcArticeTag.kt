package com.gitee.common.po

import java.io.Serializable
import java.util.Objects
import javax.persistence.*

/**
 * @author [dujf](http://github.com/athc)
 * @date 2018/7/25
 * @since JDK1.8
 */
@Entity
@Table(name = "athc_article_tag", schema = "athc_blog", catalog = "")
data class AthcArticleTag(
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Int = 0,
    @Column(name = "tag_id")
    val tagId: Int = 0,
    @Column(name = "article_id")
    val articleId: Int = 0
) : Serializable {

  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (o == null || javaClass != o.javaClass) return false
    val that = o as AthcArticleTag?
    return id == that!!.id &&
        tagId == that.tagId &&
        articleId == that.articleId
  }

  override fun hashCode(): Int {

    return Objects.hash(id, tagId, articleId)
  }
}
