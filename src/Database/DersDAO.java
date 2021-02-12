/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Data.Ders;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Secret
 */
public class DersDAO implements IDao<Ders> {

    private Connection connection;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    
    public DersDAO(){
        connection = DBConnection.createInstance().getConnection();
    }

    @Override
    public Ders getItem(Ders d) {
        try {
            stmt = connection.prepareStatement("SELECT * FROM Ders WHERE SaatID=?");
            stmt.setInt(1, d.getId());
            rs = stmt.executeQuery();

            rs.next();
            
            d.setSaat(rs.getString("Saat"));
            d.setPazartesi(rs.getString("Pazartesi"));
            d.setSali(rs.getString("Sali"));
            d.setCarsamba(rs.getString("Carsamba"));
            d.setPersembe(rs.getString("Persembe"));
            d.setCuma(rs.getString("Cuma"));

            return d;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        } finally {
            close();

        }
    }

    @Override
    public void insertItem(Ders item) {

        try {
            stmt = connection.prepareStatement("INSERT INTO Ders(OgretmenID, Saat,Pazartesi,Sali,Carsamba,Persembe,Cuma) VALUES (?,?,?,?,?,?,?)");
            
            stmt.setInt(1, item.getOgretmenID());
            stmt.setString(2, item.getSaat());
            stmt.setString(3, item.getPazartesi());
            stmt.setString(4, item.getSali());
            stmt.setString(5, item.getCarsamba());
            stmt.setString(6, item.getPersembe());
            stmt.setString(7, item.getCuma());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void deleteItem(Ders item) {
        try {
            stmt = connection.prepareStatement("DELETE FROM Ders WHERE SaatID=?");

            stmt.setInt(1, item.getId());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public Ders updateItem(Ders item) {
        try {
            stmt = connection.prepareStatement("UPDATE Ders SET Saat=?, Pazartesi=?,Sali= ?,Carsamba=?,Persembe=?,Cuma=? WHERE SaatID = ?");

            stmt.setString(1, item.getSaat());
            stmt.setString(2, item.getPazartesi());
            stmt.setString(3, item.getSali());
            stmt.setString(4, item.getCarsamba());
            stmt.setString(5, item.getPersembe());
            stmt.setString(6, item.getCuma());
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
    public ArrayList<Ders> getItems() {
        
        Ders d;
        ArrayList<Ders> list = new ArrayList<>();
        try {
         //   stmt = connection.prepareStatement("SELECT * FROM Ders");
            
            stmt = connection.prepareStatement("Select * from Ders");
       
            rs = stmt.executeQuery();
 
            while (rs.next()) {
                
                d = new Ders();
                
                d.setId(rs.getInt("SaatID"));
                d.setSaat(rs.getString("Saat"));
                d.setPazartesi(rs.getString("Pazartesi"));
                d.setSali(rs.getString("Sali"));
                d.setCarsamba(rs.getString("Carsamba"));
                d.setPersembe(rs.getString("Persembe"));
                d.setCuma(rs.getString("Cuma"));

                list.add(d);
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
    
    //Calışıyor.
/*
    
public static void main(String[] args) {
    DersDAO dao = new DersDAO();
    Ders d = new Ders();
    
    d.setSaat("10.00");
    d.setPazartesi("oyun");
    d.setSali("oyun");
    d.setCarsamba("oyun");
    d.setPersembe("oyun");
    d.setCuma("oyun");
    
    dao.insertItem(d);
    
}
    public static void main (String[] args ) {
        
        SiparisDAO dao = new SiparisDAO();

    
        ArrayList<Siparis> list = dao.getItems();

    for (Siparis s : list) {
        System.out.println(s.getSiparis_id());   
        System.out.println(s.getUrun_id());
        System.out.println(s.getAdet());
        System.out.println(s.getMusteri_id());
 }
}*/
    
    public static void main(String[] args) {
        DersDAO dao = new DersDAO();
        
        ArrayList<Ders> list = dao.getItems();
        for(Ders d: list){
            System.out.println(d.getId());
            System.out.println(d.getSaat());
            System.out.println(d.getPazartesi());
            System.out.println(d.getSali());
            System.out.println(d.getCarsamba());
            System.out.println(d.getPersembe());
            System.out.println(d.getCuma());
        }
        
        
        
    }
   
    
}





