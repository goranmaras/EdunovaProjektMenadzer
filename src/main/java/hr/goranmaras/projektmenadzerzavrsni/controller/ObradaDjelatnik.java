/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.controller;

import hr.goranmaras.projektmenadzerzavrsni.model.Djelatnik;
import hr.goranmaras.projektmenadzerzavrsni.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Abraxas
 */
public class ObradaDjelatnik extends ObradaOsoba<Djelatnik>{

    public ObradaDjelatnik(Djelatnik entitet) {
        super(entitet);
    }

    public ObradaDjelatnik() {
        super();
    }

    
    
    @Override
    protected void kontrolaCreate() throws EdunovaException {
        super.kontrolaCreate();
        kontrolaIstiNaziv();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
    }
    
    @Override
    protected void kontrolaDelete() throws EdunovaException {
    }

    @Override
    public List<Djelatnik> getPodaci() {
        return session.createQuery("from Djelatnik").list();
    }

    public List<Djelatnik> getPodaci(String uvjet){
        return session.createQuery("from Djelatnik p "
                + " where concat(p.ime, ' ', p.prezime) like :uvjet "
                + " or concat(p.prezime, ' ', p.ime) like :uvjet ")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(20).list();
    }
    
    @Override
    protected void nakonSpremanja() throws EdunovaException {
        
    }

    private void kontrolaIstiNaziv() throws EdunovaException {
        //kreirajte kontrolu koja će javiti da isti naziv postoji
      // u bazi i zbog toga neće kreirati novi smjer
    
        for (Djelatnik d : getPodaci()) {
            if(d.getIme().toString().equals(entitet.getIme())&&d.getPrezime().toString().equals(entitet.getPrezime())){
                   throw  new EdunovaException("Djelatnik postoji u bazi, odaberite drugo ime i prezime");
            }
        }
      
    }

    
   
    
    

    
}
