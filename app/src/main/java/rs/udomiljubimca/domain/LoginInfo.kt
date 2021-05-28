package rs.udomiljubimca.domain

import rs.udomiljubimca.api.model.LoginInfo

data class LoginInfo(
    val accessToken: String = "",
    val expiresIn: String = "",
    val refreshToken: String = "",
    val scope: String = "",
    val tokenType: String = "",
    val userInfo: UserInfo
) {
    companion object {
        fun fromApi(li: LoginInfo): rs.udomiljubimca.domain.LoginInfo {
            return LoginInfo(
                li.accessToken,
                li.expiresIn,
                li.refreshToken,
                li.scope,
                li.tokenType,
                UserInfo.fromApi(li.userInfo)
            )
        }
    }
}
