package com.example.a20200507_jessosborn_nycschools.View;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20200507_jessosborn_nycschools.Model.SchoolSATData;
import com.example.a20200507_jessosborn_nycschools.R;

import java.util.List;

public class SchoolsListAdapter extends RecyclerView.Adapter<SchoolsViewHolder> {

    private List<SchoolSATData> dataSet;
    private ShowAllDataInterface listener;

    public void setDataSet(List<SchoolSATData> dataSet) {
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
        holder.onBind(dataSet.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }
}
