package com.example.a20200507_jessosborn_nycschools.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20200507_jessosborn_nycschools.Model.SchoolSATData;
import com.example.a20200507_jessosborn_nycschools.R;
import com.example.a20200507_jessosborn_nycschools.ViewModel.SchoolViewModel;

public class MainActivity extends AppCompatActivity implements ShowAllDataInterface {

    RecyclerView recyclerView;
    SchoolsListAdapter schoolAdapter;
    SchoolViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recyclerview boilerplate setup
        schoolAdapter = new SchoolsListAdapter();
        schoolAdapter.setListener(this);
        recyclerView = findViewById(R.id.rv_schools_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(schoolAdapter);

        //Get Viewmodel instance
        model = new ViewModelProvider(this).get(SchoolViewModel.class);

        //Observe Viewmodel
        model.getListOfSchools().observe(this, listOfSchools -> {
            //Update UI's Recyclerview
            schoolAdapter.setDataSet(listOfSchools);
        });

    }

    @Override
    public void openDetailedView(SchoolSATData school) {
        //TODO: launch new detail-view fragment or activity
    }
}
