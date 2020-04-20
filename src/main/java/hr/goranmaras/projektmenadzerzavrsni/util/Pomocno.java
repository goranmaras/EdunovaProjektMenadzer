/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.util;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hr.goranmaras.projektmenadzerzavrsni.controller.ObradaDjelatnik;
import hr.goranmaras.projektmenadzerzavrsni.controller.ObradaKlijent;
import hr.goranmaras.projektmenadzerzavrsni.controller.ObradaOperater;
import hr.goranmaras.projektmenadzerzavrsni.controller.ObradaProjekt;
import hr.goranmaras.projektmenadzerzavrsni.controller.ObradaTim;

import hr.goranmaras.projektmenadzerzavrsni.model.ClanTima;
import hr.goranmaras.projektmenadzerzavrsni.model.Djelatnik;
import hr.goranmaras.projektmenadzerzavrsni.model.Klijent;
import hr.goranmaras.projektmenadzerzavrsni.model.Operater;
import hr.goranmaras.projektmenadzerzavrsni.model.Projekat;
import hr.goranmaras.projektmenadzerzavrsni.model.Tim;
import hr.goranmaras.projektmenadzerzavrsni.model.Zadatak;
import hr.goranmaras.projektmenadzerzavrsni.view.ViewDjelatnik;
import hr.goranmaras.projektmenadzerzavrsni.view.ViewKlijent;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Abraxas
 */
public class Pomocno {
    
    private final static DecimalFormat df = df();
    
    public static Operater LOGIRAN;
    
    public static String getNazivAplikacije(){
        return "Edunova APP";
    }
    
     public static Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
          .atZone(ZoneId.systemDefault())
            .toInstant());
    }
    
    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
}
    
    public static String getFormatDecimal(BigDecimal i){
        DecimalFormat dfDecimalniBroj = new DecimalFormat("#,###.00");
        return dfDecimalniBroj.format(i);
    }
    
    public static String getFormatCijelogBroja(long i){
        DecimalFormat dfCijeliBroj = new DecimalFormat("#");
        return dfCijeliBroj.format(i);
    }
    
    public static BigDecimal getDecimalniBrojIzStringa(String s ){
        try {
            return new BigDecimal(df.parse(s).doubleValue());
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }
    
    public static int getCijeliBrojIzStringa(String s){
         try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
    
    
    public static void pocetniInsert() {
        Operater o = new Operater();
        o.setEmail("goranmaras@me.com");
        o.setIme("Goran");
        o.setPrezime("Maras");
        o.setLozinka(BCrypt.hashpw("t", BCrypt.gensalt()));
        
        
        ObradaOperater obradaOperater = new ObradaOperater(o);
        try {
            obradaOperater.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        Djelatnik d = new Djelatnik();
        d.setIme("Goran");
        d.setPrezime("Maras");
        d.setEmail("goran@me.com");
        d.setBrTel("0955249708");
        d.setCijenaSata(new BigDecimal(50));
        d.setProgJezik("Android");
        
        ObradaDjelatnik obradaDjelatnik = new ObradaDjelatnik(d);
        try {
            obradaDjelatnik.create();
        } catch (EdunovaException e) {
            System.out.println(e.getPoruka());
        }
        
        Klijent k = new Klijent();
        k.setIme("Miro");
        k.setPrezime("Mirić");
        k.setEmail("miro@me.com");
        k.setBrTel("0951245343");
        k.setNazivFirme("Code Consulting");
        
        ObradaKlijent obradaKlijent = new ObradaKlijent(k);
        try {
            obradaKlijent.create();
        } catch (EdunovaException e) {
            System.out.println(e.getPoruka());
        }
        
        Projekat pro = new Projekat();
        pro.setKlijent(k);
        pro.setNaziv("Izrada programa za prepoznavanje lica(MLKit)");
        pro.setVrijemePocetka(new Date());
        pro.setVrijemeZavrsetka(new Date());
        pro.setBrZadataka(2);
        
        ObradaProjekt obradaProjekt = new ObradaProjekt(pro);
        try {
            obradaProjekt.create();
        } catch (EdunovaException e) {
            System.out.println(e.getPoruka());
        }
        
        Tim t = new Tim();
        t.setNazivTima("Backendaši");
        t.setBrClanova(7);
        
        Zadatak z = new Zadatak();
        z.setNaziv("Postavljanje programa za prepoznavanje lica");
        z.setProjekat(pro);
        z.setTim(t);
        
        t.getZadatci().add(z);
        
        ClanTima ct = new ClanTima();
        ct.setDjelatnik(d);
        ct.setTim(t);
        
        t.getClanovi().add(ct);
        
        ObradaTim obradaTim = new ObradaTim(t);
        try {
            obradaTim.create();
        } catch (EdunovaException e) {
            System.out.println(e.getPoruka());
        }
        
    }
    
    private static DecimalFormat df(){
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("hr","HR"));
        DecimalFormat dflocal = (DecimalFormat) nf;
        dflocal.applyPattern("#,###.00");
        return dflocal;
    }
    
    public static ViewDjelatnik.Osoba getgenIP() {
        try {
        Gson gson = new Gson(); 
        Type userListType = new TypeToken<ArrayList<ViewDjelatnik.Osoba>>(){}.getType();
        URL url = new URL("https://vit.hr/GIP/API/1/json/prvaSlovaVelika");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        List<ViewDjelatnik.Osoba> lista=gson.fromJson(reader, userListType);
        return lista.get(0);
         } 
        catch (Exception e) {
            return null;
        }
    }
    
    public static ViewKlijent.Osoba getgenIPZaKlijenta() {
        try {
        Gson gson = new Gson(); 
        Type userListType = new TypeToken<ArrayList<ViewKlijent.Osoba>>(){}.getType();
        URL url = new URL("https://vit.hr/GIP/API/1/json/prvaSlovaVelika");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        List<ViewKlijent.Osoba> lista=gson.fromJson(reader, userListType);
        return lista.get(0);
         } 
        catch (Exception e) {
            return null;
        }
    }
    
    /**
     *
     * @param ukupno
     */
    public static void dodajDjelatnika(int ukupno){
        ObradaDjelatnik op;
        op = new ObradaDjelatnik();
        Djelatnik p;
        ViewDjelatnik.Osoba o;
        for(int i=0;i<ukupno;i++){
            p= new Djelatnik();
            o=getgenIP();
            p.setIme(o.getIme());
            p.setPrezime(o.getPrezime());
            try {
                op.setEntitet(p);
                op.create();
            } catch (Exception e) {
            }
        }
    }
    
}
