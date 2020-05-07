package com.example.a20200507_jessosborn_nycschools.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface RetrofitEndpoint {

    //Base URL = https://data.cityofnewyork.us/resource/

    @GET("f9bf-2cp4.json")
    Call<SchoolsList> getSchoolsList();     //Might have to make this Call<List<Schools>

    //TODO: create callback for SAT data
}
