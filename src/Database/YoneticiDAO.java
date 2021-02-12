/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Data.Yonetici;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Secret
 */
public class YoneticiDAO implements IDao<Yonetici> {

    private Connection connection = null ;
      private PreparedStatement stmt = null ;
    private ResultSet rs =null;
    
    public YoneticiDAO(){
        connection = DBConnection.createInstance().getConnection();
    }

    public Yonetici getItemYoneticiByMail(String mail, String sifre) {

        try {
            Yonetici y = new Yonetici();
            stmt = connection.prepareStatement("SELECT * FROM yonetici WHERE Mail=? AND Sifre=?");

            stmt.setString(1, mail);
            stmt.setString(2, sifre);

            rs = stmt.executeQuery();

            rs.next();
            y.setId(rs.getInt("YoneticiID"));
            y.setIsimSoyisim(rs.getString("IsimSoyisim"));
            y.setSifre(sifre);
            y.setTelefon(rs.getString("Telefon"));
            y.setMail(mail);
            y.setAdres(rs.getString("Adres"));

            return y;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {
            close();
        }
    }

    @Override
    public Yonetici getItem(Yonetici y) {
        try {
            stmt = connection.prepareStatement("SELECT * FROM Yonetici WHERE YoneticiID=?");
            stmt.setInt(1, y.getId());
            rs = stmt.executeQuery();

            rs.next();

            y.setIsimSoyisim(rs.getString("IsimSoyisim"));
            y.setSifre(rs.getString("Sifre"));
            y.setTelefon(rs.getString("Telefon"));
            y.setMail(rs.getString("Mail"));
            y.setAdres(rs.getString("Adres"));

            return y;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {
            close();

        }

    }

    @Override
    public void insertItem(Yonetici item) {
        try {
            stmt = connection.prepareStatement("INSERT INTO Yonetici(IsimSoyisim,Sifre,Telefon,Mail,Adres) VALUES (?,?,?,?,?)");

            stmt.setString(1, item.getIsimSoyisim());
            stmt.setString(2, item.getSifre());
            stmt.setString(3, item.getTelefon());
            stmt.setString(4, item.getMail());
            stmt.setString(5, item.getAdres());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }

    }

    @Override
    public void deleteItem(Yonetici item) {
        try {
            stmt = connection.prepareStatement("DELETE FROM Yonetici WHERE YoneticiID=?");

            stmt.setInt(1, item.getId());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public Yonetici updateItem(Yonetici item) {
        try {
            stmt = connection.prepareStatement("UPDATE Yonetici SET IsimSoyisim=?,Sifre = ?,Telefon=?,Mail=?,Adres=? WHERE YoneticiID=?");

            stmt.setString(1, item.getIsimSoyisim());
            stmt.setString(2, item.getSifre());
            stmt.setString(3, item.getTelefon());
            stmt.setString(4, item.getMail());
            stmt.setString(5, item.getAdres());
            stmt.setInt(6, item.getId());

            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }

        return null;
    }

    @Override
    public ArrayList<Yonetici> getItems() {
        Yonetici n;
        ArrayList<Yonetici> list = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM Yonetici");
            rs = stmt.executeQuery();

            while (rs.next()) {
                n = new Yonetici();

                n.setId(rs.getInt("YoneticiID"));
                n.setIsimSoyisim(rs.getString("IsimSoyisim"));
                n.setSifre(rs.getString("Sifre"));
                n.setTelefon(rs.getString("Telefon"));
                n.setMail(rs.getString("Mail"));
                n.setAdres(rs.getString("Adres"));

                list.add(n);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    private void close() {
        try {

            if (rs != null && !rs.isClosed()) {
                stmt.close();
            }
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
