package com.example.a20200507_jessosborn_nycschools.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.a20200507_jessosborn_nycschools.R;
import com.example.a20200507_jessosborn_nycschools.ViewModel.SchoolSATData;

public class DetailviewFragment extends Fragment {

    private String TAG = "DetailviewFragment";

    private SchoolSATData school;

    public DetailviewFragment(SchoolSATData school) {
        this.school = school;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detailview_fragment, container, false);

        //Assign textviews
        TextView tvSchoolName = view.findViewById(R.id.frag_tv_school_name);
        TextView tvNumTesters = view.findViewById(R.id.frag_tv_num_of_testers);
        TextView tvAvgReading = view.findViewById(R.id.frag_tv_reading);
        TextView tvAvgWriting = view.findViewById(R.id.frag_tv_writing);
        TextView tvAvgMath = view.findViewById(R.id.frag_tv_math);

        tvSchoolName.setText(school.getSchoolName());
        tvNumTesters.setText("Number of Testers \n " + school.getNumOfSatTestTakers());
        tvAvgReading.setText("Avg Reading Score \n" + school.getSatCriticalReadingAvgScore());
        tvAvgMath.setText("Avg Math Score \n" + school.getSatMathAvgScore());
        tvAvgWriting.setText("Avg Writing Score \n" + school.getSatWritingAvgScore());

        return view;
    }
}
