package com.gitee.common.po

import java.io.Serializable
import java.sql.Timestamp
import java.util.Objects
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

/**
 * @author [dujf](http://github.com/athc)
 * @date 2018/7/25
 * @since JDK1.8
 */
@Entity
@Table(name = "athc_user", schema = "athc_blog", catalog = "")
data class AthcUser(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    val id: Int = 0,

    @NotNull
    @Column(name = "accout")
    val accout: String? = null,

    @Column(name = "pwd")
    val pwd: String? = null,

    @Column(name = "salt")
    val salt: String? = null,

    @Column(name = "first_name")
    val firstName: String? = null,

    @Column(name = "last_name")
    val lastName: String? = null,

    @field:Email
    @Column(name = "email")
    val email: String? = null,


    @Column(name = "mobile")
    val mobile: String? = null,

    @Column(name = "url")
    val url: String? = null,

    @Column(name = "create_at")
    val createAt: Timestamp? = null,

    @Column(name = "last_login_at")
    var lastLoginAt: Timestamp? = null,

    @Column(name = "active")
    val active: Int? = null,

    @Column(name = "head_img")
    val headImg: String? = null,

    @Column(name = "role")
    val role: Int? = null,

    @Column(name = "status")
    val status: Int? = null

) : Serializable {
  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (o == null || javaClass != o.javaClass) return false
    val athcUser = o as AthcUser?
    return id == athcUser!!.id &&
        accout == athcUser.accout &&
        pwd == athcUser.pwd &&
        salt == athcUser.salt &&
        firstName == athcUser.firstName &&
        lastName == athcUser.lastName &&
        email == athcUser.email &&
        mobile == athcUser.mobile &&
        url == athcUser.url &&
        createAt == athcUser.createAt &&
        lastLoginAt == athcUser.lastLoginAt &&
        active == athcUser.active &&
        headImg == athcUser.headImg &&
        role == athcUser.role &&
        status == athcUser.status
  }

  override fun hashCode(): Int {

    return Objects.hash(id, accout, pwd, salt, firstName, lastName, email, mobile, url, createAt, lastLoginAt, active, headImg, role, status)
  }
}
