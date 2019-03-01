/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ister.modelo;
 
import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import javax.swing.JOptionPane; 

/**
 *
 * @author Alexander Legña - Ivan Correa
 */
public class PartesComputadora extends Conexion {

    //ec.edu.ister.modelo
    ParteComputadora moldeComputadora = new ParteComputadora(); 
 
    public boolean registraParteComputadora(ParteComputadora obParteComp) {
        Connection cn = getConexion();
        PreparedStatement ps; // modificar la base de datos
        Connection conexion = getConexion();// primero saco una consulta *
        String sql = "INSERT INTO partesComputadora (codPart,serPart,nomPart,detPart,prePart,modPart) VALUES(?,?,?,?,?,?);";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, obParteComp.getCodPart());
            ps.setString(2, obParteComp.getSerPart());
            ps.setString(3, obParteComp.getNomPart());
            ps.setString(4, obParteComp.getDetPart());
            ps.setDouble(5, obParteComp.getPrePart());
            ps.setString(6, obParteComp.getModPart()); 
            ps.execute();
            return true;
        } catch (SQLException evt) {
            evt.getMessage();
        } finally {
            try {
                cn.close();
            } catch (SQLException evt) {
                evt.getMessage();
            }
        }
        return false;
    }
    public boolean setRegistraParteComputadora(String codPart, String serPart, String nomPart, String detPart, double prePart, String modPart) {
        moldeComputadora.setCodPart(codPart);
        moldeComputadora.setSerPart(serPart);
        moldeComputadora.setNomPart(nomPart);
        moldeComputadora.setDetPart(detPart);
        moldeComputadora.setPrePart(prePart);
        moldeComputadora.setModPart(modPart); 
        if ( registraParteComputadora(moldeComputadora) ) {
            JOptionPane.showMessageDialog(null,"Se a ingresado correctamente..!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Error, No se pudo grabar..!"); 
            return false;
        }
    }
    public boolean setModificaParteComputadora(String codPart, String serPart, String nomPart, String detPart, double prePart, String modPart) {
        PreparedStatement ps; 
        Connection cn = getConexion();
        String sql = "UPDATE partesComputadora SET serPart='"+serPart+"',nomPart='"+nomPart+"',detPart='"+detPart+"',prePart='"+prePart+"',modPart='"+modPart+"',modPart='"+modPart+"' WHERE codPart='"+codPart+"';";
        try {
            ps = cn.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null,"Se actualizo correctamente..!");
            return true;
        } catch (SQLException evt) {
            evt.getMessage();
            JOptionPane.showMessageDialog(null,"Error, No se pudo actualizar..!"); 
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException evt) {
                evt.getMessage();
            }
        }
    }
    public boolean setEliminarParteComputadora(String codPart) {
        PreparedStatement ps;
        Connection cn = getConexion();
        String sql = "DELETE FROM partesComputadora WHERE  codPart='"+codPart+"';";
        try {
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (SQLException evt) {
            evt.getMessage();
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException evt) {
                evt.getMessage();
            }
        }
    } 
}
