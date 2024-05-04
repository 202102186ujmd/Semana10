
package modelo.dominio;
import java.sql.*;

public class conexionBD {
    private Connection conexion;
    public conexionBD(){
        String driver, usuario, clave, url;
        configuracion cnf = new configuracion("datos.txt");
        driver = System.getProperty("driver");
        usuario = System.getProperty("usuario");
        clave = System.getProperty("clave");
        url = System.getProperty("url");
        try{
            Class.forName(driver);
            this.conexion = DriverManager.getConnection(url,usuario,clave);
        }
        catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    public Connection getConexion(){
        return this.conexion;
    }
    public void cerrar(){
        try{
            this.conexion.close();
        }
        catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
}
