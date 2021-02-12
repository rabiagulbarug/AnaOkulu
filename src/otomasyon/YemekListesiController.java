/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import Data.Yemek;
import Database.YemekDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class YemekListesiController implements Initializable {
    @FXML
    private AnchorPane pan_yemeklistesi;
    @FXML
    private TableView<Yemek> tab_yemeklistesi;
    @FXML
    private TableColumn<?, ?> tab_gunler;
    @FXML
    private TableColumn<?, ?> tab_yemek;
    private ObservableList<Yemek> list_yemek = null;

    private Yemek secili_yemek = null;
    @FXML
    private TableColumn<?, ?> tab_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tab_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tab_gunler.setCellValueFactory(new PropertyValueFactory<>("gunler"));
        tab_yemek.setCellValueFactory(new PropertyValueFactory<>("yemek")); 
        
        list_yemek = FXCollections.observableArrayList();
            yemekTabloGuncelle();
        tab_yemeklistesi.setItems(list_yemek);
        tab_yemeklistesi.setOnMouseClicked((MouseEvent event) -> {
           secili_yemek = (Yemek) tab_yemeklistesi.getSelectionModel().getSelectedItem();
        });
    }  
    private void yemekTabloGuncelle(){
        list_yemek.clear();
        YemekDAO yemekDAO = new YemekDAO();
        list_yemek.addAll(yemekDAO.getItems());
        tab_yemeklistesi.getItems();
        
    }
    
    private Yemek YemekBilgiGetir(){
        
        YemekDAO dao = new YemekDAO();
        Yemek y = new Yemek();
        
        y.setId(Integer.parseInt(tab_id.getText()));
        y.setGunler(tab_gunler.getText());
        y.setYemek(tab_yemek.getText());
        
        
        return y;
    }
    
    private void YemekGirdi(Yemek y){
        
        tab_id.setText(String.valueOf(y.getId()));
        tab_gunler.setText(y.getGunler());
        tab_yemek.setText(y.getYemek());
    }
    
}





