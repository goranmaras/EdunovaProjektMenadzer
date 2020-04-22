/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni;

import hr.goranmaras.projektmenadzerzavrsni.util.HibernateUtil;
import hr.goranmaras.projektmenadzerzavrsni.util.Pomocno;
import hr.goranmaras.projektmenadzerzavrsni.util.slack.SlackPoruka;
import hr.goranmaras.projektmenadzerzavrsni.util.slack.SlackUtil;
import hr.goranmaras.projektmenadzerzavrsni.view.SplashScreen;

/**
 *
 * @author Abraxas
 */
public class Start {
    
    public Start(){
       // Pomocno.pocetniInsert();
       new SplashScreen().setVisible(true);
       // Pomocno.dodajDjelatnika(200);
       
       
       
    }
    
    public static void main(String[] args) {
        new Start();
    }
}
