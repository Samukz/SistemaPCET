/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.programa.dao;

import br.programa.jdbc.ConnectionFactory;
import br.programa.model.DadosPedidos;
import br.programa.model.Fornecedores;
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
public class DadosPedidosDAO {
    
    
    
        private Connection con;
    
    public DadosPedidosDAO(){
        this.con = new ConnectionFactory().getConnection();             
               
        
    }
    
//     public void cadastroDados(DadosPedidos obj){
//        
//        try {
//            
//            //CRIAR COMANDO SQL
//            String sql = "insert into tb_lista_pedidos (numero_of,numero_processo,data_envio_of)values(?,?,?)";
//            
//            // CONECTAR VIA COMANDO
//            
//            PreparedStatement stmt = con.prepareStatement(sql);
//
//            stmt.setString(1, obj.getNumeroOF());
//            stmt.setString(2, obj.getNumeroProces());
//            stmt.setString(3, obj.getData_Envio_OF());
//            
//            
//            // EXECUTAR COMANDOI SQL
//            stmt.execute();
//            stmt.close();
//            
//            JOptionPane.showMessageDialog(null, "dados do pedido cadastrado");
//        } catch (SQLException erro) {
//            
//            JOptionPane.showMessageDialog(null, "erro"+erro);
//            
//        }
//        
//    }
     
     public List<DadosPedidos> buscaPedidoPorNumero(String nome,String status){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosPedidos> lista = new ArrayList<>();                   
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_lista_pedidos where pedido_id like? and status =?";
//                 select *from tb_funcionarios where email =? and senha =?
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 stmt.setString(2, status);
                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosPedidos obj = new DadosPedidos();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setCc(rs.getString("centro_de_custo"));
                     obj.setPedidoId(rs.getString("pedido_id"));
                     obj.setCod(rs.getString("Cod"));
                     obj.setItem(rs.getString("item"));
                     obj.setUnMedida(rs.getString("un_medida"));
                     obj.setQtd(rs.getString("qtd"));
                     obj.setStatus(rs.getString("status"));
                     obj.setDataPedido(rs.getString("data_pedido"));
                     obj.setTipo(rs.getString("Tipo_produto"));

                     
                     
                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 JOptionPane.showMessageDialog(null, "erro"+erro);
                 return null;
                 
             }
             
         }
     
      public List<DadosPedidos> buscaPedidoPorNumeroOF(String nome,String status){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosPedidos> lista = new ArrayList<>();                   
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_lista_pedidos where numero_of like? and status =?";
//                 "select * from tb_lista_pedidos where pedido_id like? and status =?"
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 stmt.setString(2, status);
                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosPedidos obj = new DadosPedidos();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setPedidoId(rs.getString("pedido_id"));
                     obj.setNumeroOF(rs.getString("numero_of"));
                     obj.setCod(rs.getString("cod"));                     
                     obj.setItem(rs.getString("item"));
                     obj.setCod(rs.getString("cod"));                     
                     obj.setPrevisão(rs.getString("prev_ent")); 
                     obj.setStatus(rs.getString("status")); 
                     obj.setP_unit(rs.getString("p_unit")); 
                     obj.setUnMedida(rs.getString("un_medida"));
                     obj.setFornecedor(rs.getString("fornecedor"));
                     obj.setCnpjFornecedor(rs.getString("cnpj"));
                     obj.setCc(rs.getString("centro_de_custo"));
                     obj.setTipo(rs.getString("tipo_produto"));
                     obj.setDataPedido(rs.getString("data_pedido"));
                     
//                     obj.setQtd(rs.getString("qtd"));
                     
                     
                    
                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 JOptionPane.showMessageDialog(null, "erro"+erro);
                 return null;
                 
             }
             
         }

     
 
     

     public boolean excluiritens(int id){
         
         try {
          //CRIAR COMANDO SQL
            String sql = "delete from tb_lista_pedidos where id =?";

            // CONECTAR VIA COMANDO            
            PreparedStatement stmt = con.prepareStatement(sql);       

            stmt.setInt(1, id);
            
            // EXECUTAR COMANDOI SQL
            int i = stmt.executeUpdate();
            //stmt.close()
            
           // JOptionPane.showMessageDialog(null, "Excluído"); 
            JOptionPane.showMessageDialog(null, id);
           return i!=0; 
           
           
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            return false;
                    
        }
        
    }
    
      public void editar(DadosPedidos obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "update tb_lista_pedidos set numero_processo=?,numero_of=?, data_envio_of=?, fornecedor=?, idfornecedor=?, cnpj=?, status=?, p_unit=?, comprador=? where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);            
            stmt.setString(1, obj.getNumeroProces());            
            stmt.setString(2, obj.getNumeroOF());
            stmt.setString(3, obj.getData_Envio_OF());
            stmt.setString(4, obj.getFornecedor());
            stmt.setString(5, obj.getIdForn());
            stmt.setString(6, obj.getCnpjFornecedor());
            stmt.setString(7, obj.getTipo());
            stmt.setString(7, obj.getStatus());
            stmt.setString(8, obj.getP_unit());
 String p_unitStr = obj.getP_unit().replace(',', '.');
    double p_unit = Double.parseDouble(p_unitStr);
    stmt.setDouble(8, p_unit);
// Obtém o valor de obj.getP_unit() como um double
//            double p_unit = obj.getP_unit();
//
//            // Converte o valor double para uma String formatada corretamente em formato de número
//            String p_unitStr = String.format("%.2f", p_unit);
//
//            // Configura o valor formatado como uma String na instrução SQL usando stmt.setString()
//            stmt.setString(8, p_unitStr);

            stmt.setString(9, obj.getComprador());
            
            
            stmt.setInt(10,obj.getId());
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();            
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erroouuuuu"+erro);
            
        }
        
//        JOptionPane.showMessageDialog(null, "cadastrado");
    }
      
      public DadosPedidos consultarDadosPedido(String codigo){
             
             try {
                 
                 String sql = "select * from tb_lista_pedidos where numero_of =?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, codigo);
                 ResultSet rs = stmt.executeQuery();
                 
                 DadosPedidos obj = new DadosPedidos();
                 
                 if(rs.next()){
                                           
                        obj.setFornecedor(rs.getString("fornecedor"));
                        obj.setCc(rs.getString("centro_de_custo"));
                        obj.setTipo(rs.getString("tipo_produto"));
                        obj.setCnpjFornecedor(rs.getString("cnpj"));
                        obj.setTipo(rs.getString("Tipo_produto"));
                        obj.setCc(rs.getString("centro_de_custo"));
                        

                     
                 }
                 
                 return obj;
                 
                         
             } catch (SQLException erro) {
                 
                 JOptionPane.showMessageDialog(null, "cliente não encontrado");
                 return null;
                 
                 
             }
      }
      
            public void editarPrevisao(DadosPedidos objp){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "UPDATE tb_lista_pedidos set prev_ent=?, status=?, ultimaentrada=?, numero_processo=? where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);            
            stmt.setString(1, objp.getPrevisão());          
            stmt.setString(2, objp.getStatus());          
            stmt.setString(3, objp.getUltimaentrada());          
            stmt.setString(4, objp.getNumeroProces());          

            stmt.setInt(5,objp.getId());
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
//            JOptionPane.showMessageDialog(null, "cadastrado");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erroouuuuu"+erro);
            
        }
        
    }
            
            public List<DadosPedidos> buscaPedidosParaPrevisao(String projeto,String status,String status2){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosPedidos> lista = new ArrayList<>();                   
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_lista_pedidos where centro_de_custo like? and (status=? or status=?)";
//                 String sql = "select * from tb_lista_pedidos where centro_de_custo like? and status =? or status=?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, projeto);
                 stmt.setString(2, status);
                 stmt.setString(3, status2);
                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosPedidos obj = new DadosPedidos();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setCod(rs.getString("cod"));
                     obj.setItem(rs.getString("item"));
                     obj.setPrevisão(rs.getString("prev_ent"));                     
                     obj.setStatus(rs.getString("status"));

                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 JOptionPane.showMessageDialog(null, "erro"+erro);
                 return null;
                 
             }
             
         }
            
            public List<DadosPedidos> buscaPedidoPorNumeroOF1(String nome){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosPedidos> lista = new ArrayList<>();                   
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_notasfiscais where num_of like?";
//                 "select * from tb_lista_pedidos where pedido_id like? and status =?"
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosPedidos obj = new DadosPedidos();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setItem(rs.getString("item"));

                     
//                     obj.setQtd(rs.getString("qtd"));
                     
                     
                    
                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 JOptionPane.showMessageDialog(null, "erro"+erro);
                 return null;
                 
             }
             
         }

      public boolean verificarNomeDuplicado(String nome){
             
             boolean nomeDuplicado = false;
             
             try {
                 
                 String sql = "select * from tb_lista_pedidos where numero_of =?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 ResultSet rs = stmt.executeQuery();
                 
//                 Funcionarios obj = new Funcionarios();
                 
                 if(rs.next()){
                                          
                                     nomeDuplicado = true;
                     
                 }
                 
                 rs.close();
                 stmt.close();
                 con.close();
                 
                         
             } catch (SQLException erro) {
                 
                 JOptionPane.showMessageDialog(null, erro);

                 
                 
             }
             
             return nomeDuplicado;
             
         }
      
       public List<DadosPedidos> listerItens(String nome){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosPedidos> lista = new ArrayList<>();                   
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_lista_pedidos where numero_of like?";
//                 "select * from tb_lista_pedidos where pedido_id like? and status =?"
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);

                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosPedidos obj = new DadosPedidos();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setPedidoId(rs.getString("pedido_id"));
                     obj.setNumeroOF(rs.getString("numero_of"));
                     obj.setCod(rs.getString("cod"));                     
                     obj.setItem(rs.getString("item"));
                     obj.setCod(rs.getString("cod"));                     
                     obj.setPrevisão(rs.getString("prev_ent")); 
                     obj.setStatus(rs.getString("status")); 
                     obj.setP_unit(rs.getString("p_unit")); 
                     obj.setUnMedida(rs.getString("un_medida"));
                     obj.setFornecedor(rs.getString("fornecedor"));
                     obj.setCnpjFornecedor(rs.getString("cnpj"));
                     obj.setCc(rs.getString("centro_de_custo"));
                     obj.setTipo(rs.getString("tipo_produto"));
                     obj.setQtd(rs.getString("qtd"));
                     obj.setUltimaentrada(rs.getString("ultimaentrada"));
                     
//                     obj.setQtd(rs.getString("qtd"));
                     
                     
                    
                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 JOptionPane.showMessageDialog(null, "erro"+erro);
                 return null;
                 
             }
             
         }
       
        public List<DadosPedidos> buscaPedidoPorNumeroOF2(String nome,String status,String status2){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosPedidos> lista = new ArrayList<>();                   
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_lista_pedidos where numero_of =? AND (status =? OR status =?)";
//                 "select * from tb_lista_pedidos where pedido_id like? and status =?"
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 stmt.setString(2, status);
                 stmt.setString(3, status2);
                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosPedidos obj = new DadosPedidos();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setPedidoId(rs.getString("pedido_id"));
                     obj.setNumeroOF(rs.getString("numero_of"));
                     obj.setCod(rs.getString("cod"));                     
                     obj.setItem(rs.getString("item"));
                     obj.setCod(rs.getString("cod"));                     
                     obj.setPrevisão(rs.getString("prev_ent")); 
                     obj.setStatus(rs.getString("status")); 
                     obj.setP_unit(rs.getString("p_unit")); 
                     obj.setUnMedida(rs.getString("un_medida"));
                     obj.setFornecedor(rs.getString("fornecedor"));
                     obj.setCnpjFornecedor(rs.getString("cnpj"));
                     obj.setCc(rs.getString("centro_de_custo"));
                     obj.setTipo(rs.getString("tipo_produto"));
                     obj.setDataPedido(rs.getString("data_pedido"));
                     obj.setIdForn(rs.getString("idfornecedor"));
                     obj.setNumeroProces(rs.getString("numero_processo"));
                     
//                     obj.setQtd(rs.getString("qtd"));
                     
                     
                    
                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 JOptionPane.showMessageDialog(null, "erro"+erro);
                 return null;
                 
             }
             
         }

            public DadosPedidos consultarDadosPedido2(String codigo){
             
             try {
                 
                 String sql = "select * from tb_lista_pedidos where pedido_id =?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, codigo);
                 ResultSet rs = stmt.executeQuery();
                 
                 DadosPedidos obj = new DadosPedidos();
                 
                 if(rs.next()){
                                           
                        obj.setFornecedor(rs.getString("fornecedor"));
                        obj.setCc(rs.getString("centro_de_custo"));
                        obj.setTipo(rs.getString("tipo_produto"));
                        obj.setCnpjFornecedor(rs.getString("cnpj"));
                        obj.setTipo(rs.getString("Tipo_produto"));
                        obj.setCc(rs.getString("centro_de_custo"));
                        obj.setDataPedido(rs.getString("data_pedido"));
                        

                     
                 }
                 
                 return obj;
                 
                         
             } catch (SQLException erro) {
                 
                 JOptionPane.showMessageDialog(null, "cliente não encontrado");
                 return null;
                 
                 
             }
      }
            
            public void excluirPedidos(DadosPedidos obj){
                
                try{
                    
              //CRIAR COMANDO SQL
            String sql = "delete from tb_lista_pedidos where id =?";

            
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
            
              public void excluirPedidos2(DadosPedidos obj){
                
                try{
                    
              //CRIAR COMANDO SQL
            String sql = "delete from tb_pedidos_sica where id =?";

            
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
              
              public void EditarPedidos(DadosPedidos obj){
                
              try {
                String sql = "UPDATE tb_lista_pedidos SET qtd=?,prev_ent=?,centro_de_custo=? WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, obj.getQtd());
                stmt.setString(2, obj.getQtd());
                stmt.setString(3, obj.getCc());
                stmt.setInt(4, obj.getId());
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar registro: " + erro.getMessage());
            }

                
            }

              public void editarPedidos2(DadosPedidos obj){
                
                try{
                    
              //CRIAR COMANDO SQL
            String sql = "UPDATE tb_pedidos_sica set centro_custo=? where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getCc());

            stmt.setInt(2, obj.getId());
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
                
            }
               public List<DadosPedidos> buscaPedidoPorNumero3(String nome,String status){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosPedidos> lista = new ArrayList<>();                   
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_nf_historico where projeto=? and status =?";

                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 stmt.setString(2, status);
                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosPedidos obj = new DadosPedidos();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setN_nf(rs.getString("n_nf"));
                     obj.setNumeroOF(rs.getString("n_of"));
                     obj.setStatus(rs.getString("status"));
                     obj.setProjeto(rs.getString("projeto"));
                     obj.setFornecedor(rs.getString("fornecedor"));
                     obj.setIdForn(rs.getString("id_fornecedor"));
                     obj.setCnpjFornecedor(rs.getString("cnpj_fornecedor"));




                     
                     
                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 JOptionPane.showMessageDialog(null, "erro"+erro);
                 return null;
                 
             }
             
         }
              
              
              public List<DadosPedidos> buscaPedidoPorNumero2(String nome,String status){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosPedidos> lista = new ArrayList<>();                   
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_lista_pedidos_total where pedido_id =? and status =?";
//                 select *from tb_funcionarios where email =? and senha =?
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 stmt.setString(2, status);
                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosPedidos obj = new DadosPedidos();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setCc(rs.getString("centro_de_custo"));
                     obj.setPedidoId(rs.getString("pedido_id"));
                     obj.setCod(rs.getString("cod"));
                     obj.setItem(rs.getString("item"));
                     obj.setUnMedida(rs.getString("un_medida"));
                     obj.setQtd(rs.getString("qtd"));
                     obj.setStatus(rs.getString("status"));
                     obj.setDataPedido(rs.getString("data_pedido"));
                     obj.setTipo(rs.getString("tipo_pedido"));

                     
                     
                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 JOptionPane.showMessageDialog(null, "erro"+erro);
                 return null;
                 
             }
             
         }
              
              public void cadastrarOF(DadosPedidos obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "INSERT INTO tb_lista_pedidos (pedido_id,cod,item,qtd,status,numero_of,data_envio_of,Tipo_produto,fornecedor,idfornecedor,cnpj,centro_de_custo,un_medida,data_pedido,obs,p_unit,prev_ent,comprador,numero_processo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);            
            stmt.setString(1, obj.getPedidoId());            
            stmt.setString(2, obj.getCod());            
            stmt.setString(3, obj.getItem());            
            stmt.setString(4, obj.getQtd());            
            stmt.setString(5, obj.getStatus());            
            stmt.setString(6, obj.getNumeroOF());            
            stmt.setString(7, obj.getData_Envio_OF());            
            stmt.setString(8, obj.getTipo());            
            stmt.setString(9, obj.getFornecedor());             
            stmt.setString(10, obj.getIdForn());            
            stmt.setString(11, obj.getCnpjFornecedor());            
            stmt.setString(12, obj.getCc());            
            stmt.setString(13, obj.getUnMedida());                                   
            stmt.setString(14, obj.getDataPedido());            
            stmt.setString(15, obj.getObs());            

            String p_unitStr = obj.getP_unit().replace(',', '.');
               double p_unit = Double.parseDouble(p_unitStr);
               stmt.setDouble(16, p_unit);


            stmt.setString(17, obj.getPrevisão());
            
            stmt.setString(18, obj.getComprador());
            stmt.setString(19, obj.getNumeroProces());

            
            
//            stmt.setInt(10,obj.getId());
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();            
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erroouuuuu"+erro);
            
        }
        
//        JOptionPane.showMessageDialog(null, "cadastrado");
    }
              
               public void editar2(DadosPedidos obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "update tb_lista_pedidos set numero_processo=?,numero_of=?, data_envio_of=?, fornecedor=?, idfornecedor=?, cnpj=?, status=?, p_unit=?, comprador=? where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);            
            stmt.setString(1, obj.getNumeroProces());            
            stmt.setString(2, obj.getNumeroOF());
            stmt.setString(3, obj.getData_Envio_OF());
            stmt.setString(4, obj.getFornecedor());
            stmt.setString(5, obj.getIdForn());
            stmt.setString(6, obj.getCnpjFornecedor());
            stmt.setString(7, obj.getTipo());
            stmt.setString(7, obj.getStatus());
            stmt.setString(8, obj.getP_unit());
 String p_unitStr = obj.getP_unit().replace(',', '.');
    double p_unit = Double.parseDouble(p_unitStr);
    stmt.setDouble(8, p_unit);
// Obtém o valor de obj.getP_unit() como um double
//            double p_unit = obj.getP_unit();
//
//            // Converte o valor double para uma String formatada corretamente em formato de número
//            String p_unitStr = String.format("%.2f", p_unit);
//
//            // Configura o valor formatado como uma String na instrução SQL usando stmt.setString()
//            stmt.setString(8, p_unitStr);

            stmt.setString(9, obj.getComprador());
            
            
            stmt.setInt(10,obj.getId());
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();            
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erroouuuuu"+erro);
            
        }
        
//        JOptionPane.showMessageDialog(null, "cadastrado");
    }
               
               public void excluirEntradasNF(DadosPedidos obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "delete from tb_notasfiscais where id =?";

            
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
               
               public void editar3(DadosPedidos obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "update tb_nf_historico set n_of=?, status=? where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);            
            stmt.setString(1, obj.getNumeroOF());            
            stmt.setString(2, obj.getStatus());
            

            
            
            stmt.setInt(3,obj.getId());
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();            
            
                        JOptionPane.showMessageDialog(null, "atualizou?");

            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erroouuuuu"+erro);
            
        }
        
//        JOptionPane.showMessageDialog(null, "cadastrado");
    }
               
               public void editar4(DadosPedidos obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "update tb_lista_pedidos set prev_ent=?, status=? where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);            
            stmt.setString(1, obj.getPrevisão());            
            stmt.setString(2, obj.getStatus());
            

            
            
            stmt.setInt(3,obj.getId());
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();            
            
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erroouuuuu"+erro);
            
        }
        
//        JOptionPane.showMessageDialog(null, "cadastrado");
    }
               
               public DadosPedidos consultarRetornoNF(String of){
             
             try {
                 
                 String sql = "select * from tb_nf_historico where n_of =? and TxtNNf";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, of);
                 ResultSet rs = stmt.executeQuery();
                 
                 DadosPedidos obj = new DadosPedidos();
                 
                 if(rs.next()){
                                           
                        obj.setFornecedor("RETORNADO");
//                        obj.setFornecedor(rs.getString("cod_jde"));
                        

                     
                 }
                 
                 return obj;
                 
                         
             } catch (SQLException erro) {
                 
                 JOptionPane.showMessageDialog(null, "cliente não encontrado");
                 return null;
                 
                 
             }
      }
               
               public void editar5(DadosPedidos obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "update tb_lista_pedidos_total set previsao=?,status=? where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);            
            stmt.setString(1, obj.getTotal());            
            stmt.setString(2, obj.getStatus());


            stmt.setInt(3,obj.getId());
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();            
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erroouuuuu"+erro);
            
        }
        
//        JOptionPane.showMessageDialog(null, "cadastrado");
    }
            
}

    
    
  
