package com.example.a20200507_jessosborn_nycschools.ViewModel;

import android.util.Log;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20200507_jessosborn_nycschools.Model.Network;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolViewModel extends ViewModel implements Filterable {

    public String TAG = "SchoolViewModel";
    private String baseUrl = "https://data.cityofnewyork.us/resource/";

    private MutableLiveData<List<SchoolSATData>> listOfSchools;

    public LiveData<List<SchoolSATData>> getListOfSchools() {
        if (listOfSchools == null) {
            listOfSchools = new MutableLiveData<List<SchoolSATData>>();
            loadSchoolsFromAPI();
        }
        return listOfSchools;
    }

    private void loadSchoolsFromAPI() {
        Network network = new Network(baseUrl);
        network.initRetrofit().getSchoolsList()
                .enqueue(new Callback<List<SchoolSATData>>() {
                    @Override
                    public void onResponse(Call<List<SchoolSATData>> call, Response<List<SchoolSATData>> response) {
                        Log.d(TAG, "onResponse: ");
                        listOfSchools.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<SchoolSATData>> call, Throwable t) {
                        Log.d(TAG, "onFailure: ");
                    }
                });
    }

    @Override
    public Filter getFilter() {
        //TODO: Implement Filter object, performFiltering(), and publishResults()
        //I can do this in Kotlin, unsure of how to 'return object : Filter(){... in Java
        return null;
    }
}
