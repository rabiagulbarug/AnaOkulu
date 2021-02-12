/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import Data.Ders;
import Database.DersDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Secret
 */
public class PanelDersProgramController implements Initializable {
    @FXML
    private AnchorPane pan_dersprogram;
    @FXML
    private TextField txt_ogretmenId;
    @FXML
    private TextField txt_pazartesi;
    @FXML
    private TextField txt_sali;
    @FXML
    private TextField txt_carsamba;
    @FXML
    private TextField txt_persembe;
    @FXML
    private TextField txt_cuma;
    @FXML
    private Button btn_ders_kaydet;
    @FXML
    private TextField txt_saat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void Tiklandi_DersProgram_Kaydet(ActionEvent event) {
        DersDAO dersDAO = new DersDAO();
        dersDAO.insertItem(Program());
        
        Stage stage = (Stage)btn_ders_kaydet.getScene().getWindow(); // stage nesnesini olustur   
        stage.show(); 
                
    }
     private Ders Program() {

        DersDAO dao = new DersDAO();
        Ders d = new Ders();

        d.setOgretmenID(Integer.parseInt(txt_ogretmenId.getText()));
        d.setSaat(txt_saat.getText());
        d.setPazartesi(txt_pazartesi.getText());
        d.setSali(txt_sali.getText());
        d.setCarsamba(txt_carsamba.getText());
        d.setPersembe(txt_persembe.getText());
        d.setCuma(txt_cuma.getText());

        return d;
}
}