/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ister.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ec.edu.ister.modelo.ParteComputadora;

/**
 *
 * @author Alexander
 */
public class PartesComputadora extends Conexion {

    static PreparedStatement preparedStatement = null; // modificar la base de datos
    static ResultSet resultSet = null; // primero saco una consulta *
    Connection conexion = getConexion(); // para llamar a la conexion
    
    public boolean registrarPartes(PartesComputadora obParteComp){
        String queryRegistro = "";
        try {
            return true;
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        finally{  //se ejecute bien o mal se ejecuta este codigo
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    return false;
    }
    
    
}
