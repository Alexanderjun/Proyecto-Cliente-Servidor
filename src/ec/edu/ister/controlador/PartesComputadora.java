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
import javax.swing.JOptionPane;

/**
 *
 * @author Alexander Legña  - Ivan Correa - SOFHARD
 */
public class PartesComputadora extends Conexion {
    
    //ec.edu.ister.modelo
    ParteComputadora pC = new ParteComputadora();
    
    
    static PreparedStatement preparedStatement = null; // modificar la base de datos
    static ResultSet resultSet = null; // primero saco una consulta *
    Connection conexion = getConexion(); // para llamar a la conexion
    
    public boolean setRegistraParteComputadora(String codPart, String serPart, String nomPart, String detPart, double prePart, String modPart, String fabPart) {
       
        pC.setCodPart(codPart);
        pC.setSerPart(serPart);
        pC.setNomPart(nomPart);
        pC.setDetPart(detPart);
        pC.setPrePart(prePart);
        pC.setModPart(modPart);
        pC.setFabPart(fabPart);

        if (registraParteComputadora(pC)) 
        {
            System.out.println("Bien");
            return true;
        } 
        else 
        {
            System.out.println("Error");
            return false;
        }
        
    }
    
        
    public boolean registraParteComputadora(ParteComputadora obParteComp){

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection conexion = getConexion();

        String queryRegistro = "INSERT INTO partesComputadora (codPart,serPart,nomPart,detPart,prePart,modPart,fabPart) VALUES(?,?,?,?,?,?,?);";    
        try 
        {
            preparedStatement = conexion.prepareStatement(queryRegistro);
            preparedStatement.setString(1, obParteComp.getCodPart());
            preparedStatement.setString(2, obParteComp.getSerPart());
            preparedStatement.setString(3, obParteComp.getNomPart());
            preparedStatement.setString(4, obParteComp.getDetPart());
            preparedStatement.setDouble(5, obParteComp.getPrePart());
            preparedStatement.setString(6, obParteComp.getModPart());
            preparedStatement.setString(7, obParteComp.getFabPart());
            
            preparedStatement.execute();
            
            return true;
            
        } 
        catch (SQLException evt) 
        {
            System.out.println(evt.toString());
        }
        finally
        { 
            try 
            {
                conexion.close();
            } 
            catch (SQLException evt) 
            {
                System.out.println(evt.toString());
            }
        }
    return false;
    }
    
    
    public boolean setModificaParteComputadora(String codPart, String serPart, String nomPart, String detPart, double prePart, String modPart, String c) {
        
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection conexion = getConexion();
        
        
        String queryModifica = "UPDATE partesComputadora SET serPart='"+serPart+"',nomPart='"+nomPart+"',detPart='"+detPart+"',prePart='"+prePart+"',modPart='"+modPart+"',modPart='"+modPart+"' WHERE codPart='"+codPart+"';";

        try 
        {
            preparedStatement = conexion.prepareStatement(queryModifica);
            
            preparedStatement.execute();
            
            return true;
        } 
        catch (SQLException evt) 
        {
            System.out.println(evt.getMessage());
            return false;
        } 
        finally 
        {
            try 
            {
                conexion.close();
            } 
            catch (SQLException evt) 
            {
                System.out.println(evt.getMessage());
            }
        }
    }
    
    
    
    public boolean setEliminarParteComputadora(String codPart) {
        
        ResultSet resultSet = null;        
        PreparedStatement preparedStatement = null;
        Connection conexion = getConexion();
        
        String queryEliminar = "DELETE FROM partesComputadora WHERE  codPart='"+codPart+"';";
        
        try 
        {
            preparedStatement = conexion.prepareStatement(queryEliminar);
            
            preparedStatement.executeUpdate();
            
            return true;
        } 
        catch (SQLException evt) 
        {
            System.out.println(evt.getMessage());
            return false;
        } 
        finally 
        {
            try 
            {
                conexion.close();
            } 
            catch (SQLException evt) 
            {
                System.out.println(evt.getMessage());
            }
        }
    }
    
    
            
    
    
}
