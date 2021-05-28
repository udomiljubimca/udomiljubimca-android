package rs.udomiljubimca.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rs.udomiljubimca.BuildConfig
import rs.udomiljubimca.managers.PreferencesManager
import javax.inject.Inject

object ApiClient {

    //TODO: Inject these later on.
    val BASE_URL = "http://149.81.126.136/"
    val SEC_KEY = "jd9823jdi83hwdi387hedoa8w3hda8w7dhawi3"

    private fun getClient(): Retrofit {
        val logLevel =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        val logging = HttpLoggingInterceptor().apply {
            level = logLevel
        }

        val httpClientBuilder = OkHttpClient.Builder()
        val okHttpClient = httpClientBuilder.build()

        httpClientBuilder.addInterceptor(Interceptor { chain ->
            val originalRequest = chain.request()
            val originalHttpUrl = originalRequest.url()

            val requestBuilder = originalRequest.newBuilder().url(originalHttpUrl).apply {
                addHeader("seckey", SEC_KEY)
            }

            // TODO: Once the user token mechanism (injection) is established, use the code below.
            //if (userTokenManager.hasToken) {
            //    requestBuilder.addHeader("Authorization", "Bearer ${userTokenManager.token}")
            //}

            return@Interceptor chain.proceed(requestBuilder.build())
        })

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }

    val apiInterface = getClient().create(ApiInterface::class.java)

}