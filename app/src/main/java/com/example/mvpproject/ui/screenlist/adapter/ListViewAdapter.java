package com.example.mvpproject.ui.screenlist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpproject.R;
import com.example.mvpproject.model.Item;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.RecyclerViewHolder> {

    private List<Item> dataList;

    public ListViewAdapter(List<Item> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent,false);
        return new RecyclerViewHolder(view);
    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Item data = dataList.get(position);
        holder.bind(data);
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private TextView id;
        private TextView name;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
        }

        public void bind(Item item) {
            id.setText(item.getId());
            name.setText(item.getName());
        }
    }
}
