/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import Data.Ders;
import Data.Ogretmen;
import Database.DersDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Secret
 */
public class DersTakipController implements Initializable {
    @FXML
    private AnchorPane pan_derstakip;
    @FXML
    private TableView<Ders> tab_derstakip;
    private TableColumn<?, ?> kln_saatID;
    @FXML
    private TableColumn<?, ?> kln_saat;
    @FXML
    private TableColumn<?, ?> kln_pazartesi;
    @FXML
    private TableColumn<?, ?> kln_sali;
    @FXML
    private TableColumn<?, ?> kln_carsamba;
    @FXML
    private TableColumn<?, ?> kln_persembe;
    @FXML
    private TableColumn<?, ?> kln_cuma;
    @FXML
    private Button btn_yenile;
    private ObservableList<Ders> list_ders = null;

    private Ders secili_ders = null;
     private Ogretmen kullanici_ogretmen = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
        kln_saat.setCellValueFactory(new PropertyValueFactory<>("saat"));
        kln_pazartesi.setCellValueFactory(new PropertyValueFactory<>("pazartesi"));
        kln_sali.setCellValueFactory(new PropertyValueFactory<>("sali"));
        kln_carsamba.setCellValueFactory(new PropertyValueFactory<>("carsamba"));
        kln_persembe.setCellValueFactory(new PropertyValueFactory<>("persembe"));
        kln_cuma.setCellValueFactory(new PropertyValueFactory<>("cuma"));

        list_ders = FXCollections.observableArrayList();
                 dersTabloGuncelle();
        tab_derstakip.setItems(list_ders);
        tab_derstakip.setOnMouseClicked((MouseEvent event) -> {

            secili_ders = (Ders) tab_derstakip.getSelectionModel().getSelectedItem();

        });
    }   
    
    private void dersTabloGuncelle() {
        list_ders.clear();
        DersDAO dersDAO = new DersDAO();
        list_ders.addAll(dersDAO.getItems());
        tab_derstakip.getItems();
}

    private Ders DersBilgiGetir2() {
        DersDAO dao = new DersDAO();
        Ders d = new Ders();
  
        d.setSaat(kln_saat.getText());
        d.setPazartesi(kln_pazartesi.getText());
        d.setSali(kln_sali.getText());
        d.setCarsamba(kln_carsamba.getText());
        d.setPersembe(kln_persembe.getText());
        d.setCuma(kln_cuma.getText());

        return d;
    }

     private void DersGirdi2(Ders d) {

        kln_saatID.setText(String.valueOf(d.getId()));
        kln_saat.setText(d.getSaat());
        kln_pazartesi.setText(d.getPazartesi());
        kln_sali.setText(d.getSali());
        kln_carsamba.setText(d.getCarsamba());
        kln_persembe.setText(d.getPersembe());
        kln_cuma.setText(d.getCuma());
    }
    
     private void Ders(){
         DersDAO dao = new DersDAO();
         Ders d = new Ders();
         d.setOgretmenID(kullanici_ogretmen.getId());
         
         d = dao.getItems().get(0);
         
         DersGirdi2(d);   
     }
    

    @FXML
    private void Tiklandi_YenileDersTakip(ActionEvent event) {
        dersTabloGuncelle();
    }
    
}
