/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Data.Ogrenci;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Secret
 */
public class OgrenciDAO implements IDao<Ogrenci> {

    private Connection connection;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    
    public OgrenciDAO(){
        connection = DBConnection.createInstance().getConnection();
    }
    
    @Override
    public Ogrenci getItem(Ogrenci c) {

        try {
            stmt = connection.prepareStatement("SELECT * FROM Ogrenci WHERE OgrenciID=?");
            stmt.setInt(1, c.getId());
            rs = stmt.executeQuery();

            rs.next();

            c.setIsimSoyisim(rs.getString("IsimSoyisim"));
            c.setTckimlik(rs.getString("Tckimlik"));
            c.setAnneisim(rs.getString("Anneisim"));
            c.setBabaisim(rs.getString("Babaisim"));
            c.setTelefon(rs.getString("Telefon"));
            c.setTelefon2(rs.getString("Telefon2"));
            c.setAdres(rs.getString("Adres"));

            return c;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {
            close();

        }
    }

    @Override
    public void insertItem(Ogrenci item) {
        try {
            stmt = connection.prepareStatement("INSERT INTO Ogrenci(IsimSoyisim,Tckimlik,Anneisim,Babaisim,Telefon,Telefon2,Adres) VALUES (?,?,?,?,?,?,?)");

            stmt.setString(1, item.getIsimSoyisim());
            stmt.setString(2, item.getTckimlik());
            stmt.setString(3, item.getAnneisim());
            stmt.setString(4, item.getBabaisim());
            stmt.setString(5, item.getTelefon());
            stmt.setString(6, item.getTelefon2());
            stmt.setString(7, item.getAdres());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void deleteItem(Ogrenci item) {
        try {
            stmt = connection.prepareStatement("DELETE FROM Ogrenci WHERE OgrenciID=?");

            stmt.setInt(1, item.getId());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public Ogrenci updateItem(Ogrenci item) {
        try {
            stmt = connection.prepareStatement("UPDATE  Ogrenci SET IsimSoyisim=?,Tckimlik=?,Anneisim= ?,Babaisim= ?,Telefon=?,Telefon2=?,Adres=? WHERE OgrenciID = ?");

            stmt.setString(1, item.getIsimSoyisim());
            stmt.setString(2, item.getTckimlik());
            stmt.setString(3, item.getAnneisim());
            stmt.setString(4, item.getBabaisim());
            stmt.setString(5, item.getTelefon());
            stmt.setString(6, item.getTelefon2());
            stmt.setString(7, item.getAdres());
            stmt.setInt(8, item.getId());

            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }

        return null;

    }

    @Override
    public ArrayList<Ogrenci> getItems() {
        Ogrenci c;
        ArrayList<Ogrenci> list = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM Ogrenci");
            rs = stmt.executeQuery();

            while (rs.next()) {
                c = new Ogrenci();

                c.setId(rs.getInt("OgrenciID"));
                c.setIsimSoyisim(rs.getString("IsimSoyisim"));
                c.setTckimlik(rs.getString("Tckimlik"));
                c.setAnneisim(rs.getString("Anneisim"));
                c.setBabaisim(rs.getString("Babaisim"));
                c.setTelefon(rs.getString("Telefon"));
                c.setTelefon2(rs.getString("Telefon2"));
                c.setAdres(rs.getString("Adres"));

                list.add(c);
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
