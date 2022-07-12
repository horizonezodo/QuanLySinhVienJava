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
import model.Khoa;

/**
 *
 * @author Admin
 */
public class DAOKhoa implements KhoaDAO<Khoa>{

    public static ArrayList<Khoa> dsKhoa;
    public static DAOKhoa getinstance(){
        return new DAOKhoa();
    }
    @Override
    public int insert(Khoa t) {
        try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();          
            String sql = "INSERT INTO khoa (khoaid , khoaname) VALUES('"+t.getIdkhoa()+"' , '"+t.getTenkhoa()+"')";
            int ketqua = st.executeUpdate(sql);
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Khoa t) {
         try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "UPDATE khoa SET khoaname = '"+t.getTenkhoa()+"' WHERE khoaid = '"+t.getIdkhoa()+"'";
            int ketqua = st.executeUpdate(sql);
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int delete(Khoa t) {
         try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "DELETE FROM khoa WHERE khoaid = '"+t.getIdkhoa()+"'";
            int ketqua = st.executeUpdate(sql);
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Khoa> selectAll() {
             dsKhoa = new ArrayList<Khoa>();
       try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT * FROM Khoa";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int idkhoa = rs.getInt("khoaid");
                String name = rs.getString("khoaname");
                Khoa k = new Khoa(idkhoa, name);
                dsKhoa.add(k);
            }
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsKhoa;
    }

    @Override
    public Khoa selectbyidKhoa(Khoa t) {
         Khoa k = new Khoa();
       try {
            Connection con = JDBCConnector.getConnection();
            Statement st = con.createStatement();
            
            String sql = "SELECT * FROM Khoa WHERE khoaid = '"+t.getIdkhoa()+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int idkhoa = rs.getInt("khoaid");
                String name = rs.getString("khoaname");
                k = new Khoa(idkhoa, name);
            }
            JDBCConnector.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }

    
    
}
