package com.example.prototipov11.UI.Guia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.example.prototipov11.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuGuiaFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_guia, container, false);

        Button btn_elevador = (Button) view.findViewById(R.id.btn_elevadores);
        btn_elevador.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_elevadores:
                Toast.makeText(getContext(), "deu certo", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
