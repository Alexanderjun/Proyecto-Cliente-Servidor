/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ister.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander
 */
public class Conexion {
    
    private Connection conexion = null; 
    public Connection getConexion(){ 
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // parametros de la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/politicos","root","");  
            System.out.println("Conexion exitosa");
        } catch(SQLException e){
            System.err.println( e.toString() );
            System.out.println("No hay acceso al servidor");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      return conexion;  
    }


    
}
