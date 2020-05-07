package com.example.a20200507_jessosborn_nycschools.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.a20200507_jessosborn_nycschools.R;
import com.example.a20200507_jessosborn_nycschools.ViewModel.SchoolSATData;

/**
 * A simple Fragment with 4 textviews to display detail information on a chosen School
 */
public class DetailviewFragment extends Fragment {

    private String TAG = "DetailviewFragment";

    private SchoolSATData school;

    public DetailviewFragment(SchoolSATData school) {
        this.school = school;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        tvNumTesters.setText(getString(R.string.number_of_testers) + school.getNumOfSatTestTakers());
        tvAvgReading.setText(getString(R.string.avg_reading_score) + school.getSatCriticalReadingAvgScore());
        tvAvgMath.setText(getString(R.string.avg_math_score) + school.getSatMathAvgScore());
        tvAvgWriting.setText(getString(R.string.avg_writing_score) + school.getSatWritingAvgScore());

        return view;
    }
}
