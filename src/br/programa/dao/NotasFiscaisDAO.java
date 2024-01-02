package br.programa.dao;


import br.programa.jdbc.ConnectionFactory;
import br.programa.model.DadosPedidos;
import br.programa.model.DadosRecebimento;
import br.programa.model.Funcionarios;
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
public class NotasFiscaisDAO {
    
    //CRIAR O ACESSO AO SQL
    private Connection con;
    
    public NotasFiscaisDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    }
    
    
    //METODO CADASTRAR CLIENTE
    public void cadastrarNotaFiscal(DadosRecebimento list){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "insert into tb_nf_historico(n_nf,n_of,valor_total,data_rec,data_emissao,data_entrega,data_sica,status,projeto,fornecedor,obs1,cnpj_fornecedor,tipo_produto,id_fornecedor)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, list.getNumnf());
            stmt.setString(2, list.getNumeroOF());
            stmt.setString(3, list.getValor_total());
            stmt.setString(4, list.getData_rec());
            stmt.setString(5, list.getData_emissao());
            stmt.setString(6, list.getData_entrega());
            stmt.setString(7, list.getData_sica());
            stmt.setString(8, list.getStatus());
            stmt.setString(9, list.getProjeto());
            stmt.setString(10, list.getFornecedor());
            stmt.setString(11, list.getObs1());
            stmt.setString(12, list.getCnpj());
            stmt.setString(13, list.getTipo_produto());
            stmt.setString(14, list.getId_forn());
            
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
//            JOptionPane.showMessageDialog(null, "Cadastrado");
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
         
         
         public List<DadosRecebimento> buscaNfPorNumero(String of,String nf,String status){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosRecebimento> lista = new ArrayList<>();                         
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_nf_historico where n_of like? and n_nf like? and status=?";
//                 String sql = "select * from tb_lista_pedidos where numero_of like? and status =?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, of);                 
                 stmt.setString(2, nf);   
                 stmt.setString(3, status);   
                                  
                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosRecebimento obj = new DadosRecebimento();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setData_emissao(rs.getString("data_emissao"));
                     obj.setData_rec(rs.getString("data_rec"));
                     obj.setObs1(rs.getString("Obs1"));
                     obj.setObs2(rs.getString("Obs2"));
                     obj.setNumnf(rs.getString("n_nf"));
                     obj.setNumeroOF(rs.getString("n_of"));
                     obj.setValor_total(rs.getString("valor_total"));
                     obj.setProjeto(rs.getString("projeto"));                       
                     obj.setStatus(rs.getString("status"));
                     obj.setFornecedor(rs.getString("fornecedor"));
                     obj.setCnpj(rs.getString("cnpj_fornecedor"));
                     obj.setStatus1(rs.getString("status1"));
                     obj.setMotivo(rs.getString("motivo"));
                     obj.setData_emv(rs.getString("data_env"));
                     obj.setData_return(rs.getString("data_return"));

                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 return null;
                 
             }
             
         }
                  
         
         //METODO CONSULTAR FORNECEDOR POR NOME
         
         public DadosRecebimento consultarNf(String id){
             
             try {
                 
                 String sql = "select * from tb_nf_historico where id =?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, id);
                 ResultSet rs = stmt.executeQuery();
                 
                 DadosRecebimento obj = new DadosRecebimento();
                 
                 if(rs.next()){
                                          
//                     obj.setId(rs.getInt("id"));
                     obj.setNumnf(rs.getString("n_nf"));
                     obj.setNumeroOF(rs.getString("n_of"));
                     obj.setStatus(rs.getString("status"));
                     obj.setValor_total(rs.getString("valor_total"));
                     obj.setData_rec(rs.getString("data_rec"));
                     obj.setData_emissao(rs.getString("data_emissao"));
                     obj.setData_emv(rs.getString("data_env"));
                     obj.setData_return(rs.getString("data_return"));
                     obj.setData_sica(rs.getString("data_sica"));
                     obj.setProjeto(rs.getString("projeto"));
                     obj.setFornecedor(rs.getString("fornecedor"));
                     
                 }
                 
                 return obj;
                 
                         
             } catch (SQLException erro) {
                 
                 JOptionPane.showMessageDialog(null, "cliente não encontrado");
                 return null;
                 
                 
             }
             
             
         }
                 
         
         //METODO EFETUAR LOGIN
         
         public void efetuaLogin(String email,String senha){
             
             try {
                 String sql = "select *from tb_funcionarios where email =? and senha =?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, email);
                 stmt.setString(2, senha);
                 
                 ResultSet rs = stmt.executeQuery();
                         
                         if (rs.next()){
                             
                             JOptionPane.showMessageDialog(null, "Sem bem vindo ao sistema");
                             
                             FrmPrincipal tela = new FrmPrincipal();
                             tela.usuariologado = rs.getString("nome");
                             tela.setVisible(true);
                             
                         } else{
                             
                             JOptionPane.showMessageDialog(null, "Dados incorretos");
                             
                         }
                             
                 
             } catch (SQLException erro) {
                 
                 JOptionPane.showMessageDialog(null, "Erro"+erro);
                 
             }
                 
             
         }   
         
         
          public List<DadosRecebimento> buscaNotaFiscal(String nome){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosRecebimento> lista = new ArrayList<>();                   
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_nf_historico where n_nf like?";

                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosRecebimento obj = new DadosRecebimento();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setNumeroOF(rs.getString("n_of"));
                     obj.setNumnf(rs.getString("n_nf"));
                     obj.setValor_total(rs.getString("valor_total"));
                     obj.setProjeto(rs.getString("projeto"));
                     obj.setData_rec(rs.getString("data_rec"));
                     obj.setData_emissao(rs.getString("data_emissao"));
                     obj.setData_emv(rs.getString("data_env"));
                     obj.setStatus(rs.getString("status"));

                     
                                         
                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 JOptionPane.showMessageDialog(null, "erro"+erro);
                 return null;
                 
             }
             
         }

         public void cadastrarAuditoria(DadosRecebimento obj1){
        
        try {
            
            //CRIAR COMANDO SQL//           
            String sql = "update tb_nf_historico set N_Of_Anexada=?,Rel_recebimento=?,Folha_Ocorrencia=?,Carimbo_Recebimento=?, Atesto_1=?,Numero_OF_Obs=?,N_Processo_Obs=?,status=?,data_sica=? where id =?";

            
            // CONECTAR VIA COMANDO            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj1.getN_Of_Anexada());
            stmt.setString(2, obj1.getRel_recebimento());
            stmt.setString(3, obj1.getFolha_Ocorrencia());
            stmt.setString(4, obj1.getCarimbo_Recebimento());
            stmt.setString(5, obj1.getAtesto_1());
            stmt.setString(6, obj1.getNumero_OF_Obs());
            stmt.setString(7, obj1.getN_Processo_Obs());
            stmt.setString(8, obj1.getStatus());
            stmt.setString(9, obj1.getData_sica());
//            stmt.setString(10, obj1.getData_emv());
//            stmt.setString(11, obj1.getData_return());
//            stmt.setString(12, obj1.getStatus1());
//            stmt.setString(13, obj1.getMotivo());

            stmt.setInt(10,obj1.getId());
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Auditoria cadastrada com sucesso!");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
        
    }
         public boolean verificarNomeDuplicado(String Nof,String Nnf){
             
             boolean nomeDuplicado = false;
             
             try {
                 
                 String sql = "select * from tb_nf_historico where n_of =? AND n_nf=?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, Nof);
                 stmt.setString(2, Nnf);

                 ResultSet rs = stmt.executeQuery();

                 
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
         
         public List<DadosRecebimento> buscaNotaFiscalStatusAuditoria(String nome,String status, String Ccusto){
             
             try {
                 
                 //CRIANDO A LISTA
                 
                 List<DadosRecebimento> lista = new ArrayList<>();                   
                 
                 //2 CRIANDO COMANDO SQL
                 
                 String sql = "select * from tb_nf_historico where n_nf like? AND status like? AND projeto like?";

                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nome);
                 stmt.setString(2, status);
                 stmt.setString(3, Ccusto);
                 
                 ResultSet rs = stmt.executeQuery();
                 
                 while(rs.next()){
                     DadosRecebimento obj = new DadosRecebimento();
                     
                     obj.setId(rs.getInt("id"));
                     obj.setNumeroOF(rs.getString("n_of"));
                     obj.setNumnf(rs.getString("n_nf"));
                     obj.setValor_total(rs.getString("valor_total"));
                     obj.setProjeto(rs.getString("projeto"));
                     obj.setData_rec(rs.getString("data_rec"));
                     obj.setData_emissao(rs.getString("data_emissao"));
                     obj.setData_emv(rs.getString("data_env"));
                     obj.setStatus(rs.getString("status"));
                     obj.setObs1(rs.getString("Obs1"));
                     obj.setFornecedor(rs.getString("fornecedor"));
                     obj.setCnpj(rs.getString("cnpj_fornecedor"));

                     
                                         
                     
                     lista.add(obj);
                     
                 }
                 
                 return lista;
                 
                 
                 
             } catch (SQLException erro) {
                 JOptionPane.showMessageDialog(null, "erro"+erro);
                 return null;
                 
             }
             
         }
                 
         
         public void editarNf(DadosRecebimento obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "update tb_nf_historico set status=?,data_env=?,data_return=?,status1=?, motivo=? where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getStatus());
            stmt.setString(2, obj.getData_emv());
            stmt.setString(3, obj.getData_rec());
            stmt.setString(4, obj.getStatus1());
            stmt.setString(5, obj.getMotivo());

            stmt.setInt(6,obj.getId());
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Pedido encaminhado com sucesso!");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
        
    }
         
        
         
          public void editarNf2(DadosRecebimento obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "update tb_nf_historico set status=?,data_return=? where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getStatus());
            stmt.setString(2, obj.getData_return());

            stmt.setInt(3,obj.getId());
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Pedido retornado ao sistema pronto para inserção no sica!");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
        
    }
          
           public void editarNf3(DadosRecebimento obj){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "update tb_nf_historico set status=?,data_sica=? where id =?";

            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getStatus());
            stmt.setString(2, obj.getData_sica());

            stmt.setInt(3,obj.getId());
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Nota fiscal inserida no sistema");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
        
    }
           
            public boolean verificarNomeDuplicado2(String texto, String texto2){
             
             boolean nomeDuplicado = false;
             
             try {
                 
                 String sql = "select * from tb_nf_historico where n_of =? AND n_nf=?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, texto);
                 stmt.setString(2, texto2);
                 ResultSet rs = stmt.executeQuery();
                 
                 
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
            
             public void EditarNotaFiscal(DadosRecebimento list){
        
        try {
            
            //CRIAR COMANDO SQL
            String sql = "update tb_nf_historico set n_nf=?,n_of=?,valor_total=?,data_rec=?,data_emissao=?,data_entrega=?,data_sica=?,status=?,projeto=?,fornecedor=?,obs1=?,cnpj_fornecedor=?,tipo_produto=?,id_fornecedor =? where id=?";


            
            // CONECTAR VIA COMANDO
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, list.getNumnf());
            stmt.setString(2, list.getNumeroOF());
            stmt.setString(3, list.getValor_total());
            stmt.setString(4, list.getData_rec());
            stmt.setString(5, list.getData_emissao());
            stmt.setString(6, list.getData_entrega());
            stmt.setString(7, list.getData_sica());
            stmt.setString(8, list.getStatus());
            stmt.setString(9, list.getProjeto());
            stmt.setString(10, list.getFornecedor());
            stmt.setString(11, list.getObs1());
            stmt.setString(12, list.getCnpj());
            stmt.setString(13, list.getTipo_produto());
            stmt.setString(14, list.getId_forn());
            
            stmt.setInt(15,list.getId());
            
            
            // EXECUTAR COMANDOI SQL
            stmt.execute();
            stmt.close();
            
//            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "erro"+erro);
            
        }
        
    }
         
}
