package com.anys.lleve_casera_dv;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

class C_ConexionBD {
    public Connection cadena_conexión(){
        Connection cn= null;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            cn= DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.20:1433;databaseName=DBLLeveCasera;user=sa;password=123;");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
}
