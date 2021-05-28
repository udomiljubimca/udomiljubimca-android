package rs.udomiljubimca.api.model

import com.google.gson.annotations.SerializedName

data class LoginInfo(
    val accessToken: String = "",
    @SerializedName("expires_in")
    val expiresIn: String = "",
    val refreshToken: String = "",
    val scope: String = "",
    val tokenType: String = "",
    val userInfo: UserInfo
) {
    class UserInfo(
        val email: String = "",
        @SerializedName("email_verified")
        val emailVerified: Boolean = false,
        val name: String = "",
        @SerializedName("preferred_username")
        val preferredUsername: String = "",
        val sub: String = ""
    )
}
