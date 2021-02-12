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
public class Ogrenci {

    private int id;
    private String IsimSoyisim;
    private String tckimlik;
    private String anne_isim;
    private String baba_isim;
    private String telefon;
    private String telefon2;
    private String adres;

    public Ogrenci() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIsimSoyisim() {
        return IsimSoyisim;
    }
    public void setIsimSoyisim(String IsimSoyisim) {
        this.IsimSoyisim = IsimSoyisim;
    }
    public String getTckimlik() {
        return tckimlik;
    }
    public void setTckimlik(String tckimlik) {
        this.tckimlik = tckimlik;
    }
    public String getAnneisim() {
        return anne_isim;
    }
    public void setAnneisim(String anne_isim) {
        this.anne_isim = anne_isim;
    }

    public String getBabaisim() {
        return baba_isim;
    }

    public void setBabaisim(String baba_isim) {
        this.baba_isim = baba_isim;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getTelefon2() {
        return telefon2;
    }

    public void setTelefon2(String telefon2) {
        this.telefon2 = telefon2;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(getId()).append("\n");
        sb.append(getIsimSoyisim()).append("\n");
        sb.append(getTckimlik()).append("\n");
        sb.append(getAnneisim()).append("\n");
        sb.append(getBabaisim()).append("\n");
        sb.append(getTelefon()).append("\n");
        sb.append(getTelefon2()).append("\n");
        sb.append(getAdres()).append("\n");

        return sb.toString();
    }

}
