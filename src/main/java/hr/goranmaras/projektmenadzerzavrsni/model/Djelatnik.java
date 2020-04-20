/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Abraxas
 */
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "djelatnik")
public class Djelatnik extends Osoba{
    
    private BigDecimal cijenaSata;
    private String progJezik;

    @Override
    public String toString() {
        return super.getIme()+" "+super.getPrezime();
    }

    
    
}
