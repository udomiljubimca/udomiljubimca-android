package rs.udomiljubimca.api

import retrofit2.http.GET
import rs.udomiljubimca.api.model.LoginInfo

interface ApiInterface {
    @GET("/login")
    suspend fun login(): LoginInfo
}