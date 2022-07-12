/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataBase.JDBCConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HocSinhAccount;

/**
 *
 * @author Admin
 */
public class DAOHocSinhAccount implements HocSinhAccountDAO<HocSinhAccount>{
    public static DAOHocSinhAccount getIntences(){
        return new DAOHocSinhAccount();
    }
    @Override
    public int insert(HocSinhAccount t) {
         try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "INSERT INTO hocsinhaccount (acount , pass) VALUES('"+t.getAcount()+"' , '"+t.getPass()+"')";
            int ketqua = st.executeUpdate(sql);
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(HocSinhAccount t) {
        try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "UPDATE hocsinhaccount SET pass = '"+t.getPass()+"' WHERE acount = '"+t.getAcount()+"'";
            int ketqua = st.executeUpdate(sql);
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int delete(HocSinhAccount t) {
         try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "DELETE FROM hocsinhaccount WHERE khoaid = '"+t.getAcount()+"'";
            int ketqua = st.executeUpdate(sql);
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<HocSinhAccount> selectAll() {
        ArrayList<HocSinhAccount> dsAcount = new ArrayList<HocSinhAccount>();
       try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT * FROM hocsinhaccount";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String Account = rs.getString("acount");
                String Pass = rs.getString("pass");
                HocSinhAccount hs = new HocSinhAccount(Account, Pass);
                dsAcount.add(hs);
            }
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsAcount;
    }

    @Override
    public HocSinhAccount selectbyidLop(HocSinhAccount t) {
        HocSinhAccount ac = new HocSinhAccount();
       try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT * FROM hocsinhaccount";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String Account = rs.getString("acount");
                String Pass = rs.getString("pass");
                ac = new HocSinhAccount(Account, Pass);
                
            }
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ac;
    }
    
}
