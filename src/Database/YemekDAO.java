/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Data.Yemek;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Secret
 */
public class YemekDAO implements IDao<Yemek> {
    private Connection connection;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public YemekDAO(){
        connection = DBConnection.createInstance().getConnection();
    }
    
    @Override
    public Yemek getItem(Yemek k) {
        try {
            stmt = connection.prepareStatement("SELECT * FROM Yemeklistesi WHERE ID=?");
            stmt.setInt(1, k.getId());
            rs = stmt.executeQuery();

            rs.next();

            k.setGunler(rs.getString("Gunler"));
            k.setYemek(rs.getString("Yemek"));

            return k;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {
            close();

        }
    }

    @Override
    public void insertItem(Yemek item) {
        try {
            stmt = connection.prepareStatement("INSERT INTO Yemeklistesi(Gunler,Yemek) VALUES (?,?)");

            stmt.setString(1, item.getGunler());
            stmt.setString(2, item.getYemek());
           
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void deleteItem(Yemek item) {
        try {
            stmt = connection.prepareStatement("DELETE FROM Yemeklistesi WHERE ID=?");

            stmt.setInt(1, item.getId());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public Yemek updateItem(Yemek item) {
        try {
            stmt = connection.prepareStatement("UPDATE Ders SET Gunler=?, Yemek=? WHERE ID = ?");

            stmt.setString(1, item.getGunler());
            stmt.setString(2, item.getYemek());
           
         
            stmt.setInt(3, item.getId());

            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }

        return null;
    }

    @Override
    public ArrayList<Yemek> getItems() {
        Yemek k;
        ArrayList<Yemek> list = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("Select * from Yemeklistesi");
            rs = stmt.executeQuery();
            while (rs.next()) {
                k = new Yemek();
                
                k.setId(rs.getInt("ID"));
                k.setGunler(rs.getString("Gunler"));
                k.setYemek(rs.getString("Yemek"));

                list.add(k);
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
    public static void main(String[] args) {
        YemekDAO dao = new YemekDAO();
        
        ArrayList<Yemek> list = dao.getItems();
        for(Yemek d: list){
            
            System.out.println(d.getId());
            System.out.println(d.getGunler());
            System.out.println(d.getYemek());
            
        }
        
        
        
    }
    
}
