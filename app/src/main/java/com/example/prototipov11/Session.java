package com.example.prototipov11;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {

    private SharedPreferences prefs;

    public Session(Context cntx) {
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setPerfil (boolean perfil){
        prefs.edit().putBoolean("pefil", perfil).apply();
    }

    public boolean getPerfil (){
        boolean perfil = prefs.getBoolean("perfil", false);
        return perfil;
    }

}
