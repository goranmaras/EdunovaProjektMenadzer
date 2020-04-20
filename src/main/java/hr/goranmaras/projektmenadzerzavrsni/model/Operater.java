/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Abraxas
 */
@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "operater")
public class Operater extends Osoba{
    
    private String lozinka;
    
}
