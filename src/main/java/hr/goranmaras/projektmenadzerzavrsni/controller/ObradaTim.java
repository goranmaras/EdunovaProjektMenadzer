/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.controller;

import hr.goranmaras.projektmenadzerzavrsni.model.Tim;
import hr.goranmaras.projektmenadzerzavrsni.util.EdunovaException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraxas
 */
public class ObradaTim extends Obrada<Tim>{

    public ObradaTim(Tim entitet) {
        super(entitet);
    }
    
    public ObradaTim() {
        super();
    }

    @Override
    public Tim update() throws EdunovaException {
        kontrolaCreate();
        save();
        nakonSpremanja();
        return entitet;
    }

    @Override
    public Tim create() throws EdunovaException {
        kontrolaCreate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
    private void save() {
        session.beginTransaction();
        session.save(entitet);
         entitet.getZadatci().forEach((z)->{
            session.save(z);
        });
         entitet.getClanovi().forEach((c)->{
            session.save(c);
        });
        session.getTransaction().commit();
    }
    
    public void ocistiClanove(){
        session.beginTransaction();
        entitet.getClanovi().forEach((c)->{
            session.delete(c);
        });
         session.getTransaction().commit();
        entitet.setClanovi(new ArrayList<>());
    }
    
    public void ocistiZadatke(){
        session.beginTransaction();
        entitet.getZadatci().forEach((c)->{
            session.delete(c);
        });
         session.getTransaction().commit();
        entitet.setZadatci(new ArrayList<>());
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
    public List<Tim> getPodaci() {
        return session.createQuery("from Tim").list();
    }

    @Override
    protected void nakonSpremanja() throws EdunovaException {
    }
    
}
