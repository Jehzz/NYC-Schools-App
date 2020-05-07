package com.example.a20200507_jessosborn_nycschools.View;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20200507_jessosborn_nycschools.Model.SchoolsList;
import com.example.a20200507_jessosborn_nycschools.R;

public class SchoolsListAdapter extends RecyclerView.Adapter<SchoolsViewHolder> {

    private SchoolsList dataSet;
    private ShowAllDataInterface listener;

    public void setDataSet(SchoolsList dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    public void setListener(ShowAllDataInterface listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public SchoolsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SchoolsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolsViewHolder holder, int position) {
        holder.onBind(dataSet.schoolData.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.schoolData.size() : 0;
    }
}
