package com.example.prototipov11.UI.Perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.prototipov11.R;

public class CadastroFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cadastro_itens, container, false);

        Spinner spinner = view.findViewById(R.id.spinner_cad);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.equipamentos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        imageView = (ImageView) view.findViewById(R.id.img_tuto);

        Button btn_mapa = (Button) view.findViewById(R.id.btn_map);
        btn_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new MapCadFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selecionado = adapterView.getItemAtPosition(i).toString();
        //ImageView imageView = (ImageView) view.findViewById(R.id.img_tuto);

        switch (selecionado){
            case "Válvula":
                imageView.setImageResource(R.drawable.valvula_validade);
                break;
            case "Mangueira":
                imageView.setImageResource(R.drawable.mangueira_validade);
                break;
            case "Extintor":
                imageView.setImageResource(R.drawable.validade_extintor);
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
