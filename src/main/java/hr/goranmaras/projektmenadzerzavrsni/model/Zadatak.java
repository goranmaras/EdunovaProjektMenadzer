/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Abraxas
 */
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "zadatak")
public class Zadatak extends Entitet{
    
    private String naziv;
    @ManyToOne
    private Projekat projekat;
    @ManyToOne
    private Tim tim;

    @Override
    public String toString() {
        return naziv; 
    }
    
    

}
