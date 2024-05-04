
package modelo.dominio;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class operacionesBD {
    private conexionBD cn;
    public operacionesBD(){
        try{
            this.cn = new conexionBD();
        }
        catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    public List<Object[]> consultar(String sql){
         List<Object[]> lst = new ArrayList();
         Statement sentencia;
         ResultSet rs = null;
         int cols;
         Object[] fila;
         try{
             sentencia = this.cn.getConexion().createStatement();
             rs = sentencia.executeQuery(sql);
             cols = rs.getMetaData().getColumnCount();
             while(rs.next()){
                 fila = new Object[cols];
                 for(int i=0;i<cols;i++){
                     fila[i] = rs.getObject(i+1);
                 }
                 lst.add(fila);
             }
             this.cn.cerrar();
         }
         catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return lst;
    } 
    public int ejecutar(String sql){
        int n=0;
        try{
            PreparedStatement ps = this.cn.getConexion().prepareStatement(sql);
            n = ps.executeUpdate();
            this.cn.cerrar();
                    
        }
        catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return n;
    }
    
           
}
