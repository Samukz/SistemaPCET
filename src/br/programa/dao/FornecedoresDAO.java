/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.programa.dao;

import br.programa.jdbc.ConnectionFactory;
import br.programa.model.Fornecedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author samuc
 */
public class FornecedoresDAO {
    
    
       //CRIAR O ACESSO AO SQL
    private Connection con;
    
    public FornecedoresDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    }
    
    
    public void cadastroFornecedores(Fornecedores obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "insert into tb_fornecedores(razao,cnpj)values(?,?)";
            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getRazao());
            stmt.setString(2, obj.getCnpj());
            

            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
        
    }
    
    ///EXCLUIR FORNECEDOR
    
    public void excluirFornecedores(Fornecedores obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "delete from tb_fornecedores where id =?";

            
            // CONECTAR VIA COMANDO            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluído");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
        
    }
    
    
    ///METODO ALTERAR FORNECEDOR
    
     public void editarFuncioanrio(Fornecedores obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "update tb_fornecedores set razao=?,cnpj=? where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getRazao());
            stmt.setString(2, obj.getCnpj());
            stmt.setInt(3,obj.getId());
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
        
    }
     
     
     ///METODO LISTAR FORNECEDOR
     
      public List<Fornecedores> listarFornecedores(){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<Fornecedores> lista = new ArrayList<>();                         
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_fornecedores";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     Fornecedores obj = new Fornecedores();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setRazao(rs.getString("razao"));
                     obj.setCnpj(rs.getString("cnpj"));

                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 return null;
                 
             }
             
         }
      ///LISTAR FORNECEDORES POOR RAZAO
      
       public List<Fornecedores> buscaFornecedoresPorNome(String razao){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<Fornecedores> lista = new ArrayList<>();                         
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_fornecedores where razao like?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, razao);
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     Fornecedores obj = new Fornecedores();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setRazao(rs.getString("razao"));
                     obj.setCnpj(rs.getString("cnpj"));
                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 return null;
                 
             }
             
         }
       
       
       
         public Fornecedores consultaFornecedoresPorNome(String razao){
             
             try {
                 
                 String sql = "select * from tb_fornecedores where razao =?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, razao);
                 ResultSet rs = stmt.executeQuery();
                 
                 Fornecedores obj = new Fornecedores();
                 
                 if(rs.next()){
                                          
                     obj.setId(rs.getInt("id"));
                     obj.setRazao(rs.getString("razao"));
                     obj.setCnpj(rs.getString("cnpj"));

                     
                 }
                 
                 return obj;
                 
                         
             } catch (SQLException erro) {
                 
                 JOptionPane.showMessageDialog(null, "cliente não encontrado");
                 return null;
                 
                 
             }
             
             
         }
                 
    
}
