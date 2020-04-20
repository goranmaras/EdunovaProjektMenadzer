/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.controller;

import hr.goranmaras.projektmenadzerzavrsni.model.Klijent;
import hr.goranmaras.projektmenadzerzavrsni.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Abraxas
 */
public class ObradaKlijent extends ObradaOsoba<Klijent>{

    public ObradaKlijent(Klijent entitet) {
        super(entitet);
    }
    
    

    public ObradaKlijent() {
        super();
    }

    
    
    @Override
    protected void kontrolaCreate() throws EdunovaException {
        super.kontrolaCreate(); 
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
    }
    
    @Override
    protected void kontrolaDelete() throws EdunovaException {
    }
    
    @Override
    public List<Klijent> getPodaci() {
        return session.createQuery("from Klijent").list();
    }

    @Override
    protected void nakonSpremanja() throws EdunovaException {
        
    }
    
}
