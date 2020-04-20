/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.controller;

import hr.goranmaras.projektmenadzerzavrsni.model.Osoba;
import hr.goranmaras.projektmenadzerzavrsni.util.EdunovaException;

/**
 *
 * @author Abraxas
 * @param <T>
 */
public abstract class ObradaOsoba<T extends Osoba> extends Obrada<T>{
    public ObradaOsoba(T entitet) {
        super(entitet);
    }  

    public ObradaOsoba() {
        super();
    }
    
    

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolabrTel();
        kontrolaEmail();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    } 

    protected void kontrolaEmail()  throws EdunovaException{
       
    }
    
    protected void kontrolabrTel()  throws EdunovaException{
       
    }
}
