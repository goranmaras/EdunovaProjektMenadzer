/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.controller;

import hr.goranmaras.projektmenadzerzavrsni.model.Operater;
import hr.goranmaras.projektmenadzerzavrsni.util.EdunovaException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Abraxas
 */
public class ObradaOperater extends ObradaOsoba<Operater>{

    public ObradaOperater() {
        super();
    }

    public ObradaOperater(Operater entitet) {
        super(entitet);
    }
    
    public Operater autoriziraj(String email, String lozinka){
         
        List<Operater> lista = session.createQuery("from Operater o "
                + " where o.email=:email")
                .setParameter("email", email).list();
        if(lista==null || lista.isEmpty()){
            return null;
        }
        Operater o = lista.get(0);
        if(o==null){
            return null;
        }
        
        return BCrypt.checkpw(lozinka, o.getLozinka()) ? o : null;
    }
    
    @Override
    public List<Operater> getPodaci() {
        return session.createQuery("from Operater").list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
       kontrolaEmail();
       kontrolaLozinka();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    @Override
    protected void nakonSpremanja() throws EdunovaException {
        
    }

    private void kontrolaLozinka() throws EdunovaException{
        if(entitet.getLozinka()==null || entitet.getLozinka().trim().length()==0){
            throw new EdunovaException("Obavezno lozinka");
        }
    }
   
    
}
