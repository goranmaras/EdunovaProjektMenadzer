/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.controller;

import hr.goranmaras.projektmenadzerzavrsni.model.Projekat;
import hr.goranmaras.projektmenadzerzavrsni.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Abraxas
 */
public class ObradaProjekt extends Obrada<Projekat>{

    public ObradaProjekt(Projekat entitet) {
        super(entitet);
    }
    
    public ObradaProjekt() {
        super();
    }
    
    @Override
    protected void kontrolaCreate() throws EdunovaException {
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
    }

    @Override
    public List<Projekat> getPodaci() {
        return session.createQuery("from Projekat").list();
    }

    @Override
    protected void nakonSpremanja() throws EdunovaException {
    }
    
}
