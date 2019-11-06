package com.example.prototipov11.UI.Perfil;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.prototipov11.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class PerfilFragment extends Fragment {

    GoogleSignInClient mGoogleSignInClient;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.perfil_fragment, container, false);

        TextView perfilNome = (TextView) view.findViewById(R.id.perfil_nome);
        ImageView imageView = (ImageView) view.findViewById(R.id.google_img_perfil);

        PerfilViewModel model = ViewModelProviders.of(getActivity()).get(PerfilViewModel.class);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getContext());
        if (acct != null) {
            String personName = acct.getDisplayName();
            Uri personPhoto = acct.getPhotoUrl();

            perfilNome.setText(personName);

            Glide.with(this).load(String.valueOf(personPhoto)).into(imageView);
        }

        /*
        model.getDados().observe(this, new Observer<Bundle>() {
            @Override
            public void onChanged(Bundle bundle) {
                perfilNome.setText(bundle.getString("nome", ""));
            }
        });
        */

        ImageButton btn_novo_item = (ImageButton) view.findViewById(R.id.btn_novo_cad);
        btn_novo_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return view;
    }

}
