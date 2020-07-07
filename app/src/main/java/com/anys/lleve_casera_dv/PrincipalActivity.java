package com.anys.lleve_casera_dv;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class PrincipalActivity extends AppCompatActivity{
    private AppBarConfiguration mAppBarConfiguration ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

         /*
         Aquí colocamos los id de los fragment a los que queremos que muestre el nav del menú
         */
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.perfilFragment,R.id.productosFragment,
                R.id.mercadoFragment,R.id.agenciaFragment,R.id.carritoFragment,R.id.productoMercadoFragment,
                R.id.elementos_mercadoFragment,R.id.confirmar_compraFragment,R.id.fragmentLogOut)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.content_principal);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setItemIconTintList(null); //Para que no se vea el fondo gris de los iconos del menú al ejecutar la app
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.content_principal);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}