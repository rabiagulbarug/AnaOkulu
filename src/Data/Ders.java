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
public class Ders {
    
    private int id;
    private int OgretmenID;
    private String saat;
    private String pazartesi;
    private String sali;
    private String carsamba;
    private String persembe;
    private String cuma;
    
    
     public Ders() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getOgretmenID() {
        return OgretmenID;
    }

    public void setOgretmenID(int OgretmenID) {
        this.OgretmenID = OgretmenID;
    }
    
    
     public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public String getPazartesi() {
        return pazartesi;
    }

    public void setPazartesi(String pazartesi) {
        this.pazartesi = pazartesi;
    }

    public String getSali() {
        return sali;
    }

    public void setSali(String sali) {
        this.sali = sali;
    }

    public String getCarsamba() {
        return carsamba;
    }

    public void setCarsamba(String carsamba) {
        this.carsamba = carsamba;
    }
    public String getPersembe() {
        return persembe;
    }

    public void setPersembe(String persembe) {
        this.persembe = persembe;
    }
    public String getCuma() {
        return cuma;
    }

    public void setCuma(String cuma) {
        this.cuma = cuma;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(getId()).append("\n");
        sb.append(getPazartesi()).append("\n");
        sb.append(getSali()).append("\n");
        sb.append(getCarsamba()).append("\n");
        sb.append(getPersembe()).append("\n");
        sb.append(getCuma()).append("\n");

        return sb.toString();
    }
    
    
}
