/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Angga
 */
public class KoneksiDB {
    private static Connection KoneksiDatabse;
    public static Connection koneksiDB() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String DB ="jdbc:mysql://localhost:3306/perpustakaan_oop?serverTimezone=UTC";
            String user="root";
            String pass="";

            KoneksiDatabse = DriverManager.getConnection(DB,user,pass);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Tidak ada koneksi","Error",
            JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
            System.exit(0);
        }
        return KoneksiDatabse;
    }
}