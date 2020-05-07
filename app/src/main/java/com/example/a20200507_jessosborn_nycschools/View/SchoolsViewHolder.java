package com.example.a20200507_jessosborn_nycschools.View;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20200507_jessosborn_nycschools.Model.SchoolSATData;
import com.example.a20200507_jessosborn_nycschools.R;

public class SchoolsViewHolder extends RecyclerView.ViewHolder {

    private TextView tvSchoolName;

    public SchoolsViewHolder(@NonNull View itemView) {
        super(itemView);
        tvSchoolName = itemView.findViewById(R.id.tv_school_name);
    }

    public void onBind(final SchoolSATData school, final ShowAllDataInterface listener) {
        tvSchoolName.setText(school.getSchoolName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.openDetailedView(school);
            }
        });
    }
}