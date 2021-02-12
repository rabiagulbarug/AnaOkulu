/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Secret
 */
public class Yemek {
    
    private int id;
    private String gunler;
    private String yemek;
    
    public Yemek() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGunler() {
        return gunler;
    }

    public void setGunler(String gunler) {
        this.gunler = gunler;
    }

    public String getYemek() {
        return yemek;
    }

    public void setYemek(String yemek) {
        this.yemek = yemek;
    }
}
