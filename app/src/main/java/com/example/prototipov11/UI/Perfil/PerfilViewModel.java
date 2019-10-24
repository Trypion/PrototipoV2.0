package com.example.prototipov11.UI.Perfil;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerfilViewModel extends ViewModel {

    private final MutableLiveData<Bundle> dados = new MutableLiveData<Bundle>();

    public void setDados (Bundle bundle){
        dados.setValue(bundle);
    }

    public LiveData<Bundle> getDados (){
        return dados;
    }

}
