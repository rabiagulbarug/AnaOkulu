/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Data.Odeme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Secret
 */
public class OdemeDAO implements IDao<Odeme> {

    private Connection connection;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public OdemeDAO(){
        connection = DBConnection.createInstance().getConnection();
    }
            
    @Override
    public Odeme getItem(Odeme m) {
        try {
            stmt = connection.prepareStatement("SELECT * FROM Odeme WHERE OdemeID =?");
            stmt.setInt(1, m.getId());
            rs = stmt.executeQuery();
            rs.next();
            
            m.setVeliId(rs.getInt("veliId"));
            m.setToplamtutar(rs.getInt("toplamtutar"));
            m.setAysayisi(rs.getInt("aysayisi"));
            m.setOdenenmiktar(rs.getInt("odenenmiktar"));
            m.setKalanmiktar(rs.getInt("kalanmiktar"));

            return m;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            close();
        }

    }

    @Override
    public void insertItem(Odeme item) {

        try {
            stmt = connection.prepareStatement("INSERT INTO Odeme(VeliId,Toplamtutar,Aysayisi,Odenenmiktar,Kalanmiktar) VALUES (?,?,?,?,?)");

            stmt.setInt(1, item.getVeliId());
            stmt.setInt(2, item.getToplamtutar());
            stmt.setInt(3, item.getAysayisi());
            stmt.setInt(4, item.getOdenenmiktar());
            stmt.setInt(5, item.getKalanmiktar());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void deleteItem(Odeme item) {

        try {
            stmt = connection.prepareStatement("DELETE FROM Odeme WHERE OdemeID=?");

            stmt.setInt(1, item.getId());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public Odeme updateItem(Odeme item) {
        try {
            stmt = connection.prepareStatement("UPDATE Odeme SET  Toplamtutar=?,Aysayisi= ?,Odenenmiktar=?, Kalanmiktar=? WHERE VeliID=?");
            
           
            stmt.setInt(1, item.getToplamtutar());
            stmt.setInt(2, item.getAysayisi());
            stmt.setInt(3, item.getOdenenmiktar());
            stmt.setInt(4, item.getKalanmiktar());
          //  stmt.setInt(6, item.getId());
            stmt.setInt(5, item.getVeliId());


            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }

        return null;
    }

    @Override
    public ArrayList<Odeme> getItems() {

        Odeme m;
        ArrayList<Odeme> list = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM Odeme");
            rs = stmt.executeQuery();

            while (rs.next()) {
                m = new Odeme();
                
                m.setId(rs.getInt("OdemeID"));
                m.setVeliId(rs.getInt("VeliId"));
                m.setToplamtutar(rs.getInt("Toplamtutar"));
                m.setAysayisi(rs.getInt("Aysayisi"));
                m.setOdenenmiktar(rs.getInt("Odenenmiktar"));
                m.setKalanmiktar(rs.getInt("Kalanmiktar"));

                list.add(m);
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
