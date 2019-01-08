package com.gitee.common.po

import java.io.Serializable
import javax.persistence.*


/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019/1/8
 * @since JDK1.8
 */
@Entity
@Table(name = "clients", schema = "athc_blog", catalog = "")
data class Clients(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: String? = null,

    var clientId: String? = null,

    var clientSecret: String? = null,

    var resourceIds: String? = null,

    var scope: String? = null,

    var authorizedGrantTypes: String? = null,

    var webServerRedirectUri: String? = null,

    var authorities: String? = null,

    var accessTokenValidity: String? = null,

    var refreshTokenValidity: String? = null,

    var additionalInformation: String? = null,

    var autoapprove: String? = null
) : Serializable {


  override fun toString(): String {
    return "Clients{" +
        "id=" + id +
        ", clientSecret=" + clientSecret +
        ", resourceIds=" + resourceIds +
        ", scope=" + scope +
        ", authorizedGrantTypes=" + authorizedGrantTypes +
        ", webServerRedirectUri=" + webServerRedirectUri +
        ", authorities=" + authorities +
        ", accessTokenValidity=" + accessTokenValidity +
        ", refreshTokenValidity=" + refreshTokenValidity +
        ", additionalInformation=" + additionalInformation +
        ", autoapprove=" + autoapprove +
        "}"
  }

  companion object {

    private const val serialVersionUID = 1L
  }
}