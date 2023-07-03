/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Angga
 */
public class FormTransaksi extends javax.swing.JInternalFrame {
    DefaultTableModel tabModel;
    ResultSet rs=null;
    
    List<String> mahasiswaList = new ArrayList<>();
    List<String> bukuList = new ArrayList<>();
    
    /**
     * Creates new form FormJurusan
     */
    public FormTransaksi() {
        initComponents();
        
        dataCombobox();
 
        refreshTable();
    }
    
    private void refreshTable(){
        try{
            int total = 0;
            Object[] judul_kolom = {"#","Nim", "Nama", "Buku", "Tgl Pinjam", "Tgl Kembali"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            tbPeminjaman.setModel(tabModel);
            
            Connection conn=(Connection)KoneksiDB.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            rs=stt.executeQuery("SELECT * FROM tb_peminjaman JOIN tb_mahasiswa ON tb_peminjaman.nim=tb_mahasiswa.nim JOIN tb_buku ON tb_peminjaman.kode_buku=tb_buku.kode_buku ORDER BY tb_peminjaman.id DESC");  
            while(rs.next()){
                Object[] data={
                    rs.getString("id"),
                    rs.getString("nim"),
                    rs.getString("nama"), 
                    rs.getString("judul_buku"), 
                    rs.getString("tgl_pinjam"),
                    rs.getString("tgl_kembali")
                };
                tabModel.addRow(data);
                
                total++;
            }          
            
            totData.setText("Total Data: "+Integer.toString(total)+" Data");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        TableColumnModel tcm = tbPeminjaman.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0)); 
        
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        jDateTglkembali.setEnabled(false);
    }
    
    //membersihkan form
    private void BersihData(){
        comboMahasiswa.setSelectedIndex(0);
        comboBuku.setSelectedIndex(0);
        jDateTglpinjam.setDate(null);
        jDateTglkembali.setDate(null);
    } 
    
    public void dataCombobox(){
        try {
            Connection conn=(Connection)KoneksiDB.koneksiDB();
            Statement stt=conn.createStatement();
            String sql = "select * from tb_mahasiswa";
            ResultSet res=stt.executeQuery(sql);
            comboMahasiswa.addItem("-Pilih Mahasiswa-");
            while (res.next()) {
                String nim = res.getString(3);
                mahasiswaList.add(nim);
                comboMahasiswa.addItem(nim+" - "+res.getString(4));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    
        try {
            Connection conn=(Connection)KoneksiDB.koneksiDB();
            Statement stt=conn.createStatement();
            String sql = "select * from tb_buku";
            ResultSet res=stt.executeQuery(sql);
            comboBuku.addItem("-Pilih Buku-");
            while (res.next()) {
                String kode_buku = res.getString(2);
                bukuList.add(kode_buku);
                comboBuku.addItem(kode_buku+" - "+res.getString(3));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboMahasiswa = new javax.swing.JComboBox<>();
        comboBuku = new javax.swing.JComboBox<>();
        jDateTglpinjam = new com.toedter.calendar.JDateChooser();
        jDateTglkembali = new com.toedter.calendar.JDateChooser();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPeminjaman = new javax.swing.JTable();
        totData = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dateFrom = new com.toedter.calendar.JDateChooser();
        dateTo = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        export = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("DATA PEMINJAMAN");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mahasiswa");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Buku");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tgl Pinjam");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tgl Kembali");

        jDateTglpinjam.setMaxSelectableDate(new java.util.Date(253370739703000L));
        jDateTglpinjam.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jDateTglpinjam.setMinimumSize(new java.awt.Dimension(36, 26));
        jDateTglpinjam.setPreferredSize(new java.awt.Dimension(36, 26));

        jDateTglkembali.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jDateTglkembali.setMinimumSize(new java.awt.Dimension(36, 26));
        jDateTglkembali.setPreferredSize(new java.awt.Dimension(36, 26));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboMahasiswa, 0, 319, Short.MAX_VALUE)
                    .addComponent(comboBuku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateTglpinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateTglkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(comboMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jDateTglpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateTglkembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnTambah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Tambah.png"))); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Hapus.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Batal.png"))); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        tbPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPeminjaman);

        totData.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totData.setText("Total Data: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Filter Tanggal Pinjam :");

        dateFrom.setMaximumSize(new java.awt.Dimension(32767, 32767));
        dateFrom.setMinSelectableDate(new java.util.Date(-62135794735000L));
        dateFrom.setMinimumSize(new java.awt.Dimension(36, 26));
        dateFrom.setOpaque(false);
        dateFrom.setPreferredSize(new java.awt.Dimension(36, 26));

        dateTo.setMaximumSize(new java.awt.Dimension(32767, 32767));
        dateTo.setMinimumSize(new java.awt.Dimension(36, 26));
        dateTo.setPreferredSize(new java.awt.Dimension(36, 26));

        jLabel7.setText("to");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        export.setText("Export CSV");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(totData)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(191, 191, 191))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch)
                        .addComponent(export))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totData)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPeminjamanMouseClicked
        // TODO add your handling code here:
        try{
            Connection conn = KoneksiDB.koneksiDB();
            Statement stt = conn.createStatement();
            String sql = "SELECT * FROM tb_peminjaman "
                    + "JOIN tb_mahasiswa ON tb_peminjaman.nim = tb_mahasiswa.nim "
                    + "JOIN tb_buku ON tb_peminjaman.kode_buku = tb_buku.kode_buku "
                    + "WHERE tb_peminjaman.id="+tabModel.getValueAt(tbPeminjaman.getSelectedRow(),0).toString();
            rs = stt.executeQuery(sql);
            
            if (rs.next()) {
                String mahasiswa = rs.getString("nim")+" - "+rs.getString("nama");
                String buku = rs.getString("kode_buku")+" - "+rs.getString("judul_buku");
                String tgl_pinjam = rs.getString("tgl_pinjam");
                String tgl_kembali = rs.getString("tgl_kembali");
                
                comboMahasiswa.setSelectedItem(mahasiswa);
                comboBuku.setSelectedItem(buku);
                
                SimpleDateFormat date;
                date= new SimpleDateFormat("yyy-MM-dd");
                jDateTglpinjam.setDate(date.parse(tgl_pinjam));
                if(tgl_kembali != null){
                    jDateTglkembali.setDate(date.parse(tgl_kembali));
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        
        btnTambah.setEnabled(false);
        btnEdit.setEnabled(true);
        btnHapus.setEnabled(true);
        btnBatal.setEnabled(true);
        jDateTglkembali.setEnabled(true);
    }//GEN-LAST:event_tbPeminjamanMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        String nim="";
        String buku="";
        String tgl_pinjam="";
        
        SimpleDateFormat date;
        date= new SimpleDateFormat("yyy-MM-dd");
        if(jDateTglpinjam.getDate() == null){
            tgl_pinjam="";
        } else {
            tgl_pinjam=date.format(jDateTglpinjam.getDate());
        }
        
        String selectedMahasiswa = (String) comboMahasiswa.getSelectedItem();
        if (selectedMahasiswa.equals("-Pilih Mahasiswa-")) {
            nim="";
        } else {
            nim=mahasiswaList.get(comboMahasiswa.getSelectedIndex() - 1);
        }
        String selectedBuku = (String) comboBuku.getSelectedItem();
        if (selectedBuku.equals("-Pilih Buku-")) {
            buku="";
        } else {
            buku=bukuList.get(comboBuku.getSelectedIndex() - 1);
        }
        
//        check if null
        if (nim.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"mahasiswa tidak boleh kosong");
            comboMahasiswa.requestFocus();
        }else if (buku.isEmpty()) {
            JOptionPane.showMessageDialog(null,"buku tidak boleh kosong");
            comboBuku.requestFocus();
        }else if (tgl_pinjam.isEmpty()) {
            JOptionPane.showMessageDialog(null,"tanggal pinjam tidak boleh kosong");
            jDateTglpinjam.requestFocus();
        }else{
            try{
                Connection conn=(Connection)KoneksiDB.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("insert into tb_peminjaman(nim,kode_buku,tgl_pinjam)"+
                    "VALUES('"+nim+"','"+buku+"','"+tgl_pinjam+"')");
                BersihData();
                refreshTable();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String nim="";
        String buku="";
        String tgl_pinjam="";
        String tgl_kembali="";
        
        SimpleDateFormat date;
        date= new SimpleDateFormat("yyy-MM-dd");
        if(jDateTglpinjam.getDate() == null){
            tgl_pinjam="";
        } else {
            tgl_pinjam=date.format(jDateTglpinjam.getDate());
        }
        if(jDateTglkembali.getDate() == null){
            tgl_kembali="";
        } else {
            tgl_kembali=date.format(jDateTglkembali.getDate());
        }
        
        String selectedMahasiswa = (String) comboMahasiswa.getSelectedItem();
        if (selectedMahasiswa.equals("-Pilih Mahasiswa-")) {
            nim="";
        } else {
            nim=mahasiswaList.get(comboMahasiswa.getSelectedIndex() - 1);
        }
        String selectedBuku = (String) comboBuku.getSelectedItem();
        if (selectedBuku.equals("-Pilih Buku-")) {
            buku="";
        } else {
            buku=bukuList.get(comboBuku.getSelectedIndex() - 1);
        }
        
//        check if null
        if (nim.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"mahasiswa tidak boleh kosong");
            comboMahasiswa.requestFocus();
        }else if (buku.isEmpty()) {
            JOptionPane.showMessageDialog(null,"buku tidak boleh kosong");
            comboBuku.requestFocus();
        }else if (tgl_pinjam.isEmpty()) {
            JOptionPane.showMessageDialog(null,"tanggal pinjam tidak boleh kosong");
            jDateTglpinjam.requestFocus();
        }else if (tgl_kembali.isEmpty()) {
            try{
                Connection conn=(Connection)KoneksiDB.koneksiDB();
                Statement stt=conn.createStatement();
                int row = tbPeminjaman.getSelectedRow();
                String value = (tbPeminjaman.getModel().getValueAt(row, 0).toString());
                stt.executeUpdate("UPDATE tb_peminjaman SET nim='"+nim+"', kode_buku='"+buku+"', tgl_pinjam='"+tgl_pinjam+"' WHERE id='"+value+"'");
                BersihData();
                refreshTable();
                btnTambah.setEnabled(true);
                JOptionPane.showMessageDialog(this,"Data berhasil diubah","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Ubah data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            try{
                Connection conn=(Connection)KoneksiDB.koneksiDB();
                Statement stt=conn.createStatement();
                int row = tbPeminjaman.getSelectedRow();
                String value = (tbPeminjaman.getModel().getValueAt(row, 0).toString());
                stt.executeUpdate("UPDATE tb_peminjaman SET nim='"+nim+"', kode_buku='"+buku+"', tgl_pinjam='"+tgl_pinjam+"', tgl_kembali='"+tgl_kembali+"' WHERE id='"+value+"'");
                BersihData();
                refreshTable();
                btnTambah.setEnabled(true);
                JOptionPane.showMessageDialog(this,"Data berhasil diubah","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Ubah data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int row = tbPeminjaman.getSelectedRow();
        String value = (tbPeminjaman.getModel().getValueAt(row, 0).toString());

        if (value.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"id kosong");
        }else if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)KoneksiDB.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM tb_peminjaman WHERE id='"+value+"'");
            BersihData();
            refreshTable();
            btnTambah.setEnabled(true);
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        refreshTable();
        BersihData();
        btnTambah.setEnabled(true);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
        // TODO add your handling code here:
        
        String filename = "D:\\FIleExportDataPeminjaman/DataExport.csv";
        String tgl_dari="";
        String tgl_sampai="";
        
        try(FileWriter fw = new FileWriter(filename)) {
            
            SimpleDateFormat date;
            date= new SimpleDateFormat("yyy-MM-dd");
            if(dateFrom.getDate() == null){
                tgl_dari="";
            } else {
                tgl_dari=date.format(dateFrom.getDate());
            }
            if(dateTo.getDate() == null){
                tgl_sampai="";
            } else {
                tgl_sampai=date.format(dateTo.getDate());
            }
            
            
            if (tgl_dari.isEmpty() && tgl_sampai.isEmpty()) {
                Connection conn=(Connection)KoneksiDB.koneksiDB();
                Statement stt=conn.createStatement();
                String sql = "SELECT tb_mahasiswa.nim, nama, judul_buku, penulis, tahun_terbit, tgl_pinjam, tgl_kembali FROM tb_peminjaman "
                        + "JOIN tb_mahasiswa ON tb_peminjaman.nim = tb_mahasiswa.nim "
                        + "JOIN tb_buku ON tb_peminjaman.kode_buku = tb_buku.kode_buku ";
                rs = stt.executeQuery(sql);
            } else {
                Connection conn = KoneksiDB.koneksiDB();
                Statement stt = conn.createStatement();
                String sql = "SELECT tb_mahasiswa.nim, nama, judul_buku, penulis, tahun_terbit, tgl_pinjam, tgl_kembali FROM tb_peminjaman "
                        + "JOIN tb_mahasiswa ON tb_peminjaman.nim = tb_mahasiswa.nim "
                        + "JOIN tb_buku ON tb_peminjaman.kode_buku = tb_buku.kode_buku "
                        + "WHERE tb_peminjaman.tgl_pinjam >= '"+tgl_dari+"' AND tb_peminjaman.tgl_pinjam <= '"+tgl_sampai+"'";
                rs = stt.executeQuery(sql);
            }
            
            fw.append("NIM");
            fw.append(',');
            fw.append("Nama");
            fw.append(',');
            fw.append("Judul Buku");
            fw.append(',');
            fw.append("Penulis");
            fw.append(',');
            fw.append("Tahun Terbit");
            fw.append(',');
            fw.append("Tanggal Pinjam");
            fw.append(',');
            fw.append("Tanggal Kembali");
            fw.append('\n');
            fw.append('\n');
            while(rs.next()){
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append(',');
                fw.append(rs.getString(4));
                fw.append(',');
                fw.append(rs.getString(5));
                fw.append(',');
                fw.append(rs.getString(6));
                fw.append(',');
                fw.append(rs.getString(7));
                fw.append('\n');
            }
            JOptionPane.showMessageDialog(this, "Data Berhasil Di Export!");
            fw.flush();
        } catch (IOException ex) {
            Logger.getLogger(FormTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FormTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String tgl_dari="";
        String tgl_sampai="";
        
        SimpleDateFormat date;
        date= new SimpleDateFormat("yyy-MM-dd");
        if(dateFrom.getDate() == null){
            tgl_dari="";
        } else {
            tgl_dari=date.format(dateFrom.getDate());
        }
        if(dateTo.getDate() == null){
            tgl_sampai="";
        } else {
            tgl_sampai=date.format(dateTo.getDate());
        }
        
        if (tgl_dari.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Pilih filter untuk dari tanggal berapa");
            dateFrom.requestFocus();
        } else if (tgl_sampai.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Pilih filter untuk sampai tanggal berapa");
            dateTo.requestFocus();
        } else {
            try {
                Object[] judul_kolom = {"#","Nim", "Nama", "Buku", "Tgl Pinjam", "Tgl Kembali"};
                tabModel=new DefaultTableModel(null,judul_kolom);
                tbPeminjaman.setModel(tabModel);
            
                Connection conn = KoneksiDB.koneksiDB();
                Statement stt = conn.createStatement();
                String sql = "SELECT * FROM tb_peminjaman "
                        + "JOIN tb_mahasiswa ON tb_peminjaman.nim = tb_mahasiswa.nim "
                        + "JOIN tb_buku ON tb_peminjaman.kode_buku = tb_buku.kode_buku "
                        + "WHERE tb_peminjaman.tgl_pinjam >= '"+tgl_dari+"' AND tb_peminjaman.tgl_pinjam <= '"+tgl_sampai+"'";
                ResultSet res = stt.executeQuery(sql);
                
                while(res.next()){
                    Object[] data={
                        res.getString("id"),
                        res.getString("nim"),
                        res.getString("nama"), 
                        res.getString("judul_buku"), 
                        res.getString("tgl_pinjam"),
                        res.getString("tgl_kembali")
                    };
                    tabModel.addRow(data);
                } 
            } catch (SQLException ex) {
                Logger.getLogger(FormTransaksi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            TableColumnModel tcm = tbPeminjaman.getColumnModel();
            tcm.removeColumn(tcm.getColumn(0));
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> comboBuku;
    private javax.swing.JComboBox<String> comboMahasiswa;
    private com.toedter.calendar.JDateChooser dateFrom;
    private com.toedter.calendar.JDateChooser dateTo;
    private javax.swing.JButton export;
    private com.toedter.calendar.JDateChooser jDateTglkembali;
    private com.toedter.calendar.JDateChooser jDateTglpinjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPeminjaman;
    private javax.swing.JLabel totData;
    // End of variables declaration//GEN-END:variables
}