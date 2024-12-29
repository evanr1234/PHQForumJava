
package com.phq.phqforum;

/*
auther: Evan Redmond
*/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersistenceTest {
    
Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    
}

//how to make a fetch that inserts these strings into the db
//need fetch replies, fetch community topics, post reply, post topic, register form to db and login process

public Bans saveBans(Integer text, String i) {
    
    
    final String INSERT = "INSERT INTO bans(id, ip) VALUES (?, ?)";
    
    
    Bans bans = null;

try (Connection conn = getConnection()) {
    
    try (PreparedStatement PS = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
        
        
    PS.setInt(1, text);
    PS.setString(2,i);
    PS.execute();
    
    
    try (ResultSet keys = PS.getGeneratedKeys()) {
        
        if (!keys.next()) {
            
            
            throw new SQLException("no generated keys");
            
        }
        bans = new Bans(text);
    }
    
}    
    
    
}catch (SQLException e) {System.out.println(e.getMessage());}
  
return bans;

}
    



public void readBans() {
   
    
   
    
    String Stat = "SELECT id, ip FROM bans";
    
    List<Bans> list = new ArrayList<>();
    
    try (Connection con = getConnection()) {
        
        try (PreparedStatement pess = con.prepareStatement(Stat)) {
            
         try   (ResultSet rs =  pess.executeQuery()) {
             
             
                   while (rs.next()) {
          
          
          Bans readBans = new Bans();
          readBans.setId(rs.getInt(1));
          readBans.setIp(rs.getString(2));
          
          
          list.add(readBans);

          
             
         }
            

      }
            
         
        }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(PersistenceTest.class.getName()).log(Level.SEVERE, null, ex);
    }
    
  for  (Bans b: list) {
    System.out.println(b);
    
}
    
}
    
    
    
}
