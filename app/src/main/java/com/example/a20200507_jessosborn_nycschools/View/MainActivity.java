package com.example.a20200507_jessosborn_nycschools.View;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20200507_jessosborn_nycschools.Model.SchoolSATData;
import com.example.a20200507_jessosborn_nycschools.R;
import com.example.a20200507_jessosborn_nycschools.ViewModel.SchoolViewModel;

public class MainActivity extends AppCompatActivity implements ShowAllDataInterface {

    FragmentManager fragmentManager;
    private String TAG = "MainActivity";
    RecyclerView recyclerView;
    SchoolsListAdapter schoolAdapter;
    SchoolViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recyclerview and other boilerplate setup
        schoolAdapter = new SchoolsListAdapter();
        schoolAdapter.setListener(this);

        recyclerView = findViewById(R.id.rv_schools_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(schoolAdapter);

        fragmentManager = getSupportFragmentManager();


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
        Log.d(TAG, "openDetailedView: adding fragment");

        Fragment fragment = new DetailviewFragment(school);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_fragment, fragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
