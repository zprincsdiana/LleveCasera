package com.anys.lleve_casera_dv;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PrincipalActivity extends AppCompatActivity
    /*implements NavigationView.OnNavigationItemSelectedListener*/{

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Boton Float
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
         /*Passing each menu ID as a set of Ids because each
         menu should be considered as top level destinations.
         Aquí colocamos los id de los fragment a los que queremos que muestre el menú

         //R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
         */
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.perfilFragment,R.id.productosFragment,
                R.id.mercadoFragment,R.id.agenciaFragment,R.id.carritoFragment)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.content_principal);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        /*navigationView.setNavigationItemSelectedListener(this);*/
        navigationView.setItemIconTintList(null); //Para que no se vea el fondo gris de los iconos del menú al ejecutar la app

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.content_principal);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item){
    //Fragment view del menu principal

        int id = item.getItemId(); //va a obtener el id que seleccionemos
        //Llama al fragment
        FragmentManager fragment = getSupportFragmentManager();

        if (id == R.id.perfilFragment){
            fragment.beginTransaction().replace(R.id.content_principal,new PerfilFragment()).commit();
        }else if (id == R.id.productosFragment){
            fragment.beginTransaction().replace(R.id.content_principal,new ProductosFragment()).commit();
        }else if (id == R.id.mercadoFragment){
            fragment.beginTransaction().replace(R.id.content_principal,new MercadoFragment()).commit();
        }else if (id == R.id.carritoFragment){
            fragment.beginTransaction().replace(R.id.content_principal,new CarritoFragment()).commit();
        }else if (id == R.id.agenciaFragment){
            fragment.beginTransaction().replace(R.id.content_principal,new AgenciaFragment()).commit();
        }else if (id == R.id.nav_log_out){

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }*/



}