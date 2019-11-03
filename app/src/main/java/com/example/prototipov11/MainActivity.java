package com.example.prototipov11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.prototipov11.UI.Ajuda.AjudaFragment;
import com.example.prototipov11.UI.Guia.GuiaFragment;
import com.example.prototipov11.UI.Guia.MenuGuiaFragment;
import com.example.prototipov11.UI.Perfil.NoperfilFragment;
import com.example.prototipov11.UI.Perfil.NovoPerfilFragment;
import com.example.prototipov11.UI.Perfil.PerfilFragment;
import com.example.prototipov11.UI.Home.TwitterFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    SharedPreferences sharedPreferences;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TwitterFragment()).commit();

            navigationView.setCheckedItem(R.id.nav_noticia);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = new TwitterFragment();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean perfil = sharedPreferences.getBoolean("perfil", false);


        switch (menuItem.getItemId()) {
            case R.id.nav_cadastro:

                if (perfil) {
                    fragment = new PerfilFragment();
                } else {
                    fragment = new NoperfilFragment();
                }

                break;
            case R.id.nav_guia:
                fragment = new GuiaFragment();

                break;
            case R.id.nav_noticia:
                fragment = new TwitterFragment();

                break;
            case R.id.nav_ajuda:
                fragment = new AjudaFragment();

                break;
            case R.id.nav_contato:
                Toast.makeText(this, "contato feito", Toast.LENGTH_SHORT).show();
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.setting_perfil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        switch (item.getItemId()) {
            case R.id.perfil_excluir:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("perfil", false);
                editor.apply();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NoperfilFragment()).commit();
                navigationView.setCheckedItem(R.id.nav_cadastro);
                return true;

            case R.id.perfil_editar:
                boolean perfil = sharedPreferences.getBoolean("perfil", false);
                if(perfil) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NovoPerfilFragment()).commit();
                    return true;
                }else {
                    Toast.makeText(this, "Nenhum Perfil Cadastrado", Toast.LENGTH_LONG).show();
                    return true;
                }

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
