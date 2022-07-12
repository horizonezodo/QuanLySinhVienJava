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
public class Khoa {
    private int idkhoa;
    private String tenkhoa;

    public Khoa(int idkhoa, String tenkhoa) {
        this.idkhoa = idkhoa;
        this.tenkhoa = tenkhoa;
    }

    public Khoa() {
    }

    public int getIdkhoa() {
        return idkhoa;
    }

    public void setIdkhoa(int idkhoa) {
        this.idkhoa = idkhoa;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    @Override
    public String toString() {
        return "Khoa{" + "idkhoa=" + idkhoa + ", tenkhoa=" + tenkhoa + '}';
    }
    
    
}
