/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import Data.Ders;
import Data.Odeme;
import Data.Ogretmen;
import Data.Veli;
import Data.Yemek;
import Data.Yonetici;
import Database.DersDAO;
import Database.OdemeDAO;
import Database.OgretmenDAO;
import Database.VeliDAO;
import Database.YemekDAO;
import Database.YoneticiDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Secret
 */
public class PanelController implements Initializable {

    @FXML
    private TabPane pnl_main;
    @FXML
    private Tab tab_yonetici;
    @FXML
    private AnchorPane pan_yonetici;
    @FXML
    private Button btn_kayit;
    @FXML
    private Button btn_ogretmen_yonetim;
    @FXML
    private Button btn_veli_yonetim;
    @FXML
    private Button btn_ogrenci_yonetim;
    @FXML
    private Button btn_ders_programi;
    @FXML
    private Tab tab_yoneticibilgi;
    @FXML
    private AnchorPane pan_yoneticibilgi;
    @FXML
    private TextArea txt_yadres;
    @FXML
    private TextField txt_ytelefon;
    @FXML
    private TextField txt_ymail;
    @FXML
    private TextField txt_ysifre;
    @FXML
    private TextField txt_yisim;
    @FXML
    private TextField txt_yId;
    @FXML
    private Button btn_yonetici_kaydet;
    @FXML
    private Tab tab_ogretmen;
    @FXML
    private AnchorPane pan_ogretmen;
    @FXML
    private Button btn_ders_takip;
    @FXML
    private Button btn_ogrenci_bilgi;
    @FXML
    private TextArea text_not;
    @FXML
    private Tab tab_ogretmenbilgi;
    @FXML
    private AnchorPane pan_ogretmen1;
    @FXML
    private TextField txt_ogretmen_isim;
    @FXML
    private TextField txt_ogretmen_tel;
    @FXML
    private TextField txt_ogretmen_mail;
    @FXML
    private TextArea txt_ogretmen_adres;
    @FXML
    private TextField txt_ogretmenId;
    @FXML
    private TextField txt_ogretmen_sifre;
    @FXML
    private Tab tab_veli;
    @FXML
    private AnchorPane pan_veli;
    @FXML
    private TableView<Ders> table_ders1;
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
    private Button btn_yemek_listesi;
    @FXML
    private Tab tab_velibilgi;
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
    private Button btn_veli_guncelle;
    @FXML
    private TextField txt_veliId;
    @FXML
    private TextField txt_veli_tel2;
    @FXML
    private TextField txt_veli_sifre;

    //OLUŞTURDUKLARIM
    private ObservableList<Ders> list_ders = null;

    private ObservableList<Yemek> list_yemek = null;

    private ObservableList<Veli> list_veli = null;

    private Veli secili_veli = null;

    private Yemek secili_yemek = null;
    private Ders secili_ders = null;

    private DersDAO dersDAO = null;
    @FXML
    private Button btn_yonetici_guncelle;
    @FXML
    private Button btn_ogretmen_guncelle;
    @FXML
    private Label lblStatus;
    @FXML
    private Label lblStatus1;
    @FXML
    private Label lblStatus2;
    @FXML
    private Button btn_odeme_kontrol;
    @FXML
    private Tab tab_yemek;
    @FXML
    private AnchorPane pan_yemek;
    @FXML
    private TableView<Yemek> tab_yemeklistesi;
    @FXML
    private TableColumn<?, ?> kln_gunler;
    @FXML
    private TableColumn<?, ?> kln_yemek;
    @FXML
    private Button btn_yemek;
    @FXML
    private TextField txt_yiyecek;
    @FXML
    private TextField txt_gun;

    private Object kullanici = null;
    private Veli kullanici_veli = null;
    private Yonetici kullanici_yonetici = null;
    private Ogretmen kullanici_ogretmen = null;
    @FXML
    private TableColumn<?, ?> kln_veliID;
    @FXML
    private TableColumn<?, ?> kln_veli;
    @FXML
    private TableView<Veli> table_veli2;
    @FXML
    private Tab tab_odemebilgi;
    @FXML
    private Button btn_odeme_kaydet;
    @FXML
    private TextField txt_veliId1;
    @FXML
    private TextField txt_kalanmiktar;
    @FXML
    private TextField txt_odenenmiktar;
    @FXML
    private TextField txt_aysayisi;
    @FXML
    private TextField txt_toplamtutar;
    @FXML
    private AnchorPane pan_odeme;
    @FXML
    private TableColumn<?, ?> kln_veli_telefonno;
    @FXML
    private Button btn_sil;

    public PanelController(Object kullanici) {
        this.kullanici = kullanici;

    }

    // private VeliDAO veliDAO = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (kullanici != null) {

            if (kullanici instanceof Yonetici) {
                kullanici_yonetici = (Yonetici) kullanici;

                pnl_main.getTabs().remove(tab_ogretmen);
                pnl_main.getTabs().remove(tab_veli);
                pnl_main.getTabs().remove(tab_ogretmenbilgi);
                pnl_main.getTabs().remove(tab_velibilgi);
                pnl_main.getTabs().remove(tab_odemebilgi);

                YoneticiGirdi(kullanici_yonetici);

            } else if (kullanici instanceof Ogretmen) {
                kullanici_ogretmen = (Ogretmen) kullanici;

                pnl_main.getTabs().remove(tab_veli);
                pnl_main.getTabs().remove(tab_yonetici);
                pnl_main.getTabs().remove(tab_yoneticibilgi);
                pnl_main.getTabs().remove(tab_velibilgi);
                pnl_main.getTabs().remove(tab_yemek);
                pnl_main.getTabs().remove(tab_odemebilgi);

                OgretmenGirdi(kullanici_ogretmen);

            } else {
                kullanici_veli = (Veli) kullanici;

                pnl_main.getTabs().remove(tab_yonetici);
                pnl_main.getTabs().remove(tab_yoneticibilgi);
                pnl_main.getTabs().remove(tab_ogretmen);
                pnl_main.getTabs().remove(tab_ogretmenbilgi);
                pnl_main.getTabs().remove(tab_yemek);

                VeliGirdi(kullanici_veli);
                Odeme();
            }
        }

        // kln_saatID.setCellValueFactory(new PropertyValueFactory<>("id"));
        kln_saat.setCellValueFactory(new PropertyValueFactory<>("saat"));
        kln_pazartesi.setCellValueFactory(new PropertyValueFactory<>("pazartesi"));
        kln_sali.setCellValueFactory(new PropertyValueFactory<>("sali"));
        kln_carsamba.setCellValueFactory(new PropertyValueFactory<>("carsamba"));
        kln_persembe.setCellValueFactory(new PropertyValueFactory<>("persembe"));
        kln_cuma.setCellValueFactory(new PropertyValueFactory<>("cuma"));

        list_ders = FXCollections.observableArrayList();
        dersTabloGuncelle();
        table_ders1.setItems(list_ders);
        table_ders1.setOnMouseClicked((MouseEvent event) -> {
            secili_ders = (Ders) table_ders1.getSelectionModel().getSelectedItem();

        });

        kln_gunler.setCellValueFactory(new PropertyValueFactory<>("gunler"));
        kln_yemek.setCellValueFactory(new PropertyValueFactory<>("yemek"));

        list_yemek = FXCollections.observableArrayList();
        tab_yemeklistesi.setItems(list_yemek);
        yemekTabloGuncelle();
        tab_yemeklistesi.setOnMouseClicked((MouseEvent event) -> {
            secili_yemek = (Yemek) tab_yemeklistesi.getSelectionModel().getSelectedItem();

        });

        kln_veliID.setCellValueFactory(new PropertyValueFactory<>("id"));
        kln_veli.setCellValueFactory(new PropertyValueFactory<>("IsimSoyisim"));
        kln_veli_telefonno.setCellValueFactory(new PropertyValueFactory<>("telefon"));

        list_veli = FXCollections.observableArrayList();
        veliTabloGuncelle();
        table_veli2.setItems(list_veli);
        table_veli2.setOnMouseClicked((MouseEvent event) -> {
            secili_veli = (Veli) table_veli2.getSelectionModel().getSelectedItem();

        });

    }

    @FXML
    private void Tiklandi_OgretmenYonetim(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/anaokulu/panelOgretmenYonetim.fxml")); //fxml dosyası parent referansına yuklend

            Stage stage = new Stage();//yeni pencere olusturuldu
            stage.setScene(new Scene(root)); // pencerenin icine dosyadaki yerlestirildi
            stage.getScene().getStylesheets().add(getClass().getResource("/css/css2.css").toExternalForm());
            stage.show(); //pencere gosterildi

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Tiklandi_Veli_Yonetim(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/anaokulu/panelVeliYonetim.fxml")); //fxml dosyası parent referansına yuklend

            Stage stage = new Stage();//yeni pencere olusturuldu
            stage.setScene(new Scene(root)); // pencerenin icine dosyadaki yerlestirildi
            stage.getScene().getStylesheets().add(getClass().getResource("/css/css4.css").toExternalForm());
            stage.show(); //pencere gosterildi 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Tiklandi_OgrenciYonetim(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/anaokulu/panelOgrenciYonetim.fxml")); //fxml dosyası parent referansına yuklend

            Stage stage = new Stage();//yeni pencere olusturuldu
            stage.setScene(new Scene(root)); // pencerenin icine dosyadaki yerlestirildi
            stage.getScene().getStylesheets().add(getClass().getResource("/css/css3.css").toExternalForm());
            stage.show(); //pencere gosterildi

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Tiklandi_Ders_Programi(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/anaokulu/panelDersProgram.fxml")); //fxml dosyası parent referansına yuklend

            Stage stage = new Stage();//yeni pencere olusturuldu
            stage.setScene(new Scene(root)); // pencerenin icine dosyadaki yerlestirildi
            stage.getScene().getStylesheets().add(getClass().getResource("/css/css10.css").toExternalForm());
            stage.show(); //pencere gosterildi

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Tiklandi_Yonetici_Kaydet(ActionEvent event) {
        YoneticiDAO yoneticiDAO = new YoneticiDAO();
        yoneticiDAO.insertItem(YoneticiOlustur());

        if (YoneticiOlustur() != null) {
            lblStatus1.setText("Kayıt Başarılı...");
        } else {
            lblStatus1.setText("Kayıt Yapılamadı...");
        }

    }

    @FXML
    private void Tiklandi_Yonetici_Guncelle(ActionEvent event) {
        YoneticiDAO yoneticiDAO = new YoneticiDAO();
        yoneticiDAO.updateItem(YoneticiBilgiGetir());

        if (YoneticiBilgiGetir() != null) {
            lblStatus1.setText("Güncelleme Başarılı...");
        } else {
            lblStatus1.setText("Güncelleme Yapılamadı...");
        }

    }

    @FXML
    private void Tiklandi_DersTakip(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/anaokulu/DersTakip.fxml")); //fxml dosyası parent referansına yuklend

            Stage stage = new Stage();//yeni pencere olusturuldu
            stage.setScene(new Scene(root)); // pencerenin icine dosyadaki yerlestirildi
            stage.getScene().getStylesheets().add(getClass().getResource("/css/css5.css").toExternalForm());
            stage.show(); //pencere gosterildi

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Tiklandi_OgrenciBilgi(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/anaokulu/OgrenciTablo.fxml")); //fxml dosyası parent referansına yuklend

            Stage stage = new Stage();//yeni pencere olusturuldu
            stage.setScene(new Scene(root)); // pencerenin icine dosyadaki yerlestirildi
            stage.getScene().getStylesheets().add(getClass().getResource("/css/css6.css").toExternalForm());
            stage.show(); //pencere gosterildi

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Tiklandi_OgretmenKaydet(ActionEvent event) {
        OgretmenDAO ogretmenDAO = new OgretmenDAO();
        ogretmenDAO.insertItem(OgretmenOlustur());

        if (OgretmenOlustur() != null) {
            lblStatus2.setText("Kayıt Başarılı...");
        } else {
            lblStatus2.setText("Kayıt Yapılamadı...");
        }
    }

    @FXML
    private void Tiklandi_Ogretmen_Guncelle(ActionEvent event) {
        OgretmenDAO ogretmenDAO = new OgretmenDAO();
        ogretmenDAO.updateItem(OgretmenBilgiGetir());

        if (OgretmenBilgiGetir() != null) {
            lblStatus2.setText("Guncelleme Başarılı...");
        } else {
            lblStatus2.setText("Guncelleme Yapılamadı...");
        }

    }

    @FXML
    private void Tiklandi_YemekListesi(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/anaokulu/YemekListesi.fxml")); //fxml dosyası parent referansına yuklend

            Stage stage = new Stage();//yeni pencere olusturuldu
            stage.setScene(new Scene(root)); // pencerenin icine dosyadaki yerlestirildi
            stage.getScene().getStylesheets().add(getClass().getResource("/css/css8.css").toExternalForm());
            stage.show(); //pencere gosterildi

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Tiklandi_VeliKaydet(ActionEvent event) {
        VeliDAO veliDAO = new VeliDAO();
        veliDAO.insertItem(veliOlustur());

        if (veliOlustur() != null) {
            lblStatus.setText("Kayıt Başarılı...");
        } else {
            lblStatus.setText("Kayıt Yapılamadı...");
        }
    }

    @FXML
    private void Tiklandi_veli_guncelle(ActionEvent event) {
        VeliDAO veliDAO = new VeliDAO();
        veliDAO.updateItem(VeliBilgiGetir());

        if (VeliBilgiGetir() != null) {
            lblStatus.setText("Güncelleme Başarılı...");
        } else {
            lblStatus.setText("Guncelleme Yapılamadı...");
        }

    }

    @FXML
    private void Tiklandi_OdemeKontrol(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/anaokulu/OdemeKontrol.fxml")); //fxml dosyası parent referansına yuklend

            Stage stage = new Stage();//yeni pencere olusturuldu
            stage.setScene(new Scene(root)); // pencerenin icine dosyadaki yerlestirildi
            stage.getScene().getStylesheets().add(getClass().getResource("/css/css7.css").toExternalForm());
            stage.show(); //pencere gosterildi

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Tiklandi_Odeme_Kaydet(ActionEvent event) {
        OdemeDAO odemeDAO = new OdemeDAO();
        odemeDAO.updateItem(odemeOlustur());

        Stage stage = (Stage) btn_odeme_kaydet.getScene().getWindow();
        stage.show();
    }

    private void Odeme() {
        OdemeDAO dao = new OdemeDAO();
        Odeme o = new Odeme();
        o.setVeliId(kullanici_veli.getId());

        o = dao.getItems().get(0);

        OdemeGirdi(o);

    }

    private Yonetici YoneticiBilgiGetir() {

        YoneticiDAO yoneticiDAO = new YoneticiDAO();
        Yonetici y = new Yonetici();

        y.setId(Integer.parseInt(txt_yId.getText()));
        y.setIsimSoyisim(txt_yisim.getText());
        y.setSifre(txt_ysifre.getText());
        y.setTelefon(txt_ytelefon.getText());
        y.setMail(txt_ymail.getText());
        y.setAdres(txt_yadres.getText());

        return y;
    }

    private Yonetici YoneticiOlustur() {

        Yonetici y = new Yonetici();

        y.setIsimSoyisim(txt_yisim.getText());
        y.setSifre(txt_ysifre.getText());
        y.setTelefon(txt_ytelefon.getText());
        y.setMail(txt_ymail.getText());
        y.setAdres(txt_yadres.getText());

        return y;
    }

    private void YoneticiGirdi(Yonetici y) {

        txt_yId.setText(String.valueOf(y.getId()));
        txt_yisim.setText(y.getIsimSoyisim());
        txt_ysifre.setText(y.getSifre());
        txt_ymail.setText(y.getMail());
        txt_ytelefon.setText(y.getTelefon());
        txt_yadres.setText(y.getAdres());
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

    private Ogretmen OgretmenOlustur() {

        Ogretmen o = new Ogretmen();

        o.setIsimSoyisim(txt_ogretmen_isim.getText());
        o.setSifre(txt_ogretmen_sifre.getText());
        o.setTelefon(txt_ogretmen_tel.getText());
        o.setMail(txt_ogretmen_mail.getText());
        o.setAdres(txt_ogretmen_adres.getText());

        return o;

    }

    private void OgretmenGirdi(Ogretmen o) {

        txt_ogretmenId.setText(String.valueOf(o.getId()));
        txt_ogretmen_isim.setText(o.getIsimSoyisim());
        txt_ogretmen_sifre.setText(o.getSifre());
        txt_ogretmen_mail.setText(o.getMail());
        txt_ogretmen_tel.setText(o.getTelefon());
        txt_ogretmen_adres.setText(o.getAdres());

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

    private Veli veliOlustur() {

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

    private Ders DersBilgiGetir1() {

        DersDAO dao = new DersDAO();
        Ders d = new Ders();

        // d.setId(Integer.parseInt(kln_saatID.getText()));
        d.setSaat(kln_saat.getText());
        d.setPazartesi(kln_pazartesi.getText());
        d.setSali(kln_sali.getText());
        d.setCarsamba(kln_carsamba.getText());
        d.setPersembe(kln_persembe.getText());
        d.setCuma(kln_cuma.getText());

        return d;

    }

    private void DersGirdi1(Ders d) {

        //  kln_saatID.setText(String.valueOf(d.getId()));
        kln_saat.setText(d.getSaat());
        kln_pazartesi.setText(d.getPazartesi());
        kln_sali.setText(d.getSali());
        kln_carsamba.setText(d.getCarsamba());
        kln_persembe.setText(d.getPersembe());
        kln_cuma.setText(d.getCuma());
    }

    private void dersTabloGuncelle() {

        list_ders.clear();
        DersDAO dersDAO = new DersDAO();
        list_ders.addAll(dersDAO.getItems());
        table_ders1.getItems();

    }

    private void yemekTabloGuncelle() {
        list_yemek.clear();
        YemekDAO yemekDAO = new YemekDAO();
        list_yemek.addAll(yemekDAO.getItems());
        tab_yemeklistesi.getItems();
    }

    private void veliTabloGuncelle() {

        list_veli.clear();
        VeliDAO veliDAO = new VeliDAO();
        list_veli.addAll(veliDAO.getItems());
        table_veli2.getItems();

    }

    private void VeliGirdi2(Veli v) {

        kln_veliID.setText(String.valueOf(v.getId()));
        kln_veli.setText(v.getIsimSoyisim());
        kln_veli_telefonno.setText(v.getTelefon());

    }

    private Veli VeliBilgiGetir2() {

        VeliDAO veliDAO = new VeliDAO();
        Veli v = new Veli();

        v.setId(Integer.parseInt(kln_veliID.getText()));
        v.setIsimSoyisim(kln_veli.getText());
        v.setTelefon(kln_veli_telefonno.getText());

        return v;
    }

    private Yemek YemekOlustur() {

        YemekDAO dao = new YemekDAO();
        Yemek y = new Yemek();

        y.setGunler(txt_gun.getText());
        y.setYemek(txt_yiyecek.getText());

        return y;
    }

    @FXML
    private void Tiklandi_Yemek(ActionEvent event) {
        YemekDAO yemekDAO = new YemekDAO();
        yemekDAO.insertItem(YemekOlustur());
        yemekTabloGuncelle();

        Stage stage = (Stage) btn_yemek.getScene().getWindow();
        stage.show();
    }

    private Odeme OdemeBilgiGetir() {

        OdemeDAO odemeDAO = new OdemeDAO();
        Odeme o = new Odeme();

        o.setVeliId(Integer.parseInt(txt_veliId1.getText()));;
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

        txt_veliId1.setText(String.valueOf(o.getVeliId()));
        txt_toplamtutar.setText(String.valueOf(o.getToplamtutar()));
        txt_aysayisi.setText(String.valueOf(o.getAysayisi()));
        txt_odenenmiktar.setText(String.valueOf(o.getOdenenmiktar()));
        txt_kalanmiktar.setText(String.valueOf(o.getKalanmiktar()));
    }

    private Odeme odemeOlustur() {

        OdemeDAO odemeDAO = new OdemeDAO();
        Odeme o = new Odeme();

        o.setVeliId(Integer.parseInt(txt_veliId1.getText()));
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

    @FXML
    private void Tiklandi_Yemek_Sil(ActionEvent event) {
        YemekDAO yemekDAO = new YemekDAO();
        yemekDAO.deleteItem(secili_yemek);
        yemekTabloGuncelle();

        Stage stage = (Stage) btn_sil.getScene().getWindow();
        stage.show();
    }
}
