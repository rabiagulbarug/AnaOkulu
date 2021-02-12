/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import Data.Odeme;
import Database.OdemeDAO;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Secret
 */
public class OdemeKontrolController implements Initializable {

    @FXML
    private Button btn_odeme_guncelle;
    @FXML
    private TextField txt_kalanmiktar;
    @FXML
    private TextField txt_odenenmiktar;
    @FXML
    private TableView<Odeme> tab_odemebilgi;
    @FXML
    private TableColumn<?, ?> kln_veliID;
    @FXML
    private TableColumn<?, ?> kln_toplamtutar;
    @FXML
    private TableColumn<?, ?> kln_aysayisi;
    @FXML
    private TableColumn<?, ?> kln_odenenmiktar;
    @FXML
    private TableColumn<?, ?> kln_kalanmiktar;
    @FXML
    private TextField txt_aysayisi;
    @FXML
    private TextField txt_toplamtutar;
    @FXML
    private TextField txt_odemekontrol;
    private ObservableList<Odeme> list_odeme = null;

    private Odeme secili_odeme = null;
    private Button btn_odeme_kaydet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        kln_veliID.setCellValueFactory(new PropertyValueFactory<>("veliId"));
        kln_toplamtutar.setCellValueFactory(new PropertyValueFactory<>("toplamtutar"));
        kln_aysayisi.setCellValueFactory(new PropertyValueFactory<>("aysayisi"));
        kln_odenenmiktar.setCellValueFactory(new PropertyValueFactory<>("odenenmiktar"));
        kln_kalanmiktar.setCellValueFactory(new PropertyValueFactory<>("kalanmiktar"));

        list_odeme = FXCollections.observableArrayList();
           odemeTabloGuncelle();
        tab_odemebilgi.setItems(list_odeme);
        tab_odemebilgi.setOnMouseClicked((MouseEvent event) -> {

            secili_odeme = (Odeme) tab_odemebilgi.getSelectionModel().getSelectedItem();

        });
    }

    private void odemeTabloGuncelle() {
        list_odeme.clear();
        OdemeDAO dao = new OdemeDAO();
        list_odeme.addAll(dao.getItems());
        tab_odemebilgi.getItems();
    }

   

    private Odeme OdemeBilgiGetir() {
         OdemeDAO dao = new OdemeDAO();
        Odeme o = new Odeme();

       // o.setId(Integer.parseInt(kln_odemeID.getText()));
        o.setVeliId(Integer.parseInt(kln_veliID.getText()));
        o.setToplamtutar(Integer.parseInt(kln_toplamtutar.getText()));
        o.setAysayisi(Integer.parseInt(kln_aysayisi.getText()));
        o.setOdenenmiktar(Integer.parseInt(kln_odenenmiktar.getText()));
        o.setKalanmiktar(Integer.parseInt(kln_kalanmiktar.getText()));

        return o;

    }

    private Odeme odemeOlustur() {
            
        OdemeDAO dao = new OdemeDAO();
        Odeme o = new Odeme();
        
         //  o.setId(Integer.parseInt(txt_odemeID.getText()));
        o.setVeliId(Integer.parseInt(txt_odemekontrol.getText()));
        o.setToplamtutar(Integer.parseInt(txt_toplamtutar.getText()));
        o.setAysayisi(Integer.parseInt(txt_aysayisi.getText()));
        o.setOdenenmiktar(Integer.parseInt(txt_odenenmiktar.getText()));

        int a = Integer.parseInt(txt_toplamtutar.getText());
        int b = Integer.parseInt(txt_odenenmiktar.getText());
        int c = a - b;
        String toplam = String.valueOf(c);

        txt_kalanmiktar.setText(toplam);

        o.setKalanmiktar(c);

        return o;
        
    }

    private void OdemeGirdi(Odeme o) {

        kln_veliID.setText(String.valueOf(o.getVeliId()));
        kln_toplamtutar.setText(String.valueOf(o.getToplamtutar()));
        kln_aysayisi.setText(String.valueOf(o.getAysayisi()));
        kln_odenenmiktar.setText(String.valueOf(o.getOdenenmiktar()));
        kln_kalanmiktar.setText(String.valueOf(o.getKalanmiktar()));

    }
    private Odeme OdemeBilgiGetir2(){
        OdemeDAO dao = new OdemeDAO();
        Odeme o = new Odeme();

        o.setVeliId(Integer.parseInt(txt_odemekontrol.getText()));
        o.setToplamtutar(Integer.parseInt(txt_toplamtutar.getText()));
        o.setAysayisi(Integer.parseInt(txt_aysayisi.getText()));
        o.setOdenenmiktar(Integer.parseInt(txt_odenenmiktar.getText()));
    //  o.setKalanmiktar(Integer.parseInt(txt_kalanmiktar.getText()));
         int a = Integer.parseInt(txt_toplamtutar.getText());
        int b = Integer.parseInt(txt_odenenmiktar.getText());
        int c = a - b;
        String toplam = String.valueOf(c);

        txt_kalanmiktar.setText(toplam);

        o.setKalanmiktar(c);
        
        
     
        return o;
       
    }

    @FXML
    private void Tiklandi_Odeme_Guncelle(ActionEvent event) {
         OdemeDAO odemeDAO = new OdemeDAO();
         odemeDAO.updateItem(OdemeBilgiGetir2());
         
        Stage stage = (Stage)btn_odeme_guncelle.getScene().getWindow();
        stage.show(); 
        odemeTabloGuncelle();       
    }
    private void Tiklandi_Odeme_Kaydet(ActionEvent event) {
        OdemeDAO odemeDAO = new OdemeDAO();
        odemeDAO.insertItem(odemeOlustur());

        Stage stage = (Stage)btn_odeme_kaydet.getScene().getWindow();
        stage.show(); 
        odemeTabloGuncelle();

    }

}