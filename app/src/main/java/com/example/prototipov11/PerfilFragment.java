package com.example.prototipov11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class PerfilFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.perfil_fragment, container, false);



        PerfilViewModel model = ViewModelProviders.of(getActivity()).get(PerfilViewModel.class);

        model.getDados().observe(this, new Observer<Bundle>() {
            @Override
            public void onChanged(Bundle bundle) {

            }
        });

        return view;
    }

}
