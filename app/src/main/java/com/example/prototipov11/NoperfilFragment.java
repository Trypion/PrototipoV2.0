package com.example.prototipov11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class NoperfilFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.noperfil_warning_fragment, container, false);

        Button btn_criar = (Button) view.findViewById(R.id.bt_criaruser);
        btn_criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NovoPerfilFragment novoPerfilFragment = new NovoPerfilFragment();
                trocarFragment(novoPerfilFragment);
            }
        });

        Button btn_possui = (Button) view.findViewById(R.id.bt_possuiuser);
        btn_possui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PerfilFragment perfilFragment = new PerfilFragment();
                trocarFragment(perfilFragment);

            }
        });

        return view;
    }

    private void trocarFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

}
