/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import Data.Ogretmen;
import Data.Veli;
import Data.Yonetici;
import Database.OgretmenDAO;
import Database.VeliDAO;
import Database.YoneticiDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Secret
 */
public class GirisController implements Initializable {
    @FXML
    private AnchorPane anc_pane;
    @FXML
    private TextField text_mail;
    @FXML
    private PasswordField text_sifre;
    @FXML
    private Label label_mail;
    @FXML
    private Label label_sifre;
    @FXML
    private Button btn_giris;
    @FXML
    private RadioButton rad_ogretmen;
    @FXML
    private RadioButton rad_veli;
    @FXML
    private Label lblStatus;
    
    private Object kullanici = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    private boolean kullaniciKontrol(String mail, String sifre) {

        if (rad_ogretmen.isSelected()) { // ogretmen olarak secilmis ise 
            OgretmenDAO ogretmenDAO = new OgretmenDAO();// personel dao obj olustur
            Ogretmen p = ogretmenDAO.getItemOgretmenByMail(mail, sifre); // mail ve sifre ile getir
            if (p != null) // eger null ise yani kosulu saglayan kayit var ise 
            {
                kullanici = p;
                
                
                
                
                
                return true; // true döndür 
            } else {
                return false;
            }
        } 
        else if (rad_veli.isSelected()) { // veli olarak secilmis ise 
            VeliDAO veliDAO = new VeliDAO();// personel dao obj olustur
            Veli v = veliDAO.getItemVeliByMail(mail, sifre); // mail ve sifre ile getir
            if (v != null) // eger null ise yani kosulu saglayan kayit var ise 
            {
                kullanici = v;
                
                
                
                
                
                return true; // true döndür 
            } else {
                return false;
            }
        } 
        else  {  // musteri ise 
            YoneticiDAO yoneticiDAO = new YoneticiDAO();
            Yonetici y = yoneticiDAO.getItemYoneticiByMail(mail, sifre);

            if (y != null) {
                kullanici = y;
                return true;
            } else {
                return false;
            }

        }

    }

    @FXML
    private void Login(ActionEvent event) throws IOException {
        
        String mail = text_mail.getText();
        String sifre = text_sifre.getText();
        
        if (kullaniciKontrol(mail,sifre)) {
            lblStatus.setText("Giriş Başarılı..");

           try {
               
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/anaokulu/panel.fxml"));
                
                otomasyon.PanelController controller = new otomasyon.PanelController(kullanici);
                loader.setController(controller);
                
                Parent root = loader.load();
                
            
            Stage stage = new Stage();//yeni pencere olusturuldu
            stage.setScene(new Scene(root)); // pencerenin icine dosyadaki yerlestirildi
            stage.getScene().getStylesheets().add(getClass().getResource("/css/css9.css").toExternalForm());
            stage.show(); //pencere gosterildi
            
            Stage stage1 = (Stage)btn_giris.getScene().getWindow();
            stage1.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
            
        } else {
            lblStatus.setText("Mail veya Sifre Hatalı");
        }

    }
}
