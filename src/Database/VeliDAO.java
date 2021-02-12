/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Data.Veli;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Secret
 */
public class VeliDAO implements IDao<Veli> {

    private Connection connection ;
    private PreparedStatement stmt ;
    private ResultSet rs ;

    public VeliDAO() {
         connection = DBConnection.createInstance().getConnection();
    }

    public Veli getItemVeliByMail(String mail, String sifre) {
        try {
            Veli v = new Veli();
            stmt = connection.prepareStatement("SELECT * FROM veli WHERE Mail=? AND Sifre=?");

            stmt.setString(1, mail);
            stmt.setString(2, sifre);
            rs = stmt.executeQuery();
            
            rs.next();
            v.setId(rs.getInt("VeliID"));
            v.setIsimSoyisim(rs.getString("IsimSoyisim"));
            v.setSifre(sifre);
            v.setTelefon(rs.getString("Telefon"));
            v.setTelefon2(rs.getString("Telefon2"));
            v.setMail(mail);
            v.setAdres(rs.getString("Adres"));

            return v;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    @Override
    public Veli getItem(Veli v) {

        try {
            stmt = connection.prepareStatement("SELECT * FROM Veli WHERE VeliID=?");
            stmt.setInt(1, v.getId());
            rs = stmt.executeQuery();

            rs.next();

            v.setIsimSoyisim(rs.getString("IsimSoyisim"));
            v.setSifre(rs.getString("Sifre"));
            v.setTelefon(rs.getString("Telefon"));
            v.setTelefon(rs.getString("Telefon2"));
            v.setMail(rs.getString("Mail"));
            v.setAdres(rs.getString("Adres"));

            return v;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {
            close();

        }
    }

    @Override
    public void insertItem(Veli item) {
        try {
            stmt = connection.prepareStatement("INSERT INTO Veli(IsimSoyisim,Sifre,Telefon,Telefon2,Mail,Adres) VALUES (?,?,?,?,?,?)");

            stmt.setString(1, item.getIsimSoyisim());
            stmt.setString(2, item.getSifre());
            stmt.setString(3, item.getTelefon());
            stmt.setString(4, item.getTelefon2());
            stmt.setString(5, item.getMail());
            stmt.setString(6, item.getAdres());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void deleteItem(Veli item) {
        try {
            stmt = connection.prepareStatement("DELETE FROM Veli WHERE VeliID=?");

            stmt.setInt(1, item.getId());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }

    }

    @Override
    public Veli updateItem(Veli item) {
        try {
            stmt = connection.prepareStatement("UPDATE  Veli SET IsimSoyisim=?,Sifre =?,Telefon=?,Telefon2=?,Mail=?,Adres=? WHERE VeliID = ?");

            stmt.setString(1, item.getIsimSoyisim());
            stmt.setString(2, item.getSifre());
            stmt.setString(3, item.getTelefon());
            stmt.setString(4, item.getTelefon2());
            stmt.setString(5, item.getMail());
            stmt.setString(6, item.getAdres());
            stmt.setInt(7, item.getId());

            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }

        return null;
    }

    @Override
    public ArrayList<Veli> getItems() {
        Veli v;
        ArrayList<Veli> list = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM Veli");
            rs = stmt.executeQuery();

            while (rs.next()) {
                v = new Veli();
                v.setId(rs.getInt("VeliID"));
                v.setIsimSoyisim(rs.getString("IsimSoyisim"));
                v.setSifre(rs.getString("Sifre"));
                v.setTelefon(rs.getString("Telefon"));
                v.setTelefon(rs.getString("Telefon2"));
                v.setMail(rs.getString("Mail"));
                v.setAdres(rs.getString("Adres"));

                list.add(v);
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
