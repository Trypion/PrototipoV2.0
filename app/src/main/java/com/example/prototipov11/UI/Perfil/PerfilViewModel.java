package com.example.prototipov11.UI.Perfil;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerfilViewModel extends ViewModel {

    private final MutableLiveData<String> validade = new MutableLiveData<String>();

    private final MutableLiveData<String> email = new MutableLiveData<String>();

    private final MutableLiveData<String> gps = new MutableLiveData<String>();

    private final MutableLiveData<String> item = new MutableLiveData<String>();

    public  void setItem (String string){
        item.setValue(string);
    }

    public void setEmail (String string){
        email.setValue(string);
    }

    public void setGps (String string){
        email.setValue(string);
    }

    public void setValidade (String string){
        validade.setValue(string);
    }

    public LiveData<String> getItem(){
        return item;
    }

    public LiveData<String> getEmail (){
        return email;
    }

    public LiveData<String> getGps (){
        return gps;
    }

    public LiveData<String> getValidade (){
        return validade;
    }

}
