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
@Table(name = "athc_ad", schema = "athc_blog", catalog = "")
data class AthcAd(
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
    @Column(name = "picture_url")
    val pictureUrl: String? = null
) : Serializable {
  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (o == null || javaClass != o.javaClass) return false
    val athcAd = o as AthcAd?
    return id == athcAd!!.id &&
        title == athcAd.title &&
        remark == athcAd.remark &&
        sourceUrl == athcAd.sourceUrl &&
        weight == athcAd.weight &&
        pictureUrl == athcAd.pictureUrl
  }

  override fun hashCode(): Int {

    return Objects.hash(id, title, remark, sourceUrl, weight, pictureUrl)
  }
}
