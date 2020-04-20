/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.controller;

import hr.goranmaras.projektmenadzerzavrsni.model.Zadatak;
import hr.goranmaras.projektmenadzerzavrsni.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Abraxas
 */
public class ObradaZadatak extends Obrada<Zadatak>{
    
    public ObradaZadatak(Zadatak entitet) {
        super(entitet);
    }
    
    public ObradaZadatak() {
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
    public List<Zadatak> getPodaci() {
        return session.createQuery("from Zadatak").list();
    }

    @Override
    protected void nakonSpremanja() throws EdunovaException {
    }
    
}
