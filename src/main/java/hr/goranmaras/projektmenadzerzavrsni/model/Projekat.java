/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Abraxas
 */
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "projekat")
public class Projekat extends Entitet{
    @OneToOne
    private Klijent klijent;
    private String naziv;
    private Date vrijemePocetka;
    private Date vrijemeZavrsetka;
    private Integer brZadataka;

    @Override
    public String toString() {
        return naziv;
    }

    
    
}
