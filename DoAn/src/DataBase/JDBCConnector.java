/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class JDBCConnector {
    public static Connection getConnection(){
        Connection c = null;
         String url = "jdbc:mysql://localhost:3306/truonghoc";
         String user = "root";
         String password = "123456789";
          try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            c = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    public static void closeConnection(Connection c){
        try{
            if(c != null)
                c.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
