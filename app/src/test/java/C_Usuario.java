import android.content.Intent;
import android.widget.Toast;

import com.anys.lleve_casera_dv.LoginActivity;
import com.anys.lleve_casera_dv.PrincipalActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class C_Usuario extends C_Conexion_BD {
    Connection cn=cadena_conexión();

    public int getByPhonePsw(String cel, String psw){
        int resultado = 0;
        try {
            String SSQL = "Select * From Usuario Where celularUsuario='"+cel+"' AND contraseñaUsuario='"+psw+"';";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            if (rs.next()) {
                resultado=1;
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                ex.getMessage();
                ex.printStackTrace();
            }
        }
        return resultado;
    }


}