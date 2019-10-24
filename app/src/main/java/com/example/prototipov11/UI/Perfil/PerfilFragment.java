package com.example.prototipov11.UI.Perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.prototipov11.R;

public class PerfilFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.perfil_fragment, container, false);

        final TextView perfilNome = (TextView) view.findViewById(R.id.perfil_nome);

        PerfilViewModel model = ViewModelProviders.of(getActivity()).get(PerfilViewModel.class);

        model.getDados().observe(this, new Observer<Bundle>() {
            @Override
            public void onChanged(Bundle bundle) {
                perfilNome.setText(bundle.getString("nome", ""));
            }
        });

        return view;
    }

}
