/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ister.modelo;

import java.util.Date;

/**
 *
 * @author Alexander
 */
public class ParteComputadora {

    private String codPart;
    private String serPart;
    private String nomPart;
    private String detPart;
    private double prePart;
    private String modPart;
    private Date fabPart = new Date();

    /**
     * @return the codPart
     */
    public String getCodPart() {
        return codPart;
    }

    /**
     * @param codPart the codPart to set
     */
    public void setCodPart(String codPart) {
        this.codPart = codPart;
    }

    /**
     * @return the serPart
     */
    public String getSerPart() {
        return serPart;
    }

    /**
     * @param serPart the serPart to set
     */
    public void setSerPart(String serPart) {
        this.serPart = serPart;
    }

    /**
     * @return the nomPart
     */
    public String getNomPart() {
        return nomPart;
    }

    /**
     * @param nomPart the nomPart to set
     */
    public void setNomPart(String nomPart) {
        this.nomPart = nomPart;
    }

    /**
     * @return the detPart
     */
    public String getDetPart() {
        return detPart;
    }

    /**
     * @param detPart the detPart to set
     */
    public void setDetPart(String detPart) {
        this.detPart = detPart;
    }

    /**
     * @return the prePart
     */
    public double getPrePart() {
        return prePart;
    }

    /**
     * @param prePart the prePart to set
     */
    public void setPrePart(double prePart) {
        this.prePart = prePart;
    }

    /**
     * @return the modPart
     */
    public String getModPart() {
        return modPart;
    }

    /**
     * @param modPart the modPart to set
     */
    public void setModPart(String modPart) {
        this.modPart = modPart;
    }

    /**
     * @return the fabPart
     */
    public Date getFabPart() {
        return fabPart;
    }

    /**
     * @param fabPart the fabPart to set
     */
    public void setFabPart(Date fabPart) {
        this.fabPart = fabPart;
    }
    
    

}
