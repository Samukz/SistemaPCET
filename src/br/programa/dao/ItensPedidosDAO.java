/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.programa.dao;

import br.programa.jdbc.ConnectionFactory;
import br.programa.model.ItensPedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author samuc
 */
public class ItensPedidosDAO {
    
    private Connection con;
    
    public ItensPedidosDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    }

        
    public void cadastrarItem (ItensPedidos obj){
        
        try {
            
            String sql = "insert into tb_lista_pedidos(cod,item,qtd,pedido_id,centro_de_custo,prev_ent,status,un_medida,Tipo_produto,data_pedido) values(?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setString(1,obj.getPedido_id());
            stmt.setString(1,obj.getCod());
            stmt.setString(2,obj.getItem());
            stmt.setInt(3,obj.getQtd());
            stmt.setString(4,obj.getPedido_id());
            stmt.setString(5,obj.getFornecedor());
            stmt.setInt(6,obj.getQtd());
            stmt.setString(7,obj.getStatus());
            stmt.setString(8,obj.getUn());
            stmt.setString(9,obj.getTipo());
            stmt.setString(10,obj.getDatapedido());
            
            stmt.execute();
            stmt.close();
            
            //JOptionPane.showMessageDialog(null, "Itens no pedido cadastrado com sucesso!");
            
        } catch (Exception erro) {
            
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
        
        
    }
    
    
    public void cadastrarItem2 (ItensPedidos obj){
        
        try {
            
            String sql = "insert into tb_lista_pedidos_total(cod,item,qtd,pedido_id,centro_de_custo,previsao,status,un_medida,tipo_pedido,data_pedido) values(?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1,obj.getCod());
            stmt.setString(2,obj.getItem());
            stmt.setInt(3,obj.getQtd());
            stmt.setString(4,obj.getPedido_id());
            stmt.setString(5,obj.getFornecedor());
            stmt.setInt(6,obj.getQtd());
            stmt.setString(7,obj.getStatus());
            stmt.setString(8,obj.getUn());
            stmt.setString(9,obj.getTipo());
            stmt.setString(10,obj.getDatapedido());
            
            stmt.execute();
            stmt.close();
            
            //JOptionPane.showMessageDialog(null, "Itens no pedido cadastrado com sucesso!");
            
        } catch (Exception erro) {
            
            
            JOptionPane.showMessageDialog(null, "erro está aqui"+erro);
            
        }
        
        
    }
    
}
