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
@Table(name = "athc_links", schema = "athc_blog", catalog = "")
class AthcLinks(
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Int = 0,
    @Column(name = "title")
    val title: String? = null,
    @Column(name = "remark")
    val remark: String? = null,
    @Column(name = "source_url")
    val sourceUrl: String? = null,
    @Column(name = "weight")
    val weight: Int? = null,
    @Column(name = "create_at")
    val createAt: Timestamp? = null
) {


  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (o == null || javaClass != o.javaClass) return false
    val athcLinks = o as AthcLinks?
    return id == athcLinks!!.id &&
        title == athcLinks.title &&
        remark == athcLinks.remark &&
        sourceUrl == athcLinks.sourceUrl &&
        weight == athcLinks.weight &&
        createAt == athcLinks.createAt
  }

  override fun hashCode(): Int {

    return Objects.hash(id, title, remark, sourceUrl, weight, createAt)
  }
}
