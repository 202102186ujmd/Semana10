
package modelo.dominio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class configuracion {
   private Properties propiedades;
    private InputStream entrada;
    public configuracion(String archivo){
        String rutaProyecto = new File("").getAbsolutePath() + "\\" + archivo;
        this.propiedades = new Properties();
        try{
            this.entrada = new FileInputStream(rutaProyecto);
            this.propiedades.load(this.entrada);
            System.setProperty("driver", this.propiedades.getProperty("driver"));
            System.setProperty("usuario", this.propiedades.getProperty("usuario"));
            System.setProperty("clave", this.propiedades.getProperty("clave"));
            System.setProperty("url", this.propiedades.getProperty("url"));
        }
        catch(IOException ex){
            System.out.println("Error" + ex.getMessage());
        }
    } 
}
