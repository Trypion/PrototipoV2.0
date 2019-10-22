package com.example.prototipov11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class NovoPerfilFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.novo_perfil_fargment, container, false);

        final EditText perfilNome = view.findViewById(R.id.new_perfil_nome);
        final EditText perfilEmail = view.findViewById(R.id.new_perfil_email);
        final EditText perfilTelefone = view.findViewById(R.id.new_perfil_telefone);

        final Bundle perfil = new Bundle();

        Button btnCriar = (Button) view.findViewById(R.id.btn_criar_perfil);
        btnCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                perfil.putString("nome",perfilNome.getText().toString());
                perfil.putString("email", perfilEmail.getText().toString());
                perfil.putString("telefone", perfilTelefone.getText().toString());

                Toast.makeText(getActivity(), "Perfil Criado", Toast.LENGTH_SHORT).show();

                PerfilFragment perfilFragment = new PerfilFragment();

                perfilFragment.setArguments(perfil);

                Session session = new Session(getActivity());
                session.setPerfil(true);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, perfilFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });

        return view;
    }
}
