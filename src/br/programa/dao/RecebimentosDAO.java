/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.programa.dao;

import br.programa.jdbc.ConnectionFactory;
import br.programa.model.DadosPedidos;
import br.programa.model.DadosRecebimento;
import br.programa.model.InPedidos;
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
public class RecebimentosDAO {
    
        private Connection con;
        
             public RecebimentosDAO(){
        this.con = new ConnectionFactory().getConnection();
             }
        
     public void cadastrarNfs(DadosRecebimento obj){       
      
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "insert into tb_notasfiscais(cod,item,p_qtd,p_numnf,num_of,status,p_dtemi,p_vltotal,p_projeto,p_fornecedor,p_vlunit,un_medida)values(?,?,?,?,?,?,?,?,?,?,?,?)";
            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getCod());
            stmt.setString(2, obj.getItem());
            stmt.setString(3, obj.getQtd());
            stmt.setString(4, obj.getNumnf());
            stmt.setString(5, obj.getNumeroOF());            
            stmt.setString(6, obj.getStatus());
            stmt.setString(7, obj.getPrim_ent_dtemissao());
            stmt.setString(8, obj.getPrim_ent_vltotal1());
            stmt.setString(9, obj.getProjeto());
            stmt.setString(10, obj.getFornecedor());
            stmt.setString(11, obj.getPrim_ent_vlunit1());
            stmt.setString(12, obj.getUnidade_medida());
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
        } 

        catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
        
    }
     public List<DadosRecebimento> buscaNfPorNumero(String nome){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosRecebimento> lista = new ArrayList<>();                         
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_notasfiscais where num_of like?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosRecebimento obj = new DadosRecebimento();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setCod(rs.getString("num_of"));
                     obj.setNumeroOF(rs.getString("item"));
                     obj.setStatus(rs.getString("p_qtd"));
                     

                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 return null;
                 
             }
             
         }
     
      public List<DadosPedidos> buscarItensNf(String nf,String of){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosPedidos> lista = new ArrayList<>();                   
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_notasfiscais where p_numnf=? and num_of=?";
//                 "select * from tb_lista_pedidos where pedido_id like? and status =?"
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nf);
                 stmt.setString(2, of);
                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosPedidos obj = new DadosPedidos();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setCod(rs.getString("cod"));
                     obj.setItem(rs.getString("item"));
                     obj.setQtd(rs.getString("p_qtd"));


                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 JOptionPane.showMessageDialog(null, "erro"+erro);
                 return null;
                 
             }
             
         }
      
      public List<DadosRecebimento> buscaNfPorNumero2(String nome,String Nof){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosRecebimento> lista = new ArrayList<>();                         
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_notasfiscais where p_numnf=? AND num_of=?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 stmt.setString(2, Nof);
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosRecebimento obj = new DadosRecebimento();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setCod(rs.getString("cod"));
                     obj.setItem(rs.getString("item"));
                     obj.setQtd(rs.getString("p_qtd"));
                     obj.setPrim_ent_vlunit1(rs.getString("p_vlunit"));
                     

                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 return null;
                 
             }
             
         }
      
      public void excluirnotas(DadosPedidos obj){
          try {
              
          //CRIAR COMANDO SQL
          
            String sql = "DELETE FROM tb_notasfiscais where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            

        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
          
      }
      
       public void excluirnotas2(DadosPedidos obj){
          try {
              
          //CRIAR COMANDO SQL
          
            String sql = "DELETE FROM tb_nf_historico where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            

        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
          
      }
     public List<DadosRecebimento> buscaPedidoPorNumero1(String nf,String of){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosRecebimento> lista = new ArrayList<>();                   
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_nf_historico where n_nf like? or n_of like?";

                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nf);
                 stmt.setString(2, of);
                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosRecebimento obj = new DadosRecebimento();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setNumnf(rs.getString("n_nf"));
                     obj.setNumeroOF(rs.getString("n_of"));
                     obj.setStatus(rs.getString("status"));
                     obj.setProjeto(rs.getString("projeto"));
                     obj.setValor_total(rs.getString("valor_total"));
                     obj.setData_rec(rs.getString("data_rec"));
                     obj.setData_emissao(rs.getString("data_emissao"));
                     obj.setData_emv(rs.getString("data_env"));
                     obj.setData_entrega(rs.getString("data_entrega"));
                     obj.setData_return(rs.getString("data_return"));
                     obj.setData_sica(rs.getString("data_sica"));
                     obj.setFornecedor(rs.getString("fornecedor"));
                     obj.setCnpj(rs.getString("cnpj_fornecedor"));
                     obj.setObs1(rs.getString("obs1"));
                     obj.setObs2(rs.getString("obs2"));
                     obj.setStatus1(rs.getString("status1"));
                     obj.setMotivo(rs.getString("motivo"));
                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 JOptionPane.showMessageDialog(null, "erro"+erro);
                 return null;
                 
             }
             
         }
     
      public List<DadosRecebimento> buscaNfPorNumero3(String nome,String Nof){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosRecebimento> lista = new ArrayList<>();                         
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_notasfiscais where p_numnf=? AND num_of=?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 stmt.setString(2, Nof);
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosRecebimento obj = new DadosRecebimento();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setCod(rs.getString("cod"));
                     obj.setItem(rs.getString("item"));
                     obj.setQtd(rs.getString("p_qtd"));
                     obj.setPrim_ent_vlunit1(rs.getString("p_vlunit"));
                     obj.setObs1(rs.getString("un_medida"));
                     

                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 return null;
                 
             }
             
         }
      
      
//      public List<DadosRecebimento> buscaNfPorNumero3(String nome,String Nof){
//             
//             try {
//                 
//                 //CRIANDO A LISTA
//                 
//                 List<DadosRecebimento> lista = new ArrayList<>();                         
//                 
//                 //2 CRIANDO COMANDO SQL
//                 
//                 String sql = "select * from tb_notasfiscais where p_numnf=? AND num_of=?";
//                 PreparedStatement stmt = con.prepareStatement(sql);
//                 stmt.setString(1, nome);
//                 stmt.setString(2, Nof);
//                 ResultSet rs = stmt.executeQuery();
//                 
//                 while(rs.next()){
//                     DadosRecebimento obj = new DadosRecebimento();
//                     
//                     obj.setId(rs.getInt("id"));
//                     obj.setCod(rs.getString("cod"));
//                     obj.setItem(rs.getString("item"));
//                     obj.setQtd(rs.getString("p_qtd"));
//                     obj.setPrim_ent_vlunit1(rs.getString("p_vlunit"));
//                     
//
//                     
//                     lista.add(obj);
//                     
//                 }
//                 
//                 return lista;
//                 
//                 
//                 
//             } catch (SQLException erro) {
//                 return null;
//                 
//             }
//             
//         }
      
       public List<DadosRecebimento> buscaNfPorNumero4(String NumOf,String STATUS){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosRecebimento> lista = new ArrayList<>();                         
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_lista_pedidos where numero_of=? AND numero_processo=?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, NumOf);
                 stmt.setString(2, STATUS);
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosRecebimento obj = new DadosRecebimento();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setCod(rs.getString("cod"));
                     obj.setItem(rs.getString("item"));
                     obj.setUnidade_medida(rs.getString("un_medida"));
                     
                     obj.setPrim_ent_vlunit1(rs.getString("p_unit"));
                     obj.setPrev(rs.getString("prev_ent"));
                     obj.setUltimaentrada(rs.getString("ultimaentrada"));

                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 return null;
                 
             }
             
         }
       
public List<DadosRecebimento> ChecarOFrepetida(String NF, String OF) {
    try {
        List<DadosRecebimento> lista = new ArrayList<>();
        String sql = "select * from tb_nf_historico where n_nf like ? or n_of like ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, NF);
        stmt.setString(2, OF);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            DadosRecebimento obj = new DadosRecebimento();            
            obj.setId(rs.getInt("id"));
            lista.add(obj);
        }

        if (lista.isEmpty()) {
            DadosRecebimento obj = new DadosRecebimento();
            obj.setId(rs.getInt("id"));
            lista.add(obj);
        }

        rs.close();
        stmt.close();
        return lista;
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        return null;
    }
}

}
