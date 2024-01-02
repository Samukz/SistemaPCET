/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.programa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author samuc
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        
       
        try {
//            return DriverManager.getConnection("jdbc:mysql://34.95.250.171/db-programanovo","usuario",";A*n_`ya/@uZr_9B");
            return DriverManager.getConnection("jdbc:mysql://database-2.clcsny69ew1x.sa-east-1.rds.amazonaws.com/db-programanovo","admin","UhHca4ppl9SrlmVfrx3m");
            
        } catch (Exception erro) {
            
            throw new RuntimeException(erro);                    
                    
        }
    }
    
}
    
   
