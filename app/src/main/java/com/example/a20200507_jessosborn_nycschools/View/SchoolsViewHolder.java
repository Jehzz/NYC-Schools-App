package com.example.a20200507_jessosborn_nycschools.View;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20200507_jessosborn_nycschools.Model.SchoolSATData;
import com.example.a20200507_jessosborn_nycschools.R;

public class SchoolsViewHolder extends RecyclerView.ViewHolder {

    private TextView tvSchoolName;
    public String TAG = "SchoolsViewHolder";

    public SchoolsViewHolder(@NonNull View itemView) {
        super(itemView);
        tvSchoolName = itemView.findViewById(R.id.tv_school_name);
    }

    public void onBind(final SchoolSATData school, final ShowAllDataInterface listener) {
        tvSchoolName.setText(school.getSchoolName());

        itemView.setOnClickListener(v -> {
            listener.openDetailedView(school);
            Log.d(TAG, "onClick: " + school.getDbn());
        });
    }
}