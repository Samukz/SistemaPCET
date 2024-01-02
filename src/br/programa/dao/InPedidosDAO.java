/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.programa.dao;

import br.programa.jdbc.ConnectionFactory;
import br.programa.model.InPedidos;
import br.projeto.view.FrmDadosPedidoNovo;
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
public class InPedidosDAO {
    
     //CRIAR O ACESSO AO SQL
    private Connection con;
    
    public InPedidosDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    }
    
    ///CRIAR PEDIDO
    
    public void cadastrarPedido(InPedidos obj){
        try {           
            
            String sql = "insert into tb_pedidos_sica (num_pedido_sica,data_pedido,centro_custo,status_pedido,obs,funcionario,urgente) values(?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNum_pedido_sica());
            stmt.setString(2,obj.getData_pedido());
            stmt.setString(3,obj.getCentro_custo());                       
            stmt.setString(4,obj.getStatus_pedido());
            stmt.setString(5,obj.getObs());
            stmt.setString(6,obj.getFuncionario()); 
            stmt.setString(7, obj.getUrgente()); 
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!");
            
        } catch (SQLException erro) {
            
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
        
        
        
    }
    
    public int retornaULtimoPedido(){
        
        try {
            int idpedido = 0;
            
            String sql ="select max(id) id from tb_pedidos_sica";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                InPedidos p = new InPedidos();                
                p.setId(rs.getInt("id"));
                idpedido = p.getId();                
            }
            return idpedido;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
    public InPedidos consultarPed(String pedido){
             
             try {
                 
                 String sql = "select * from tb_pedidos_sica where num_pedido_sica =?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, pedido);
                 ResultSet rs = stmt.executeQuery();
                 
                 InPedidos obj = new InPedidos();
                 
                 if(rs.next()){
                                          
                     //obj.setCod_jde(rs.getInt("codigo_jde"));
                     
                    obj.setNum_pedido_sica(rs.getString("num_pedido_sica"));                 
                    JOptionPane.showMessageDialog(null, "Pedido já existente no Sistema");
                    
                 }
                 
                 return obj;


             } catch (SQLException erro) {
                 
                 JOptionPane.showMessageDialog(null, erro);
                 return null;
                                  
             }
     
}
    public void alterarStatusPedido(InPedidos obj){
    
        try {
            
            String sql = "update tb_pedidos_sica set status_pedido=? where num_pedido_sica=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1,obj.getStatus_pedido());
            stmt.setString(2,obj.getNum_pedido_sica());
            
            stmt.execute();
            stmt.close();

            
            JOptionPane.showMessageDialog(null, "Dados do pedido cadastrado com sucesso!");
            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
        }
    }
    
     public List<InPedidos> buscaPedidoPorNumero(String nome,String status){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<InPedidos> lista = new ArrayList<>();                   
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_pedidos_sica where num_pedido_sica like? and status_pedido =?";

                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 stmt.setString(2, status);
                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     InPedidos obj = new InPedidos();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setNum_pedido_sica(rs.getString("num_pedido_sica"));
                     obj.setData_pedido(rs.getString("data_pedido"));
                     obj.setCentro_custo(rs.getString("centro_custo"));
                     obj.setFuncionario(rs.getString("funcionario"));
                     obj.setStatus_pedido(rs.getString("status_pedido"));                     
                     
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
                 
                 String sql = "select * from tb_pedidos_sica where num_pedido_sica =?";
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

     
     public List<InPedidos> buscaPedidoPorNumero2(String nome, String status) {
    try {
        // CRIANDO A LISTA
        List<InPedidos> lista = new ArrayList<>();

        // 1º BANCO DE DADOS - tb_pedidos_sica
        String sql1 = "SELECT * FROM tb_lista_pedidos_total WHERE pedido_id =? AND status = ?";
        PreparedStatement stmt1 = con.prepareStatement(sql1);
        stmt1.setString(1, nome);
        stmt1.setString(2, status);
        ResultSet rs1 = stmt1.executeQuery();

        while (rs1.next()) {
            InPedidos obj = new InPedidos();

            obj.setId(rs1.getInt("id"));
            obj.setNum_pedido_sica(rs1.getString("pedido_id"));
            obj.setData_pedido(rs1.getString("data_pedido"));
            obj.setCentro_custo(rs1.getString("centro_de_custo"));
//            obj.setFuncionario(rs1.getString("funcionario"));
            obj.setStatus_pedido(rs1.getString("status"));
            obj.setCod(rs1.getString("cod"));
            obj.setItem(rs1.getString("item"));
            obj.setQtd(rs1.getString("qtd"));
            obj.setPrevisao(rs1.getString("previsao"));

            lista.add(obj);
        }

        // 2º BANCO DE DADOS - tb_lista_pedidos_total
        String sql2 = "SELECT * FROM tb_lista_pedidos WHERE pedido_id = ?";
        PreparedStatement stmt2 = con.prepareStatement(sql2);
        stmt2.setString(1, nome);
        ResultSet rs2 = stmt2.executeQuery();

        while (rs2.next()) {
            InPedidos obj = new InPedidos();

            obj.setId(rs2.getInt("id"));
            obj.setNum_pedido_sica(rs2.getString("pedido_id"));
            obj.setData_pedido(rs2.getString("data_pedido"));
            obj.setCentro_custo(rs2.getString("centro_de_custo"));
//            obj.setFuncionario(rs2.getString("funcionario"));
            obj.setStatus_pedido(rs2.getString("status"));
            obj.setCod(rs2.getString("cod"));
            obj.setItem(rs2.getString("item"));
            obj.setQtd(rs2.getString("qtd"));
            obj.setPrevisao(rs2.getString("prev_ent"));
            obj.setNumeroOF(rs2.getString("numero_of"));
            obj.setFornecedor(rs2.getString("fornecedor"));
            

            lista.add(obj);
        }

        return lista;
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro: " + erro);
        return null;
    }
}
    
    
}