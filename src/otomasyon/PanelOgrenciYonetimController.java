 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import Data.Ogrenci;
import Database.OgrenciDAO;
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
public class PanelOgrenciYonetimController implements Initializable {
    @FXML
    private AnchorPane pan_ogrencibilgi;
    @FXML
    private TextField txt_ogrenci_isim;
    @FXML
    private TextField txt_tckimlik;
    @FXML
    private TextField txt_anne_ismi;
    @FXML
    private TextField txt_baba_ismi;
    @FXML
    private TextField txt_baba_tel;
    @FXML
    private TextField txt_anne_tel;
    @FXML
    private TextArea txt_ogrenci_adres;
    @FXML
    private TextField txt_ogrenciId;
    @FXML
    private Button btn_ogrenci_guncelle;
    @FXML
    private Button btn_kaydet;
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
    private void Tiklandi_OgrenciGuncelle(ActionEvent event) {
        OgrenciDAO ogrenciDAO = new OgrenciDAO();
        ogrenciDAO.updateItem(OgrenciOlustur());
        
         if (OgrenciOlustur() != null) {
            lblStatus.setText("Guncelleme Başarılı...");
        } else {
            lblStatus.setText("Guncelleme Yapılamadı...");
        }
        
        Stage stage =(Stage)btn_ogrenci_guncelle.getScene().getWindow();
        stage.show();
    }

    
    private Ogrenci OgrenciOlustur(){
        OgrenciDAO dao = new OgrenciDAO();
        Ogrenci o = new Ogrenci();
        
        
        o.setId(Integer.parseInt(txt_ogrenciId.getText()));
        o.setIsimSoyisim(txt_ogrenci_isim.getText());
        o.setTckimlik(txt_tckimlik.getText());
        o.setAnneisim(txt_anne_ismi.getText());
        o.setBabaisim(txt_baba_ismi.getText());
        o.setTelefon(txt_anne_tel.getText());
        o.setTelefon2(txt_baba_tel.getText());
        o.setAdres(txt_ogrenci_adres.getText());
        
        return o;
        
    }

    @FXML
    private void Tiklandi_ButonKaydet(ActionEvent event) {
         OgrenciDAO ogrenciDAO = new OgrenciDAO();
        ogrenciDAO.insertItem(ogrenciOlustur());
        
        if (ogrenciOlustur() != null) {
            lblStatus.setText("Kayıt Başarılı...");
        } else {
            lblStatus.setText("Kayıt Yapılamadı...");
        }
        
        Stage stage = (Stage)btn_kaydet.getScene().getWindow();
        stage.show();
    }
    private Ogrenci ogrenciOlustur(){
        Ogrenci o = new Ogrenci();
        
        o.setIsimSoyisim(txt_ogrenci_isim.getText());
        o.setTckimlik(txt_tckimlik.getText());
        o.setAnneisim(txt_anne_ismi.getText());
        o.setBabaisim(txt_baba_ismi.getText());
        o.setTelefon(txt_anne_tel.getText());
        o.setTelefon2(txt_baba_tel.getText());
        o.setAdres(txt_ogrenci_adres.getText());
        
        
        
        
        return o;
    }
    

}




