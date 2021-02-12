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
public class Odeme {
    private int id;
    private int veliId;
    private int toplamtutar;
    private int aysayisi;
    private int odenenmiktar;
    private int kalanmiktar;
    
    public Odeme() {

    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getVeliId() {
        return veliId;
    }

    public void setVeliId(int veliId) {
        this.veliId = veliId;
    }
    
    public int getToplamtutar() {
        return toplamtutar;
    }

    public void setToplamtutar(int toplamtutar) {
        this.toplamtutar = toplamtutar;
    }
    
    public int getAysayisi() {
        return aysayisi;
    }

    public void setAysayisi(int aysayisi) {
        this.aysayisi = aysayisi;
    }
    
    public int getOdenenmiktar() {
        return odenenmiktar;
    }

    public void setOdenenmiktar(int odenenmiktar) {
        this.odenenmiktar = odenenmiktar;
    }
    
    public int getKalanmiktar() {
        return kalanmiktar;
    }

    public void setKalanmiktar(int kalanmiktar) {
        this.kalanmiktar = kalanmiktar;
    }
}
