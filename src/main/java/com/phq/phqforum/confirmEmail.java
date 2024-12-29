/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phq.phqforum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author evanredmond
 */
public class confirmEmail {
    
    
    Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    
}
    
    void conf(int num) {
        
        String query ="UPDATE users SET emailConfirmed='1' WHERE emailID=?";
        
        try (Connection conn = getConnection()){
            
            
            
            try(PreparedStatement PS = conn.prepareStatement(query)) {
                
                PS.setInt(1, num);
                
                PS.execute();
                
   
            }
   
        }catch(SQLException e){
            System.out.println("SQL Exception! " + e);
            
        }
 
    }
    
}
