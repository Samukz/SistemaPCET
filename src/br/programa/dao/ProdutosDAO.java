/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.programa.dao;

import br.programa.jdbc.ConnectionFactory;
import br.programa.model.Fornecedores;
import br.programa.model.Funcionarios;
import br.programa.model.Produtos;
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
public class ProdutosDAO {
    
     //CRIAR O ACESSO AO SQL
    private Connection con;
    
    public ProdutosDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    }
    
    ///METODO CADASTRAR PRODUTO
    
    public void cadastrarProduto(Produtos obj){
    
        try {
            
            String sql = "insert into tb_itens(cod_sigma,cod_jde,item,unidade_medida,sigla_unidade_medida,modalidade_abastecimento"
                    + ",grande_grupo,grupo,subgrupo)values(?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getCod_sigma());
            stmt.setString(2,obj.getCod_jde());
            stmt.setString(3,obj.getItem());
            stmt.setString(4,obj.getUnidade_medida());
            stmt.setString(5,obj.getSigla_unidade_medida());
            stmt.setString(6,obj.getModalidade_abastecimento());
            stmt.setString(7,obj.getGrande_grupo());
            stmt.setString(8,obj.getGrupo());
            stmt.setString(9,obj.getSubgrupo());
            
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
        }
    }
    
    
     public List<Produtos> listarProdutos(){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<Produtos> lista = new ArrayList<>();                         
                 
                 //2 CRIANDO COMANDO SQL                 
                 String sql = "select id,cod_sigma,cod_jde,item,unidade_medida,sigla_unidade_medida,modalidade_abastecimento,grande_grupo,grupo,subgrupo from tb_itens;";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     
                     Produtos obj = new Produtos();

                     
                     obj.setId(rs.getInt("id"));
                     obj.setCod_sigma(rs.getString("cod_sigma"));
                     obj.setCod_jde(rs.getString("cod_jde"));
                     obj.setItem(rs.getString("item"));
                     obj.setUnidade_medida(rs.getString("unidade_medida"));
                     obj.setSigla_unidade_medida(rs.getString("sigla_unidade_medida"));                     
                     obj.setModalidade_abastecimento(rs.getString("modalidade_abastecimento"));
                     obj.setGrande_grupo(rs.getString("grande_grupo"));
                     obj.setGrupo(rs.getString("grupo"));
                     obj.setSubgrupo(rs.getString("subgrupo"));

                     lista.add(obj);
                     
                     
                 }
                 
                 return lista;
                 
                
                 
             } catch (SQLException erro) {
                 return null;
                 
             }
             
         }
     
     public void aleterarProduto(Produtos obj){
    
        try {
            
            String sql = "update tb_itens set cod_sigma=?,cod_jde=?,item=?,unidade_medida=?,sigla_unidade_medida=?,modalidade_abastecimento=?"
                    + ",grande_grupo=?,grupo=?,subgrupo=? where id=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1,obj.getCod_sigma());
            stmt.setString(2,obj.getCod_jde());
            stmt.setString(3,obj.getItem());
            stmt.setString(4,obj.getUnidade_medida());
            stmt.setString(5,obj.getSigla_unidade_medida());
            stmt.setString(6,obj.getModalidade_abastecimento());
            stmt.setString(7,obj.getGrande_grupo());
            stmt.setString(8,obj.getGrupo());
            stmt.setString(9,obj.getSubgrupo());

            stmt.setInt(10,obj.getId());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
        }
    }
    
    
     public void excluirProdutos(Produtos obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "delete from tb_itens where id =?";

            
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
     
     public Produtos consultarProdutosPorCodigo(String codigo){
             
             try {
                 
                 String sql = "select * from tb_itens where cod_jde =?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, codigo);
                 ResultSet rs = stmt.executeQuery();
                 
                 Produtos obj = new Produtos();
                 
                 if(rs.next()){
                                          
                     //obj.setCod_jde(rs.getInt("codigo_jde"));
                     
                     obj.setCod_jde(rs.getString("cod_jde"));
                     obj.setItem(rs.getString("item"));
                     obj.setUnidade_medida(rs.getString("unidade_medida"));                     
                     obj.setGrande_grupo(rs.getString("grande_grupo"));                     

                     
                 }
                 
                 return obj;
                 
                         
             } catch (SQLException erro) {
                 
                 JOptionPane.showMessageDialog(null, "cliente não encontrado");
                 return null;
                 
                 
             }
             
             
         }
     
public List<Produtos> buscaProdutoPorNome(String nome){
             
             try {                 
                 //CRIANDO A LISTA                 
                 List<Produtos> lista = new ArrayList<>();                         
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_itens where Item like?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     Produtos obj = new Produtos();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setCod_sigma(rs.getString("cod_sigma"));
                     obj.setCod_jde(rs.getString("cod_jde"));
                     obj.setItem(rs.getString("Item"));
                     obj.setUnidade_medida(rs.getString("unidade_medida"));
                     obj.setSigla_unidade_medida(rs.getString("sigla_unidade_medida"));                     
                     obj.setModalidade_abastecimento(rs.getString("modalidade_abastecimento"));
                     obj.setGrande_grupo(rs.getString("grande_grupo"));
                     obj.setGrupo(rs.getString("grupo"));
                     
                     obj.setSubgrupo(rs.getString("subgrupo"));


                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 return null;
                 
             }
             
         }
     
}
