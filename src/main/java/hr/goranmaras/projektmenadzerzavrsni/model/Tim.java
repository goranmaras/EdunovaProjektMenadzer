/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.model;

import java.util.ArrayList;
import java.util.List;
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
@Table(name = "tim")
public class Tim extends Entitet{
    
    private String nazivTima;
    private Integer brClanova;
    
    @OneToMany(mappedBy = "tim")
    private List<Zadatak> zadatci = new ArrayList<>();
    
    @OneToMany(mappedBy = "tim")
    private List<ClanTima> clanovi = new ArrayList<>();

   
    @Override
    public String toString() {
        return getNazivTima();
    }
    
    
    
}
