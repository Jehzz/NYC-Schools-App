package com.example.a20200507_jessosborn_nycschools.View;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20200507_jessosborn_nycschools.R;
import com.example.a20200507_jessosborn_nycschools.ViewModel.SchoolSATData;
import com.example.a20200507_jessosborn_nycschools.ViewModel.SchoolViewModel;

public class MainActivity extends AppCompatActivity implements ShowAllDataInterface {

    FragmentManager fragmentManager;
    private String TAG = "MainActivity";
    RecyclerView recyclerView;
    SchoolsListAdapter schoolAdapter;
    SchoolViewModel model;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        recyclerView = findViewById(R.id.rv_schools_list);

        //Recyclerview and other boilerplate setup
        schoolAdapter = new SchoolsListAdapter();
        schoolAdapter.setListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(schoolAdapter);

        fragmentManager = getSupportFragmentManager();


        //Get Viewmodel instance
        model = new ViewModelProvider(this).get(SchoolViewModel.class);

        //Observe Viewmodel
        model.getListOfSchools().observe(this, listOfSchools -> {
            //Update UI's Recyclerview
            schoolAdapter.setDataSet(listOfSchools);
            setSearchListener();
        });

    }

    private void setSearchListener() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //apply filter
                return false;
            }
        });
    }

    @Override
    public void openDetailedView(SchoolSATData school) {
        Log.d(TAG, "openDetailedView: adding fragment");

        fragmentManager.popBackStack();

        Fragment fragment = new DetailviewFragment(school);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_fragment, fragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
