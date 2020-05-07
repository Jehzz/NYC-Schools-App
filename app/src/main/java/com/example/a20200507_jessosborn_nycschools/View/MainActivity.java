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

    //Architecture components and Views variable declarations
    private FragmentManager fragmentManager;
    private String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private SchoolsListAdapter schoolAdapter;
    private SchoolViewModel model;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recyclerview and other boilerplate setup
        recyclerView = findViewById(R.id.rv_schools_list);
        searchView = findViewById(R.id.searchView);
        schoolAdapter = new SchoolsListAdapter();
        schoolAdapter.setListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(schoolAdapter);
        fragmentManager = getSupportFragmentManager();


        //Get the Viewmodel instance
        model = new ViewModelProvider(this).get(SchoolViewModel.class);

        //Observe Viewmodel, which will trigger the network call
        model.getListOfSchools().observe(this, listOfSchools -> {
            schoolAdapter.setDataSet(listOfSchools);
            setSearchListener();
        });
    }

    /**
     * Under construction
     */
    private void setSearchListener() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //TODO: apply search term to Filter
                return false;
            }
        });
    }

    @Override
    public void onClick(SchoolSATData school) {
        Log.d(TAG, "onClick: adding fragment");

        Fragment fragment = new DetailviewFragment(school);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_fragment, fragment, null);
        fragmentManager.popBackStack();             //Pop last fragment off the backstack to prevent multiple stacking
        fragmentTransaction.addToBackStack(null);   //Add to backstack for intuitive "Back" controls
        fragmentTransaction.commit();
    }
}
