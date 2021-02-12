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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Secret
 */
public class OgrenciTabloController implements Initializable {
    @FXML
    private AnchorPane pan_ogrencibilgi;
    @FXML
    private TableView<Ogrenci> tab_ogrencibilgi;
    @FXML
    private TableColumn<?, ?> tab_ogrenciId;
    @FXML
    private TableColumn<?, ?> tab_ogrenci_isim;
    @FXML
    private TableColumn<?, ?> tab_anne;
    @FXML
    private TableColumn<?, ?> tab_baba;
    @FXML
    private TableColumn<?, ?> tab_anne_tel;
    @FXML
    private TableColumn<?, ?> tab_baba_tel;
    @FXML
    private TableColumn<?, ?> tab_adres;
    @FXML
    private TableColumn<?, ?> tab_tckimlik;
    
    private ObservableList<Ogrenci> list_ogrenci = null;
    
    private Ogrenci secili_ogrenci = null;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            
            tab_ogrenciId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tab_ogrenci_isim.setCellValueFactory(new PropertyValueFactory<>("IsimSoyisim"));
            tab_tckimlik.setCellValueFactory(new PropertyValueFactory<>("tckimlik"));
            tab_anne.setCellValueFactory(new PropertyValueFactory<>("Anneisim"));
            tab_baba.setCellValueFactory(new PropertyValueFactory<>("Babaisim"));
            tab_anne_tel.setCellValueFactory(new PropertyValueFactory<>("Telefon"));
            tab_baba_tel.setCellValueFactory(new PropertyValueFactory<>("Telefon2"));
            tab_adres.setCellValueFactory(new PropertyValueFactory<>("adres"));
            
            
            list_ogrenci = FXCollections.observableArrayList();
            ogrenciTabloGuncelle();
            tab_ogrencibilgi.setItems(list_ogrenci);
            tab_ogrencibilgi.setOnMouseClicked((MouseEvent event) -> {
               secili_ogrenci = (Ogrenci) tab_ogrencibilgi.getSelectionModel().getSelectedItems();
            });

    } 
    private void ogrenciTabloGuncelle(){
        list_ogrenci.clear();
        OgrenciDAO ogrenciDAO = new OgrenciDAO();
        list_ogrenci.addAll(ogrenciDAO.getItems());
        tab_ogrencibilgi.getItems();

    }
    
    private Ogrenci OgrenciBilgiGetir(){
        OgrenciDAO dao = new OgrenciDAO();
        Ogrenci o = new Ogrenci();
        
        o.setId(Integer.parseInt(tab_ogrenciId.getText()));
        o.setIsimSoyisim(tab_ogrenci_isim.getText());
        o.setTckimlik(tab_tckimlik.getText());
        o.setAnneisim(tab_anne.getText());
        o.setBabaisim(tab_baba.getText());
        o.setTelefon(tab_anne_tel.getText());
        o.setTelefon2(tab_baba_tel.getText());
        o.setAdres(tab_adres.getText());
        
        return o;
        
    }
    
    private void OgrenciGirdi(Ogrenci o){
        
        tab_ogrenciId.setText(String.valueOf(o.getId()));
        tab_ogrenci_isim.setText(o.getIsimSoyisim());
        tab_tckimlik.setText(o.getTckimlik());
        tab_anne.setText(o.getAnneisim());
        tab_baba.setText(o.getBabaisim());
        tab_anne_tel.setText(o.getTelefon());
        tab_baba_tel.setText(o.getTelefon2());
        tab_adres.setText(o.getAdres());
        
        
    }
}


















