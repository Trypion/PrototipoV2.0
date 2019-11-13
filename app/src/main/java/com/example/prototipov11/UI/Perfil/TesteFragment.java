package com.example.prototipov11.UI.Perfil;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prototipov11.R;

public class TesteFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teste, container, false);

        PerfilViewModel model = ViewModelProviders.of(getActivity()).get(PerfilViewModel.class);

        model.getValidade().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("teste", s);
            }
        });

        return view;
    }

}
