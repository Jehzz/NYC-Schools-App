package com.example.a20200507_jessosborn_nycschools.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20200507_jessosborn_nycschools.Model.Network;
import com.example.a20200507_jessosborn_nycschools.Model.SchoolsList;

public class SchoolViewModel extends ViewModel {

    private MutableLiveData<SchoolsList> listOfSchools;

    public LiveData<SchoolsList> getListOfSchools() {
        if (listOfSchools == null) {
            listOfSchools = new MutableLiveData<SchoolsList>();
            loadSchoolsFromAPI();
        }
        return listOfSchools;
    }

    private void loadSchoolsFromAPI() {
        Network network = new Network();
        network.initRetrofit();
        //TODO: fetch data from retrofit endpoint methods
        //network.getSchoolsList(); //currently not visible

    }

}
