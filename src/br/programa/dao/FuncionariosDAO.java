package br.programa.dao;


import br.programa.jdbc.ConnectionFactory;
import br.programa.model.Funcionarios;
import br.projeto.view.FrmLogin;
import br.projeto.view.FrmPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samuc
 */
public class FuncionariosDAO {
    
    //CRIAR O ACESSO AO SQL
    private Connection con;
    
    public FuncionariosDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    }
    
    
    //METODO CADASTRAR CLIENTE
    public void cadastrarFuncioanrio(Funcionarios obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "insert into tb_funcionarios(nome,email,senha,cc_recebimento)values(?,?,?,?)";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getSenha());
            stmt.setString(4, obj.getCc_recebimento());
//            stmt.setString(4, obj.getNivel_acesso());
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
        
    }
    
      public void editarFuncioanrio(Funcionarios obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "update tb_funcionarios set nome=?,email=?,senha=?,nivel_acesso=? where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getSenha());
            stmt.setString(4, obj.getNivel_acesso());
            stmt.setInt(5,obj.getId());
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
        
    }
      
         public void excluirFuncioanrio(Funcionarios obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "delete from tb_funcionarios where id =?";

            
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
    
         
         //METODO LISTAR TODOS OS FUNCIONÁRIOS
         
         public List<Funcionarios> listarFuncionarios(){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<Funcionarios> lista = new ArrayList<>();                         
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_funcionarios";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     Funcionarios obj = new Funcionarios();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setNome(rs.getString("nome"));
                     obj.setEmail(rs.getString("email"));
                     obj.setSenha(rs.getString("senha"));
                     obj.setNivel_acesso(rs.getString("nivel_acesso"));
                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 return null;
                 
             }
             
         }
         
         
         public List<Funcionarios> buscaClientePorNome(String nome){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<Funcionarios> lista = new ArrayList<>();                         
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_funcionarios where nome like?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     Funcionarios obj = new Funcionarios();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setNome(rs.getString("nome"));
                     obj.setEmail(rs.getString("email"));
                     obj.setSenha(rs.getString("senha"));
                     obj.setNivel_acesso(rs.getString("nivel_acesso"));
                     obj.setCc_recebimento(rs.getString("cc_recebimento"));
                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 return null;
                 
             }
             
         }
         
         //METODO CONSULTAR FORNECEDOR POR NOME
         
         public Funcionarios consultaPorNome(String nome){
             
             try {
                 
                 String sql = "select * from tb_funcionarios where nome =";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 ResultSet rs = stmt.executeQuery();
                 
                 Funcionarios obj = new Funcionarios();
                 
                 if(rs.next()){
                                          
                     obj.setId(rs.getInt("id"));
                     obj.setNome(rs.getString("nome"));
                     obj.setEmail(rs.getString("email"));
                     obj.setSenha(rs.getString("senha"));
                     obj.setNivel_acesso(rs.getString("nivel_acesso"));
                     
                 }
                 
                 return obj;
                 
                         
             } catch (SQLException erro) {
                 
                 JOptionPane.showMessageDialog(null, "cliente não encontrado");
                 return null;
                 
                 
             }
             
             
         }
                 
         
         //METODO EFETUAR LOGIN
         
                        public boolean efetuaLogin(String email, String senha) {
                    try {
                        System.out.println("Email: " + email + ", senha: " + senha); // Adiciona um log para verificar os valores dos parâmetros
                        String sql = "select * from tb_funcionarios where email = ? and senha = ?";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1, email);
                        stmt.setString(2, senha);
                        ResultSet rs = stmt.executeQuery();
                        if (rs.next()) {
                             
                             if(rs.getString("nivel_acesso").equals("1")){
                             
                                 
                             FrmPrincipal tela = new FrmPrincipal();
                             
                             tela.usuariologado = rs.getString("nome");
                             tela.nivellogado = rs.getString("cc_recebimento");
                             
                             tela.setVisible(true);
                             
                             return true;
                             }
                             
                             else if(rs.getString("nivel_acesso").equals("2")){
                                 
                                  
                             
                             FrmPrincipal tela = new FrmPrincipal();
                             
                             tela.usuariologado = rs.getString("nome");
                             tela.nivellogado = rs.getString("cc_recebimento");
                             
                             tela.MenuNovoPedido.setEnabled(true);
                             tela.MenuDadosPedido.setEnabled(true);
                             tela.MenuEditarPedido.setEnabled(true);
                             tela.MenuReceberProdutos.setEnabled(false);
                             tela.MenuAuditoria.setEnabled(false);
                             tela.MenuRecebimentoNf.setEnabled(false);
                             tela.MenuFuncionario.setEnabled(false);
                             tela.MenuFornecedor.setEnabled(false);
                             tela.MenuProdutos.setEnabled(false);
                             tela.MenuPrevisao.setEnabled(false);
                             
                             tela.setVisible(true);
                                 
                             return true;
                                 
                             }
                             
                             else if(rs.getString("nivel_acesso").equals("3")){
                                 
                            
                             
                             FrmPrincipal tela = new FrmPrincipal();
                             
                             tela.usuariologado = rs.getString("nome");
                             
                             tela.MenuNovoPedido.setEnabled(true);
                             tela.MenuDadosPedido.setEnabled(true);
                             tela.MenuEditarPedido.setEnabled(true);
                             tela.MenuReceberProdutos.setEnabled(true);
                             tela.MenuAuditoria.setEnabled(false);
                             tela.MenuRecebimentoNf.setEnabled(false);
                             tela.MenuFuncionario.setEnabled(false);
                             tela.MenuFornecedor.setEnabled(false);
                             tela.MenuProdutos.setEnabled(false);
                             tela.MenuPrevisao.setEnabled(false);
                             
                             tela.setVisible(true);
                                 
                                 
                             }
                             
                             else if(rs.getString("nivel_acesso").equals("4")){
                                 
                            
                             
                             FrmPrincipal tela = new FrmPrincipal();
                             
                             tela.usuariologado = rs.getString("nome");
                             
                             tela.MenuNovoPedido.setEnabled(false);
                             tela.MenuDadosPedido.setEnabled(false);
                             tela.MenuEditarPedido.setEnabled(false);
                             tela.MenuReceberProdutos.setEnabled(true);
                             tela.MenuAuditoria.setEnabled(false);
                             tela.MenuRecebimentoNf.setEnabled(false);
                             tela.MenuFuncionario.setEnabled(false);
                             tela.MenuFornecedor.setEnabled(false);
                             tela.MenuProdutos.setEnabled(false);
                             tela.MenuPrevisao.setEnabled(false);
                             
                             tela.setVisible(true);
                                 
                                 
                             }
                             
                              else if(rs.getString("nivel_acesso").equals("5")){
                                 
                            
                             
                             FrmPrincipal tela = new FrmPrincipal();
                             
                             tela.usuariologado = rs.getString("nome");
                             
                             tela.MenuNovoPedido.setEnabled(false);
                             tela.MenuDadosPedido.setEnabled(false);
                             tela.MenuEditarPedido.setEnabled(false);
                             tela.MenuReceberProdutos.setEnabled(true);
                             tela.MenuAuditoria.setEnabled(false);
                             tela.MenuRecebimentoNf.setEnabled(true);
                             tela.MenuFuncionario.setEnabled(false);
                             tela.MenuFornecedor.setEnabled(false);
                             tela.MenuProdutos.setEnabled(false);
                             tela.MenuPrevisao.setEnabled(true);
                             
                             tela.setVisible(true);
                                 
                                 
                             }
                             
                             else if(rs.getString("nivel_acesso").equals("6")){
                                 
                            
                             
                             FrmPrincipal tela = new FrmPrincipal();
                             
                             tela.usuariologado = rs.getString("nome");
                             
                             tela.MenuNovoPedido.setEnabled(false);
                             tela.MenuDadosPedido.setEnabled(false);
                             tela.MenuEditarPedido.setEnabled(false);
                             tela.MenuReceberProdutos.setEnabled(true);
                             tela.MenuAuditoria.setEnabled(true);
                             tela.MenuRecebimentoNf.setEnabled(true);
                             tela.MenuFuncionario.setEnabled(false);
                             tela.MenuFornecedor.setEnabled(false);
                             tela.MenuProdutos.setEnabled(false);
                             tela.MenuPrevisao.setEnabled(true);
                             
                             tela.setVisible(true);
                                 
                                 
                             }
                             
                             else if(rs.getString("nivel_acesso").equals("6")){
                                 
                            
                             
                             FrmPrincipal tela = new FrmPrincipal();
                             
                             tela.usuariologado = rs.getString("nome");
                             
                             tela.MenuNovoPedido.setEnabled(false);
                             tela.MenuDadosPedido.setEnabled(false);
                             tela.MenuEditarPedido.setEnabled(false);
                             tela.MenuReceberProdutos.setEnabled(false);
                             tela.MenuAuditoria.setEnabled(true);
                             tela.MenuRecebimentoNf.setEnabled(false);
                             tela.MenuFuncionario.setEnabled(false);
                             tela.MenuFornecedor.setEnabled(false);
                             tela.MenuProdutos.setEnabled(false);
                             tela.MenuPrevisao.setEnabled(true);
                             
                             tela.setVisible(true);
                                 
                                 
                             }
                             
                         } else{
                             
                             
                             
                         }
                             
                 
             } catch (SQLException erro) {
                 
                 JOptionPane.showMessageDialog(null, "Erro"+erro);
                 
             }
                 
             return false;
         }
         
         public boolean verificarNomeDuplicado(String nome){
             
             boolean nomeDuplicado = false;
             
             try {
                 
                 String sql = "select * from tb_funcionarios where nome =?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 ResultSet rs = stmt.executeQuery();
                 
//                 Funcionarios obj = new Funcionarios();
                 
                 if(rs.next()){
                                          
                                     nomeDuplicado = true;
                     
                 }
                 
                 rs.close();
//                 stmt.close();
//                 con.close();
                 
                         
             } catch (SQLException erro) {
                 
                 JOptionPane.showMessageDialog(null, erro);

                 
                 
             }
             
             return nomeDuplicado;
             
         }
         
         
         
}
