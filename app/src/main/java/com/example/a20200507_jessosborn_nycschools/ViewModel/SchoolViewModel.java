package com.example.a20200507_jessosborn_nycschools.ViewModel;

import android.util.Log;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20200507_jessosborn_nycschools.Model.Network;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolViewModel extends ViewModel implements Filterable {

    private String TAG = "SchoolViewModel";
    private String baseUrl = "https://data.cityofnewyork.us/resource/";

    //TODO: Move responsibility for fetching and storing school's data to a proper Repository class
    private MutableLiveData<List<SchoolSATData>> listOfSchools;
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public LiveData<String> getError() {
        return errorMessage;
    }

    public LiveData<List<SchoolSATData>> getListOfSchools() {
        if (listOfSchools == null) {
            listOfSchools = new MutableLiveData<>();//School's SAT data will not change during a user's session
            loadSchoolsFromAPI();                   // so it only needs to be loaded once
        }
        return listOfSchools;
    }

    private void loadSchoolsFromAPI() {
        Network network = new Network(baseUrl);
        Objects.requireNonNull(network.initRetrofit().getSchoolsList())
                .enqueue(new Callback<List<SchoolSATData>>() {
                    @Override
                    public void onResponse(@NotNull Call<List<SchoolSATData>> call, @NotNull Response<List<SchoolSATData>> response) {
                        Log.d(TAG, "onResponse: ");
                        if (response.isSuccessful()) {
                            listOfSchools.postValue(response.body());
                        } else {
                            Log.d(TAG, "Error Message:  " + response.message());
                            errorMessage.postValue(response.message());
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<List<SchoolSATData>> call, @NotNull Throwable t) {
                        Log.d(TAG, "Error Message:  " + t);
                        errorMessage.postValue(t.toString());
                    }
                });
    }

    @Override
    public Filter getFilter() {
        //TODO: Implement Filter object, and its performFiltering(), and publishResults() methods
        //I can do this in Kotlin, unsure of how to implement the 'return object : Filter(){... in Java
        return null;
    }
}
