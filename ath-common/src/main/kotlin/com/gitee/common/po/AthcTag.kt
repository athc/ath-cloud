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
@Table(name = "athc_tag", schema = "athc_blog", catalog = "")
class AthcTag(
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Int = 0,
    @Column(name = "tag")
    val tag: String? = null
) : Serializable {
  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (o == null || javaClass != o.javaClass) return false
    val athcTag = o as AthcTag?
    return id == athcTag!!.id && tag == athcTag.tag
  }

  override fun hashCode(): Int {

    return Objects.hash(id, tag)
  }
}
