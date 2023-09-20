
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johan
 */
public class PracticaWeb01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //ConexionDB c = new ConexionDB();
        ConexionDB con = ConexionDB.getInstance();
        String sql="insert into empleado(clave, nombre, direccion, telefono)"
                + "values('2', 'Johan', 'av3', '2222')";
        
        boolean res= con.execute(sql);
        if(res)
            Logger.getLogger("Principal").log(Level.INFO, "Se guardo");
        else
            Logger.getLogger("Principal").log(Level.WARNING, "Error ");
    }
    
}
