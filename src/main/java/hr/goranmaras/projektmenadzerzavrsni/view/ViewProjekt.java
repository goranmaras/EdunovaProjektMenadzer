/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import hr.goranmaras.projektmenadzerzavrsni.controller.ObradaKlijent;
import hr.goranmaras.projektmenadzerzavrsni.controller.ObradaProjekt;
import hr.goranmaras.projektmenadzerzavrsni.model.Djelatnik;
import hr.goranmaras.projektmenadzerzavrsni.model.Klijent;
import hr.goranmaras.projektmenadzerzavrsni.model.Projekat;
import hr.goranmaras.projektmenadzerzavrsni.util.EdunovaException;
import hr.goranmaras.projektmenadzerzavrsni.util.Pomocno;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Abraxas
 */
public class ViewProjekt extends javax.swing.JFrame {

    private final ObradaProjekt obrada;
    
    /**
     * Creates new form ViewProjekt
     */
    public ViewProjekt() {
        initComponents();
        obrada = new ObradaProjekt();
        postInitComponents();
        DatePickerSettings dps = new DatePickerSettings(new Locale("hr","HR"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy.");
        dpVrijemePocetka.setSettings(dps);
        DatePickerSettings dpsz = new DatePickerSettings(new Locale("hr","HR"));
        dpsz.setFormatForDatesCommonEra("dd.MM.yyyy.");
        dpVrijemeZavrsetka.setSettings(dpsz);
    }

    private void postInitComponents() {
       setTitle("Projekti - "+ Pomocno.LOGIRAN.getPrezime());
       ucitajKlijenta();
        ucitaj();
    }
    
    private void ucitajKlijenta() {
       DefaultComboBoxModel<Klijent> m = new DefaultComboBoxModel<>();
        new ObradaKlijent().getPodaci().forEach(s -> m.addElement(s));
        cmbKlijent.setModel(m);
    }
    
    private void ucitaj() {
        DefaultListModel<Projekat> d = new DefaultListModel<>();
        obrada.getPodaci().forEach(s->d.addElement(s));
        lstPodaci.setModel(d);
    }
    
    private void postaviVrijednosti() {
        txtNazivProjekta.setText(obrada.getEntitet().getNaziv());
        if(obrada.getEntitet().getVrijemePocetka()==null){
            dpVrijemePocetka.setDate(null);
        }else{
            dpVrijemePocetka.setDate(Pomocno.convertToLocalDateViaInstant(obrada.getEntitet().getVrijemePocetka()));
        }
        if(obrada.getEntitet().getVrijemeZavrsetka()==null){
            dpVrijemeZavrsetka.setDate(null);
        }else{
            dpVrijemeZavrsetka.setDate(Pomocno.convertToLocalDateViaInstant(obrada.getEntitet().getVrijemeZavrsetka()));
        }
        txtBrZad.setText(Pomocno.getFormatCijelogBroja(obrada.getEntitet().getBrZadataka()));
        //obrada.getEntitet().setKlijent(cmbKlijent.getModel()
       //         .getElementAt(cmbKlijent.getSelectedIndex()));
        cmbKlijent.setSelectedItem(obrada.getEntitet().getKlijent());
    }

    private void ucitajVrijednosti() {
       obrada.getEntitet().setNaziv(txtNazivProjekta.getText());
       if(dpVrijemePocetka.getDate()!=null){
            Date d = Pomocno.convertToDateViaInstant(dpVrijemePocetka.getDate());
            obrada.getEntitet().setVrijemePocetka(d);
        }
       if(dpVrijemeZavrsetka.getDate()!=null){
            Date d = Pomocno.convertToDateViaInstant(dpVrijemeZavrsetka.getDate());
            obrada.getEntitet().setVrijemeZavrsetka(d);
        }
       obrada.getEntitet().setBrZadataka(Pomocno.getCijeliBrojIzStringa(txtBrZad.getText()));
      // cmbKlijent.setSelectedItem(obrada.getEntitet().getKlijent());
       obrada.getEntitet().setKlijent((Klijent) cmbKlijent.getSelectedItem());
        }
   
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnDodajNovi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBrZad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNazivProjekta = new javax.swing.JTextField();
        cmbKlijent = new javax.swing.JComboBox<>();
        dpVrijemeZavrsetka = new com.github.lgooddatepicker.components.DatePicker();
        dpVrijemePocetka = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Vrijeme početka");

        jLabel4.setText("Vrijeme završetka");

        btnDodajNovi.setText("Dodaj novi");
        btnDodajNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajNoviActionPerformed(evt);
            }
        });

        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel1.setText("Klijent");

        jLabel5.setText("Broj zadataka");

        txtBrZad.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel2.setText("Naziv Projekta");

        txtNazivProjekta.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        cmbKlijent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKlijentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtNazivProjekta, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(txtBrZad, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(cmbKlijent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodajNovi)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromjeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi))
                    .addComponent(dpVrijemeZavrsetka, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpVrijemePocetka, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(cmbKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNazivProjekta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpVrijemePocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpVrijemeZavrsetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBrZad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnObrisi)
                            .addComponent(btnPromjeni)
                            .addComponent(btnDodajNovi))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajNoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajNoviActionPerformed
        try {
            obrada.setEntitet(new Projekat());
            ucitajVrijednosti();
            obrada.create();
            ucitaj();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(null, ex.getPoruka());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnDodajNoviActionPerformed

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
        if(evt.getValueIsAdjusting()){
            return;
        }
        obrada.setEntitet(lstPodaci.getSelectedValue());
        if(obrada.getEntitet()==null){
            return;
        }
        postaviVrijednosti();
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if(obrada.getEntitet()==null){
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }

        ucitajVrijednosti();
        try {
            obrada.update();
            ucitaj();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(null, e.getPoruka());
        }
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if(obrada.getEntitet()==null){
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }
        try {
            obrada.delete();
            ucitaj();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(null, e.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void cmbKlijentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKlijentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKlijentActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajNovi;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JComboBox<Klijent> cmbKlijent;
    private com.github.lgooddatepicker.components.DatePicker dpVrijemePocetka;
    private com.github.lgooddatepicker.components.DatePicker dpVrijemeZavrsetka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Projekat> lstPodaci;
    private javax.swing.JTextField txtBrZad;
    private javax.swing.JTextField txtNazivProjekta;
    // End of variables declaration//GEN-END:variables

    

    
}
