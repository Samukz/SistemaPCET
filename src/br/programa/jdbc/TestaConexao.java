/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.programa.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author samuc
 */
public class TestaConexao {
    
    public static void main(String[] args) {
        
        try {
            
            new ConnectionFactory().getConnection();
            
            JOptionPane.showMessageDialog(null, "Conectado com sucersso!");
            
        } catch (Exception erro) {
            
                 JOptionPane.showMessageDialog(null, "Ocorreu um problema" +erro);
        }
        
    }
    
}
