/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import Data.Ogretmen;
import Database.OgretmenDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class PanelOgretmenYonetimController implements Initializable {
    @FXML
    private AnchorPane pan_ogretmen;
    @FXML
    private TextField txt_ogretmen_isim;
    @FXML
    private TextField txt_ogretmen_tel;
    @FXML
    private TextField txt_ogretmen_mail;
    @FXML
    private TextArea txt_ogretmen_adres;
    @FXML
    private Button btn_ogretmen_kaydet;
    @FXML
    private Button btn_ogretmen_guncelle;
    @FXML
    private TextField txt_ogretmenId;
    @FXML
    private TextField txt_ogretmen_sifre;
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
    private void Tiklandi_OgretmenKaydet(ActionEvent event) {
        OgretmenDAO ogretmenDAO = new OgretmenDAO();
        ogretmenDAO.insertItem(ogretmenOlustur());
        
         if (ogretmenOlustur() != null) {
            lblStatus.setText("Kayıt Başarılı...");
        } else {
            lblStatus.setText("Kayıt Yapılamadı...");
        }

        
        Stage stage = (Stage)btn_ogretmen_kaydet.getScene().getWindow();
        stage.show();
    }


    @FXML
    private void Tiklandi_OgretmenGuncelle(ActionEvent event) {
        OgretmenDAO ogretmenDAO = new OgretmenDAO();
        ogretmenDAO.updateItem(OgretmenBilgiGetir());
        
         if (OgretmenBilgiGetir() != null) {
            lblStatus.setText("Guncelleme Başarılı...");
        } else {
            lblStatus.setText("Guncelleme Yapılamadı...");
        }
        
        Stage stage = (Stage)btn_ogretmen_guncelle.getScene().getWindow();
        stage.show(); 
    }
    
    private Ogretmen ogretmenOlustur(){
        
            Ogretmen o = new Ogretmen();
            
        o.setIsimSoyisim(txt_ogretmen_isim.getText());
        o.setSifre(txt_ogretmen_sifre.getText());
        o.setTelefon(txt_ogretmen_tel.getText());
        o.setMail(txt_ogretmen_mail.getText());
        o.setAdres(txt_ogretmen_adres.getText());
            
            
        return o ;
    }
    private Ogretmen OgretmenBilgiGetir() {
        OgretmenDAO ogretmen = new OgretmenDAO();
        Ogretmen o = new Ogretmen();
        
        o.setId(Integer.parseInt(txt_ogretmenId.getText()));
        o.setIsimSoyisim(txt_ogretmen_isim.getText());
        o.setSifre(txt_ogretmen_sifre.getText());
        o.setTelefon(txt_ogretmen_tel.getText());
        o.setMail(txt_ogretmen_mail.getText());
        o.setAdres(txt_ogretmen_adres.getText());

        return o;
    }
}
