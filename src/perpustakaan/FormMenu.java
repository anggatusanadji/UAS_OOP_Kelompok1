/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.awt.ComponentOrientation;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Angga
 */
public class FormMenu extends javax.swing.JFrame {

    /**
     * Creates new form FormMenu
     */
    public FormMenu() {
        initComponents();
        setLocationRelativeTo(null);
        
        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(logout);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuJurusan = new javax.swing.JMenu();
        MenuMahasiswa = new javax.swing.JMenu();
        MenuBuku = new javax.swing.JMenu();
        MenuPeminjaman = new javax.swing.JMenu();
        MenuUser = new javax.swing.JMenu();
        MenuDataDiri = new javax.swing.JMenu();
        logout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 891, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        MenuJurusan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Data Jurusan.png"))); // NOI18N
        MenuJurusan.setText("DATA JURUSAN");
        MenuJurusan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuJurusanMouseClicked(evt);
            }
        });
        jMenuBar1.add(MenuJurusan);

        MenuMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Data Siswa.png"))); // NOI18N
        MenuMahasiswa.setText("DATA MAHASISWA");
        MenuMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMahasiswaMouseClicked(evt);
            }
        });
        jMenuBar1.add(MenuMahasiswa);

        MenuBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Data Mapel.png"))); // NOI18N
        MenuBuku.setText("DATA BUKU");
        MenuBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuBukuMouseClicked(evt);
            }
        });
        jMenuBar1.add(MenuBuku);

        MenuPeminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Data Nilai.png"))); // NOI18N
        MenuPeminjaman.setText("DATA PEMINJAMAN");
        MenuPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPeminjamanMouseClicked(evt);
            }
        });
        jMenuBar1.add(MenuPeminjaman);

        MenuUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Data User.png"))); // NOI18N
        MenuUser.setText("DATA USER");
        MenuUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuUserMouseClicked(evt);
            }
        });
        jMenuBar1.add(MenuUser);

        MenuDataDiri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Data Diri.png"))); // NOI18N
        MenuDataDiri.setText("DATA KELOMPOK");
        MenuDataDiri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuDataDiriMouseClicked(evt);
            }
        });
        jMenuBar1.add(MenuDataDiri);

        logout.setForeground(new java.awt.Color(51, 51, 51));
        logout.setText("LOGOUT");
        logout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(logout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuJurusanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuJurusanMouseClicked
        // TODO add your handling code here:
        FormJurusan jurusan=new FormJurusan();
        jPanel1.add(jurusan);
        jurusan.setVisible(true);
    }//GEN-LAST:event_MenuJurusanMouseClicked

    private void MenuBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBukuMouseClicked
        // TODO add your handling code here:
        FormBuku buku=new FormBuku();
        jPanel1.add(buku);
        buku.setVisible(true);
    }//GEN-LAST:event_MenuBukuMouseClicked

    private void MenuMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMahasiswaMouseClicked
        // TODO add your handling code here:
        FormMahasiswa mahasiswa=new FormMahasiswa();
        jPanel1.add(mahasiswa);
        mahasiswa.setVisible(true);
    }//GEN-LAST:event_MenuMahasiswaMouseClicked

    private void MenuDataDiriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuDataDiriMouseClicked
        // TODO add your handling code here:
        FormDataDiri datadiri=new FormDataDiri();
        jPanel1.add(datadiri);
        datadiri.setVisible(true);
    }//GEN-LAST:event_MenuDataDiriMouseClicked

    private void MenuUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUserMouseClicked
        // TODO add your handling code here:
        FormUser user=new FormUser();
        jPanel1.add(user);
        user.setVisible(true);
    }//GEN-LAST:event_MenuUserMouseClicked

    private void MenuPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPeminjamanMouseClicked
        // TODO add your handling code here:
        FormTransaksi peminjaman=new FormTransaksi();
        jPanel1.add(peminjaman);
        peminjaman.setVisible(true);
    }//GEN-LAST:event_MenuPeminjamanMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null,"Yakin ingin keluar?","Logout",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
            FormLogin login=new FormLogin();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logoutMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuBuku;
    private javax.swing.JMenu MenuDataDiri;
    private javax.swing.JMenu MenuJurusan;
    private javax.swing.JMenu MenuMahasiswa;
    private javax.swing.JMenu MenuPeminjaman;
    private javax.swing.JMenu MenuUser;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu logout;
    // End of variables declaration//GEN-END:variables
}
