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
import model.Lop;

/**
 *
 * @author Admin
 */
public class DAOLop implements LopDAO<Lop>{
    public static DAOLop getInstances(){
            return new DAOLop();
        }
    @Override
    public int insert(Lop t) {
         try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "INSERT INTO Lop (lopid , lopname , khoaid) VALUES('"+t.getMalop()+"' , '"+t.getTenlop()+"' , '"+t.getMakhoa()+"')";
            int ketqua = st.executeUpdate(sql);
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Lop t) {
         try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "UPDATE Lop SET lopname = '"+t.getTenlop()+"' , khoaid =  '"+t.getMakhoa()+"'  WHERE khoaid = '"+t.getMalop()+"'";
            int ketqua = st.executeUpdate(sql);
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int delete(Lop t) {
       try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "DELETE FROM Lop WHERE khoaid = '"+t.getMalop()+"'";
            int ketqua = st.executeUpdate(sql);
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Lop> selectAll() {
        ArrayList<Lop> dsLop = new ArrayList<Lop>();
       try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT * FROM Lop";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int idlop = rs.getInt("lopid");
                String name = rs.getString("lopname");
                int idkhoa = rs.getInt("khoaid");
                Lop l = new Lop(idlop, name, idkhoa);
                dsLop.add(l);
            }
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsLop;
    }

    @Override
    public Lop selectbyidLop(Lop t) {
        Lop l = new Lop();
       try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT * FROM Lop";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int idlop = rs.getInt("lopid");
                String name = rs.getString("lopname");
                int idkhoa = rs.getInt("khoaid");
                l = new Lop(idlop, name, idkhoa);
            }
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
}
