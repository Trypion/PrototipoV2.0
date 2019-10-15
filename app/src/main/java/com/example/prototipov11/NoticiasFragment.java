package com.example.prototipov11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NoticiasFragment extends Fragment {

    public String[] myDataset = {"Noticia 1","Noticia 2","Noticia 3","Noticia 4","Noticia 5","Noticia 6", "Noticia 7","Noticia 8","Noticia 9"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.noticias_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        RecyclerAdapter adapter = new RecyclerAdapter(myDataset);
        recyclerView.setAdapter(adapter);

        return view;
    }


}
