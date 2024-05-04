
package modelo.dao;

import java.util.List;
import modelo.dominio.operacionesBD;

public class daoUsuario {
    public boolean validar(String us, String pw){
        boolean r= false;
        String sql = "SELECT username FROM Usuario WHERE username='" + us + "'AND password=MD5('" + pw + "')"; 
        operacionesBD op = new operacionesBD();
        List<Object[]> lst = op.consultar(sql);
        if(lst.size() > 0){
            r = true;
        }
        return r;
    }
}
