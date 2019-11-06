package com.example.prototipov11.UI.Guia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.prototipov11.R;

public class GuiaFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.guia_fragment, container, false);

        Spinner spinner = view.findViewById(R.id.spinner_guia);
        spinner.setOnItemSelectedListener(this);

        webView = (WebView) view.findViewById(R.id.webview_guia);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.guias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String selecionado = adapterView.getItemAtPosition(i).toString();

        switch (selecionado) {
            case "Acionando o CBMSC":
                webView.loadUrl("https://www.cbm.sc.gov.br/index.php/prevencao/acionando-o-cbmsc");
                break;

            case "Afogamentos":
                webView.loadUrl("https://www.cbm.sc.gov.br/index.php/prevencao/afogamentos");
                break;

            case "Animais Peçonhentos":
                webView.loadUrl("https://www.cbm.sc.gov.br/index.php/prevencao/animais-peconhentos");
                break;

            case "Cuidado com Crianças":
                webView.loadUrl("https://www.cbm.sc.gov.br/index.php/prevencao/cuidados-com-criancas");
                break;

            case "Cuidado com Idosos":
                webView.loadUrl("https://www.cbm.sc.gov.br/index.php/prevencao/cuidados-com-idosos");
                break;

            case "Elevadores":
                webView.loadUrl("https://www.cbm.sc.gov.br/index.php/prevencao/elevadores");
                break;

            case "Fogos de Artificio":
                webView.loadUrl("https://www.cbm.sc.gov.br/index.php/prevencao/fogos-de-artificio");
                break;

            case "Inundações":
                webView.loadUrl("https://www.cbm.sc.gov.br/index.php/prevencao/inundacoes");
                break;

            case "Instalações de Gás":
                webView.loadUrl("https://www.cbm.sc.gov.br/index.php/prevencao/instalacoes-de-gas");
                break;

            case "Prevenções a Incêndios":
                webView.loadUrl("https://www.cbm.sc.gov.br/index.php/prevencao/prevencao-a-incendios");
                break;

            case "Primeiros Socorros":
                webView.loadUrl("https://www.cbm.sc.gov.br/index.php/prevencao/primeiros-socorros");
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
