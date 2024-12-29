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
public class insertUser {
    
        String que = "INSERT INTO users (AccessLevel, username, password, email, ip, emailID) VALUES (?, ?, ?, ?, ?,?)";
    
    
        Connection getConnection() throws SQLException {
    
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/phqforum", "root", "root");
    
    
}
        
        public  synchronized void insertIt(String AccessLevel, String username, String PW, String email, String
                ip,  int emailID) throws SQLException {
            
            try (Connection conn = getConnection()) {
                
                
                try (PreparedStatement PS2 = conn.prepareStatement(que)) {
                    
                    
                    PS2.setString(1,AccessLevel );
                    PS2.setString(2, username);
                    PS2.setString(3, PW);
                    PS2.setString(4, email);
                    PS2.setString(5,ip);
                    PS2.setInt(6,emailID);
              
                   
                PS2.execute();
                    
                    
                }
                
            }
            
            
            
        }
    
}
