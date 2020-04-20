/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.model;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author Abraxas
 */
@lombok.Getter
@lombok.Setter
@MappedSuperclass
public abstract class Osoba extends Entitet{
    
    private String ime;
    private String prezime;
    private String email;
    private String brTel;

    @Override
    public String toString() {
        return "Osoba{" + "ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", brTel=" + brTel + '}';
    }
    
    
    
}
