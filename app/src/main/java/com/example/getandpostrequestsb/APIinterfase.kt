package com.example.getandpostrequestsb

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIinterfase {

    @Headers("Content-Type: application/json")
    @GET("/custom-people/?format=json")
    fun getName(): Call<List<myData.myDataItem>>

    @Headers("Content-Type: application/json")
    @POST("/custom-people/?format=json")
    fun postName(@Body info:myData.myDataItem): Call<myData.myDataItem>
}