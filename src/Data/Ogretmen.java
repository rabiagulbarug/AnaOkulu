package Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Secret
 */
public class Ogretmen {

    private int id;
    private String IsimSoyisim;
    private String sifre;
    private String telefon;
    private String mail;
    private String adres;
    
    public Ogretmen() {

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

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        sb.append(getSifre()).append("\n");
        sb.append(getTelefon()).append("\n");
        sb.append(getMail()).append("\n");
        sb.append(getAdres()).append("\n");

        return sb.toString();
    }
}
    

