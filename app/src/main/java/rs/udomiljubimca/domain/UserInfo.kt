package rs.udomiljubimca.domain

import rs.udomiljubimca.api.model.LoginInfo

data class UserInfo(
    val email: String = "",
    val emailVerified: Boolean = false,
    val name: String = "",
    val preferredUsername: String = "",
    val sub: String = ""
) {
    companion object {
        fun fromApi(ui: LoginInfo.UserInfo): UserInfo {
            return UserInfo(
                ui.email,
                ui.emailVerified,
                ui.name,
                ui.preferredUsername,
                ui.sub
            )
        }
    }
}
