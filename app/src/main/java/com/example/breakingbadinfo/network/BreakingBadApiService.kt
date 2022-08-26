package com.example.breakingbadinfo.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET

private  const val BASE_URL = "https://www.breakingbadapi.com/api/"

/**Create the retrofit object*/
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

/**Define the interface and how retrofit interacts with the server (GET)*/
interface BreakingBadApiService {
    @GET("characters")
    suspend fun getCharacters(): String
}

/**Initialize the retrofit sevice (singleton)*/
object BreakingBadApi {
    val retrofitService : BreakingBadApiService by lazy {
        retrofit.create(BreakingBadApiService::class.java)
    }
}