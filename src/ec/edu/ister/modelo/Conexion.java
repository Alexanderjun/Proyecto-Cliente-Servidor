/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ister.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;  

/**
 *
 * @author Alexander Legña - Ivan Correa
 */
public class Conexion {

    private Connection cn = null;
    private String host = "jdbc:mysql://sql10.freemysqlhosting.net/sql10281193";
    private String usuario = "sql10281193";
    private String clave = "fpJ451QqAf";

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // parametros de la base de datos
            cn = DriverManager.getConnection(this.host, this.usuario, this.clave);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            e.toString();
            JOptionPane.showMessageDialog(null, "Soluciones problemas con el servidor de Base de Datos....");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

}
