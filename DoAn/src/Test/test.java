/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DAO.DAOKhoa;
import java.util.ArrayList;
import model.Khoa;

/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args) {
        Khoa k1 = new Khoa(3,"Cong Nghe Truyen Thong Da Phuong Tien");
        Khoa k = new Khoa();
        k.setIdkhoa(1);
        Khoa k2 = DAOKhoa.getinstance().selectbyidKhoa(k);
        System.out.println(k2.toString());
    }
}
