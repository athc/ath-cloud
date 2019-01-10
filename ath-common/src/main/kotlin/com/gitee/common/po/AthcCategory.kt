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
@Table(name = "athc_category", schema = "athc_blog", catalog = "")
class AthcCategory(
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Int = 0,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "weight")
    val weight: Int? = null
) : Serializable {

  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (o == null || javaClass != o.javaClass) return false
    val that = o as AthcCategory?
    return id == that!!.id &&
        name == that.name &&
        weight == that.weight
  }

  override fun hashCode(): Int {

    return Objects.hash(id, name, weight)
  }
}
