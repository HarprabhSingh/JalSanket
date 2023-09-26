package com.example.jalsanket.network

import com.example.jalsanket.data.FetchedData
import okhttp3.MultipartBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


val retrofit = Retrofit.Builder()
    .baseUrl("http://172.20.10.14:3000/") // Replace with your server's URL
    .addConverterFactory(GsonConverterFactory.create())
    .build()


interface JalApiService {
    @Multipart
    @POST("upload")
    suspend fun uploadData(
        @Part("title") title: String,
        @Part("desc") desc: String,
        @Part("latitude") latitude: Double,
        @Part("longitude") longitude: Double,
        @Part image: MultipartBody.Part
    ): ApiResponse
    @GET("userdata")
        suspend fun getData(): List<FetchedData>

}
object JalApi {
    val retrofitService : JalApiService by lazy {
        retrofit.create(JalApiService::class.java) }
}