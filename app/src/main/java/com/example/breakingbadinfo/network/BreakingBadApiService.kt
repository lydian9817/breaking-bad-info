package com.example.breakingbadinfo.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private  const val BASE_URL = "https://www.breakingbadapi.com/api/"

/**Create Moshi object*/
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


/**Create the retrofit object*/
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**Define the interface and how retrofit interacts with the server (GET)*/
interface BreakingBadApiService {
    @GET("characters")
    suspend fun getCharacters(): List<Character> //get the list of Character objects
}

/**Initialize the retrofit service (singleton)*/
object BreakingBadApi {
    val retrofitService : BreakingBadApiService by lazy {
        retrofit.create(BreakingBadApiService::class.java)
    }
}