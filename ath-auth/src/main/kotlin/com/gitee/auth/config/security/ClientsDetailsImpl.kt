package com.gitee.auth.config.security

import com.gitee.common.repo.ClientRepository
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.provider.ClientDetails
import org.springframework.security.oauth2.provider.ClientDetailsService
import org.springframework.security.oauth2.provider.ClientRegistrationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.stream.Collectors


/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019/1/8
 * @since JDK1.8
 */
@Configuration
open class ClientsDetailsImpl(
    private val clientRepository: ClientRepository
) : ClientDetailsService {
  override fun loadClientByClientId(clientId: String): ClientDetails {
    return clientRepository.findByClientId(clientId).orElseThrow { ClientRegistrationException("clientId: $clientId not found") }.let {
      object : ClientDetails {
        override fun getClientId(): String? {
          return it!!.clientId
        }

        override fun getResourceIds(): Set<String> {
          return string2Set(it!!.resourceIds!!)
        }

        override fun isSecretRequired(): Boolean {
          return false
        }

        override fun getClientSecret(): String {
          return it.clientSecret!!

        }

        override fun isScoped(): Boolean {
          return true
        }

        override fun getScope(): Set<String> {
          return string2Set(it!!.scope!!)
        }

        override fun getAuthorizedGrantTypes(): Set<String> {
          return string2Set(it!!.authorizedGrantTypes!!)
        }

        override fun getRegisteredRedirectUri(): Set<String> {
          return string2Set(it!!.webServerRedirectUri!!)
        }

        override fun getAuthorities(): Collection<GrantedAuthority> {
          return getAuthes(it!!.authorities!!)
        }

        override fun getAccessTokenValiditySeconds(): Int? {
          return Integer.valueOf(it!!.accessTokenValidity!!)
        }

        override fun getRefreshTokenValiditySeconds(): Int? {
          return Integer.valueOf(it!!.refreshTokenValidity!!)
        }

        override fun isAutoApprove(s: String): Boolean {
          return false
        }

        override fun getAdditionalInformation(): Map<String, Any>? {
          return null
        }
      }

    }
  }

  fun string2Set(str: String): Set<String> {
    return if (!str.isEmpty()) {
      str.split(",").stream().map { it }.collect(Collectors.toSet())
    } else
      emptySet()
  }

  fun getAuthes(str: String): List<GrantedAuthority> {
    return if (!str.isEmpty()) {
      str.split(",").stream().map { SimpleGrantedAuthority(it) }.collect(Collectors.toList())
    } else
      emptyList()
  }
}

