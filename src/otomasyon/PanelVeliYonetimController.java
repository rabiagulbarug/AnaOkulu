/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import Data.Veli;
import Database.VeliDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Secret
 */
public class PanelVeliYonetimController implements Initializable {
    @FXML
    private AnchorPane pan_veli_bilgi;
    @FXML
    private TextField txt_veli_isim;
    @FXML
    private TextField txt_veli_tel;
    @FXML
    private TextField txt_veli_mail;
    @FXML
    private TextArea txt_veli_adres;
    @FXML
    private Button btn_veli_kaydet;
    @FXML
    private Button btn_veli_guncelle;
    @FXML
    private TextField txt_veliId;
    @FXML
    private TextField txt_veli_tel2;
    @FXML
    private TextField txt_veli_sifre;
    @FXML
    private Label lblStatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Tiklandi_VeliKaydet(ActionEvent event) {
        VeliDAO veliDAO = new VeliDAO();
        veliDAO.insertItem(veliOlustur());
         if (veliOlustur() != null) {
            lblStatus.setText("Kayıt Başarılı...");
        } else {
            lblStatus.setText("Kayıt Yapılamadı...");
        }
  
        
        Stage stage = (Stage)btn_veli_kaydet.getScene().getWindow();
        stage.show();
    }


    @FXML
    private void Tiklandi_VeliGuncelle(ActionEvent event) {
         VeliDAO veliDAO = new VeliDAO();
        veliDAO.updateItem(VeliBilgiGetir());
        if (VeliBilgiGetir() != null) {
            lblStatus.setText("Güncelleme Başarılı...");
        } else {
            lblStatus.setText("Güncelleme Yapılamadı...");
        }
        
        Stage stage = (Stage)btn_veli_guncelle.getScene().getWindow();
       stage.show();
            
   
    }
    
     private Veli VeliBilgiGetir() {
        
        VeliDAO veliDAO = new VeliDAO();
        Veli v = new Veli();
        
        v.setId(Integer.parseInt(txt_veliId.getText()));
        v.setIsimSoyisim(txt_veli_isim.getText());
        v.setSifre(txt_veli_sifre.getText());
        v.setTelefon(txt_veli_tel.getText());
        v.setTelefon2(txt_veli_tel2.getText());
        v.setMail(txt_veli_mail.getText());
        v.setAdres(txt_veli_adres.getText());

        return v;
    } 
    
    private Veli veliOlustur(){
        
        Veli v = new Veli();

        v.setIsimSoyisim(txt_veli_isim.getText());
        v.setSifre(txt_veli_sifre.getText());
        v.setTelefon(txt_veli_tel.getText());
        v.setTelefon2(txt_veli_tel2.getText());
        v.setMail(txt_veli_mail.getText());
        v.setAdres(txt_veli_adres.getText());

        return v;
       
    }

    private void VeliGirdi(Veli v) {

        txt_veliId.setText(String.valueOf(v.getId()));
        txt_veli_isim.setText(v.getIsimSoyisim());
        txt_veli_sifre.setText(v.getSifre());
        txt_veli_tel.setText(v.getTelefon());
        txt_veli_tel2.setText(v.getTelefon2());
        txt_veli_mail.setText(v.getMail());
        txt_veli_adres.setText(v.getAdres());

    }
    
}
