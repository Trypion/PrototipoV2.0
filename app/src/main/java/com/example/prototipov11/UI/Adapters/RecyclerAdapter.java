package com.example.prototipov11.UI.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prototipov11.R;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private String[] mDataset;

    public RecyclerAdapter(String[] myDataset){
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.noticia_recycler, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.textView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txv_validade;
        public TextView txv_itemname;
        public ImageView img_item;
        public MyViewHolder(View itemView){
            super(itemView);
            txv_validade = itemView.findViewById(R.id.validade_itemlist);
            txv_itemname = itemView.findViewById(R.id.nome_itemlist);
            img_item = itemView.findViewById(R.id.img_item);

        }
    }




}
