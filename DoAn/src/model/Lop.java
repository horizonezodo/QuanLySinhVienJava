/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Lop {
    private int malop;
    private String tenlop;
    private int makhoa;

    public Lop(int malop, String tenlop, int makhoa) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.makhoa = makhoa;
    }

    public Lop() {
    }

    public int getMalop() {
        return malop;
    }

    public void setMalop(int malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public int getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(int makhoa) {
        this.makhoa = makhoa;
    }
    
}
