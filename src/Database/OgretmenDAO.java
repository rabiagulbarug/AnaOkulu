/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Data.Ogretmen;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Secret
 */
public class OgretmenDAO implements IDao<Ogretmen> {

    private Connection connection;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    

    public OgretmenDAO() {
            connection = DBConnection.createInstance().getConnection();
    }

    public Ogretmen getItemOgretmenByMail(String mail, String sifre) {
        try {
            Ogretmen o = new Ogretmen();
            
            String sql =( "SELECT * FROM Ogretmen WHERE Mail=? AND Sifre=?");
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, mail);
            stmt.setString(2, sifre);
            rs = stmt.executeQuery();

            rs.next();
            o.setId(rs.getInt("OgretmenID"));
            o.setIsimSoyisim(rs.getString("IsimSoyisim"));
            o.setSifre(sifre);
            o.setTelefon(rs.getString("Telefon"));
            o.setMail(mail);
            o.setAdres(rs.getString("Adres"));
            
            return o;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            close();
        }
    }

    @Override
    public Ogretmen getItem(Ogretmen o) {

        try {
            stmt = connection.prepareStatement("SELECT * FROM Ogretmen WHERE OgretmenID=?");
            stmt.setInt(1, o.getId());
            rs = stmt.executeQuery();

            rs.next();

            o.setIsimSoyisim(rs.getString("IsimSoyisim"));
            o.setSifre(rs.getString("Sifre"));
            o.setTelefon(rs.getString("Telefon"));
            o.setMail(rs.getString("Mail"));
            o.setAdres(rs.getString("Adres"));

            return o;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {
            close();

        }
    }

    @Override
    public void insertItem(Ogretmen item) {
        try {
             stmt = connection.prepareStatement("INSERT INTO Ogretmen(IsimSoyisim,Sifre,Telefon,Mail,Adres) VALUES (?,?,?,?,?)");

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
    public void deleteItem(Ogretmen item) {
        try {
            stmt = connection.prepareStatement("DELETE FROM Ogretmen WHERE OgretmenID=?");

            stmt.setInt(1, item.getId());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public Ogretmen updateItem(Ogretmen item) {

        try {
            stmt = connection.prepareStatement("UPDATE  Ogretmen SET IsimSoyisim=?,Sifre = ?,Telefon=?,Mail=?,Adres=? WHERE OgretmenID = ?");

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
    public ArrayList<Ogretmen> getItems() {
        Ogretmen o;
        ArrayList<Ogretmen> list = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM Ogretmen");
            rs = stmt.executeQuery();

            while (rs.next()) {
                o = new Ogretmen();
                o.setId(rs.getInt("OgretmenID"));
                o.setIsimSoyisim(rs.getString("IsimSoyisim"));
                o.setSifre(rs.getString("Sifre"));
                o.setTelefon(rs.getString("Telefon"));
                o.setMail(rs.getString("Mail"));
                o.setAdres(rs.getString("Adres"));

                list.add(o);
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
