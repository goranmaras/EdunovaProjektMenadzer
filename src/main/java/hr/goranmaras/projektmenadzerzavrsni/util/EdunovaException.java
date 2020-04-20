/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.util;

/**
 *
 * @author Profesor
 */

public class EdunovaException extends Exception{
    
    private String poruka;

    public EdunovaException(String poruka) {
        this.poruka=poruka;
    }

    public String getPoruka() {
        return poruka;
    }
    
    
    
}
