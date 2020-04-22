/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.view;

import hr.goranmaras.projektmenadzerzavrsni.controller.ObradaClanTima;
import hr.goranmaras.projektmenadzerzavrsni.controller.ObradaDjelatnik;
import hr.goranmaras.projektmenadzerzavrsni.controller.ObradaTim;
import hr.goranmaras.projektmenadzerzavrsni.controller.ObradaZadatak;
import hr.goranmaras.projektmenadzerzavrsni.model.ClanTima;
import hr.goranmaras.projektmenadzerzavrsni.model.Djelatnik;
import hr.goranmaras.projektmenadzerzavrsni.model.Tim;
import hr.goranmaras.projektmenadzerzavrsni.model.Zadatak;
import hr.goranmaras.projektmenadzerzavrsni.util.EdunovaException;
import hr.goranmaras.projektmenadzerzavrsni.util.Pomocno;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Abraxas
 */
public class ViewTim extends javax.swing.JFrame {

    private final ObradaTim obrada;
    private final ObradaDjelatnik obradaDjelatnik;
    
    /**
     * Creates new form ViewTim
     */
    public ViewTim() {
        initComponents();
        obrada = new ObradaTim();
        obradaDjelatnik = new ObradaDjelatnik();
        postInitComponents();
        obrada.setEntitet(new Tim());
    }

    private void postInitComponents() {
       setTitle("Timovi - "+ Pomocno.LOGIRAN.getPrezime());
       ucitaj();
    }
    
    private void ucitaj() {
        DefaultListModel<Tim> d = new DefaultListModel<>();
        obrada.getPodaci().forEach(s->d.addElement(s));
        lstPodaci.setModel(d);
    }
    
    
    private void postaviVrijednosti() {
        txtNazivTima.setText(obrada.getEntitet().getNazivTima());
        postaviClanoveTima();
        txtBrClanova.setText(Pomocno.getFormatCijelogBroja(lstClanTima.getModel().getSize()));
        postaviZadatke();
    }
    
    private void ucitajVrijednosti() {
       obrada.getEntitet().setNazivTima(txtNazivTima.getText());
       obrada.getEntitet().setBrClanova(Pomocno.getCijeliBrojIzStringa(txtBrClanova.getText()));
       try {
            DefaultListModel<ClanTima> m = (DefaultListModel<ClanTima>)lstClanTima.getModel();
            DefaultListModel<Zadatak> z = (DefaultListModel<Zadatak>)lstZadatci.getModel();
            obrada.ocistiClanove();
            obrada.ocistiZadatke();
            for(int i=0;i<m.getSize();i++){
                obrada.getEntitet().getClanovi().add(m.get(i));
            }
            for(int i=0;i<z.getSize();i++){
                obrada.getEntitet().getZadatci().add(z.get(i));
            }
        } catch (Exception e) {
            
        }
        
    }
    
    private void postaviClanoveTima() {
        DefaultListModel<ClanTima> m = new DefaultListModel<>();
        obrada.getEntitet().getClanovi().forEach(c -> {
            m.addElement(c);
        });
        lstClanTima.setModel(m);
    }
    
    private void postaviZadatke() {
        DefaultListModel<Zadatak> m = new DefaultListModel<>();
        obrada.getEntitet().getZadatci().forEach(c -> {
            m.addElement(c);
        });
        lstZadatci.setModel(m);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstClanTima = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtNazivTima = new javax.swing.JTextField();
        btnDodajNovi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnPromjeni = new javax.swing.JButton();
        txtBrClanova = new javax.swing.JTextField();
        btnObrisi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUvjet = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstZadatci = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstDjelatnika = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstClanTima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstClanTimaMouseClicked(evt);
            }
        });
        lstClanTima.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstClanTimaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstClanTima);

        jLabel1.setText("Naziv Tima");

        btnDodajNovi.setText("Dodaj novi");
        btnDodajNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajNoviActionPerformed(evt);
            }
        });

        jLabel2.setText("Broj Clanova");

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        txtBrClanova.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBrClanova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrClanovaActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstPodaci);

        jLabel5.setText("Clan tima");

        jLabel6.setText("Lista Djelatnika");

        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKeyPressed(evt);
            }
        });

        btnTrazi.setText("Traži");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        lstZadatci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstZadatciMouseClicked(evt);
            }
        });
        lstZadatci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstZadatciValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lstZadatci);

        jLabel7.setText("Zadatci tima");

        lstDjelatnika.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstDjelatnikaMouseClicked(evt);
            }
        });
        lstDjelatnika.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDjelatnikaValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(lstDjelatnika);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodajNovi)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromjeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(txtNazivTima, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(txtBrClanova, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnTrazi)
                        .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(968, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNazivTima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBrClanova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnObrisi)
                                    .addComponent(btnPromjeni)
                                    .addComponent(btnDodajNovi)))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTrazi)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstClanTimaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstClanTimaValueChanged

    }//GEN-LAST:event_lstClanTimaValueChanged

    private void btnDodajNoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajNoviActionPerformed
        try {
            obrada.setEntitet(new Tim());
            ucitajVrijednosti();
            obrada.create();
            ucitaj();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(null, ex.getPoruka());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnDodajNoviActionPerformed

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

    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
        
            ucitajDjelatnike();
        
    }//GEN-LAST:event_txtUvjetKeyPressed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        ucitajDjelatnike();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void lstClanTimaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstClanTimaMouseClicked
        if (evt.getClickCount() == 2) {
            int index = lstClanTima.locationToIndex(evt.getPoint());
            
            DefaultListModel<ClanTima> m = (DefaultListModel<ClanTima>) lstClanTima.getModel();
            m.remove(index);
            
            lstClanTima.repaint();
            
        }
    }//GEN-LAST:event_lstClanTimaMouseClicked

    private void txtBrClanovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrClanovaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBrClanovaActionPerformed

    private void lstZadatciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstZadatciMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lstZadatciMouseClicked

    private void lstZadatciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstZadatciValueChanged
       
    }//GEN-LAST:event_lstZadatciValueChanged

    private void lstDjelatnikaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstDjelatnikaMouseClicked
        if (evt.getClickCount() == 2) {
            int index = lstDjelatnika.locationToIndex(evt.getPoint());
            Djelatnik p = lstDjelatnika.getModel().getElementAt(index);
            
            try {
                DefaultListModel<ClanTima> m = (DefaultListModel<ClanTima>) lstClanTima.getModel();
              for(int i=0;i<m.getSize();i++){
                  if(m.get(i).getDjelatnik().getSifra().equals(p.getSifra())){
                      return;
                  }
              } 
            } catch (Exception e) {
            }
             
            
    
            
            ClanTima c = new ClanTima();
            c.setDjelatnik(p);
            c.setTim(obrada.getEntitet());
            DefaultListModel<ClanTima> m;
            
            try {
                m = (DefaultListModel<ClanTima>) lstClanTima.getModel();
            } catch (Exception e) {
                m = new DefaultListModel<>();
                lstClanTima.setModel(m);
            }
            
            m.addElement(c);
            lstClanTima.repaint();
            
        }
    }//GEN-LAST:event_lstDjelatnikaMouseClicked

    private void lstDjelatnikaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDjelatnikaValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lstDjelatnikaValueChanged

    private void ucitajDjelatnike() {
        DefaultListModel<Djelatnik> m = new DefaultListModel<>();
        obradaDjelatnik.getPodaci(txtUvjet.getText().trim()).forEach(s -> m.addElement(s));
        lstDjelatnika.setModel(m);
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajNovi;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<ClanTima> lstClanTima;
    private javax.swing.JList<Djelatnik> lstDjelatnika;
    private javax.swing.JList<Tim> lstPodaci;
    private javax.swing.JList<Zadatak> lstZadatci;
    private javax.swing.JTextField txtBrClanova;
    private javax.swing.JTextField txtNazivTima;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables

    
}
