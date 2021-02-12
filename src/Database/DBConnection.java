/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Secret
 */
public class DBConnection {
    
    private static DBConnection _dbConnection = null;
    
     private Connection connection;
    
     
     private DBConnection(){}
     
     public static DBConnection createInstance(){
         
         if(_dbConnection == null)
             _dbConnection = new DBConnection();
         
         return _dbConnection;
     }
     
    public Connection getConnection(){
       
        
        String dbName="anaokuludb";
        String userName = "root";
        String password = "mysql";
        
        try{
          
         Class.forName("org.mariadb.jdbc.Driver");

         connection= DriverManager.getConnection("jdbc:mariadb://localhost:3306/"+dbName ,userName,password);
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        } 
        return connection;
    }
    
    
    public static void main(String[] args) throws SQLException {
        DBConnection con = new DBConnection();
        Connection sqlConnection =  con.getConnection();
        
        PreparedStatement stmt = sqlConnection.prepareStatement("SELECT * FROM ogrenci");
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            System.out.println(rs.getString("İsimSoyisim"));
        }
        rs.close();
        stmt.close();
        sqlConnection.close();
        
        
    }
    
    
}

/*
 private final String url = "jdbc:mysql://localhost/phpmyadmin/?db=anaokulu_db";
    
    // private final String url = "jdbc:mysql://localhost/?user=root&password=rootpassword";
    private final String user_name = "root";

    private final String password = "mysql";
    private static DBConnection _dbConnection = null;
    private Connection connection;

    public DBConnection() {
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user_name, password);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // catch (ClassNotFoundException e) {
          //  e.printStackTrace();
       // } 
    }

    public static DBConnection getInstance() {
        if (_dbConnection == null) {
            _dbConnection = new DBConnection();
        }

        return _dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
   

*/



 /*Connection con = null;

    public static Connection ConnectDb() {

        try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/anaokuludb");
           
        } catch (Exception e) {

        }
        return null;
    }*/