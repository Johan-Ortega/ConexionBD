
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
public class ConexionDB {
    //Singleton
    private static ConexionDB cx = null;
    public static ConexionDB getInstance(){
        if(cx==null)
            cx=new ConexionDB();
    return cx;
    }
    
    private String uri="jdbc:postgresql://localhost:5432/escuela";
    private Connection con = null;
    
    public ConexionDB(){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(uri,"postgres","1234");
            Logger.getLogger(ConexionDB.class.getName()).log(
            Level.INFO,"Se conecto");
        } catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    //Ejecuciones a nuestra base de datos
    public boolean execute(String sql){
          try{
            Statement st= con.createStatement();
            st.execute(sql);
            return true;
          }catch(SQLException ex){
              Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
              return false;
          }
    }
}
