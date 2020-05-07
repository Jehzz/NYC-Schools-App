package com.example.a20200507_jessosborn_nycschools.Model

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitEndpoint {

    //Base URL = https://data.cityofnewyork.us/resource/

    @get:GET("f9bf-2cp4.json")
    val schoolsList: Call<List<SchoolSATData>?>?
}