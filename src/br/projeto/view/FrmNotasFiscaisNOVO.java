/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.projeto.view;


import br.programa.dao.NotasFiscaisDAO;
import br.programa.model.DadosRecebimento;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;

/**
 *
 * @author samuc
 */
public class FrmNotasFiscaisNOVO extends javax.swing.JFrame {
    
    public void setTextoDoLabelAnterior(String texto,String texto2) {
        lblusuario.setText(texto); // substitua "meuLabelNaNovaTela" pelo nome do seu label na FrmInPedidos
        lblper.setText(texto2); // substitua "meuLabelNaNovaTela" pelo nome do seu label na FrmInPedidos
    }
    
    public void limparTabela(JTable tabela) {
    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
    modelo.setRowCount(0);
}

    /**
     * Creates new form FrmNotasFiscais
     */
    
//    FrmNotasFiscaisPendentes FrmNotasFiscaisPendentes = new FrmNotasFiscaisPendentes();
    
    public FrmNotasFiscaisNOVO() {
        initComponents();
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                String textoDoLabel1 = lblusuario.getText();

                int selectedRow = table.getSelectedRow();
                
              // Selecione os dados da linha selecionada
            String dado1 = table.getValueAt(selectedRow, 0).toString();
            String dado2 = table.getValueAt(selectedRow, 1).toString();
            String dado3 = table.getValueAt(selectedRow, 2).toString();
            String dado4 = table.getValueAt(selectedRow, 3).toString();
//            String dado5 = table.getValueAt(selectedRow, 3).toString();
            String dado6 = table.getValueAt(selectedRow, 9).toString();
            String dado7 = table.getValueAt(selectedRow, 10).toString();
            String dado8 = table.getValueAt(selectedRow, 11).toString();
            String dado9 = table.getValueAt(selectedRow, 12).toString();
            String dado10 = table.getValueAt(selectedRow, 13).toString();
            String dado11 = table.getValueAt(selectedRow, 15).toString();
            
//            String dado12 = table.getValueAt(selectedRow, 5).toString();
//            String dado13 = table.getValueAt(selectedRow, 6).toString();
                String dado12 = "";
                String dado13 = "";
                String dado14 = "";
                String dado15 = "";
                Object value;

                // Obter valor da coluna 5
                value = table.getValueAt(selectedRow, 5);
                if (value != null) {
                    dado12 = value.toString();
                }

                // Obter valor da coluna 6
                value = table.getValueAt(selectedRow, 6);
                if (value != null) {
                    dado13 = value.toString();
                }

                value = table.getValueAt(selectedRow, 7);
                if (value != null) {
                    dado14 = value.toString();;
                }
                    value = table.getValueAt(selectedRow, 8);
                if (value != null) {
                    dado15 = value.toString();;
                }
                

            // ... e assim por diante
            // Agora você pode chamar o formulário existente e preencher os campos JText com os dados selecionados
             String statusColuna2 = table.getValueAt(selectedRow, 14).toString();
             
//            if ("AGUARDANDO LANÇAMENTO NO SICA".equals(statusColuna2)) {
                // Executar o código normalmente
                FrmNotasFiscaisPendentesEncaminhar form = new FrmNotasFiscaisPendentesEncaminhar();
                try {
                    form.setDados(dado1, dado2, dado3,dado4, dado6, dado7, dado8, dado9, dado10, dado11, dado12, dado13, dado14,dado15/*...*/);
                } catch (ParseException ex) {
                    Logger.getLogger(FrmNotasFiscaisNOVO.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                form.setUsuario(textoDoLabel1);
                form.setVisible(true);
                
//            } else {
//                // Exibir aviso na tela
//                JOptionPane.showMessageDialog(null, "A coluna 2 não possui o valor 'OK'.");
//            }
                
                            limparTabela(table);    
         
            }

            @Override
            public void onDelete(int row) {
                String textoDoLabel1 = lblusuario.getText();
                int selectedRow = table.getSelectedRow();
                
               // Selecione os dados da linha selecionada
            String dado1 = table.getValueAt(selectedRow, 0).toString();
            String dado2 = table.getValueAt(selectedRow, 1).toString();
            String dado3 = table.getValueAt(selectedRow, 2).toString();
            String dado4 = table.getValueAt(selectedRow, 3).toString();
//            String dado5 = table.getValueAt(selectedRow, 3).toString();
            String dado6 = table.getValueAt(selectedRow, 9).toString();
            String dado7 = table.getValueAt(selectedRow, 10).toString();
            String dado8 = table.getValueAt(selectedRow, 11).toString();
            String dado9 = table.getValueAt(selectedRow, 12).toString();
            String dado10 = table.getValueAt(selectedRow, 13).toString();
            String dado11 = table.getValueAt(selectedRow, 15).toString();
            
//            String dado12 = table.getValueAt(selectedRow, 5).toString();
//            String dado13 = table.getValueAt(selectedRow, 6).toString();
                String dado12 = "";
                String dado13 = "";
                String dado14 = "";
                String dado15 = "";
                Object value;

                // Obter valor da coluna 5
                value = table.getValueAt(selectedRow, 5);
                if (value != null) {
                    dado12 = value.toString();
                }

                // Obter valor da coluna 6
                value = table.getValueAt(selectedRow, 6);
                if (value != null) {
                    dado13 = value.toString();
                }

                value = table.getValueAt(selectedRow, 7);
                if (value != null) {
                    dado14 = value.toString();;
                }
                    value = table.getValueAt(selectedRow, 8);
                if (value != null) {
                    dado15 = value.toString();;
                }
                
            
            
            // ... e assim por diante
            // Agora você pode chamar o formulário existente e preencher os campos JText com os dados selecionados
             String statusColuna2 = table.getValueAt(selectedRow, 14).toString();
             
             
            if ("AGUARDANDO RETORNO DO SETOR".equals(statusColuna2)) {
                // Executar o código normalmente
                FrmNotasFiscaisPendentesNOVO form = new FrmNotasFiscaisPendentesNOVO();
                
                try {
                    form.setDados(dado1, dado2, dado3,dado4, dado6, dado7, dado8, dado9, dado10, dado11, dado12, dado13, dado14, dado15/*...*/);
                } catch (ParseException ex) {
                    Logger.getLogger(FrmNotasFiscaisNOVO.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                form.setUsuario(textoDoLabel1);
                form.setVisible(true);
               
            } else {
                // Exibir aviso na tela
                JOptionPane.showMessageDialog(null, "A nota fiscal não pode ser recebida, pois seus status não está como encaminhada ou pronta pra recebimento");
            }limparTabela(table);
            
            }

            @Override
            public void onView(int row) {
                String textoDoLabel1 = lblusuario.getText();
                int selectedRow = table.getSelectedRow();
                
               // Selecione os dados da linha selecionada
            String dado1 = table.getValueAt(selectedRow, 0).toString();
            String dado2 = table.getValueAt(selectedRow, 1).toString();
            String dado3 = table.getValueAt(selectedRow, 2).toString();
            String dado4 = table.getValueAt(selectedRow, 3).toString();
//            String dado5 = table.getValueAt(selectedRow, 3).toString();
            String dado6 = table.getValueAt(selectedRow, 9).toString();
            String dado7 = table.getValueAt(selectedRow, 10).toString();
            String dado8 = table.getValueAt(selectedRow, 11).toString();
            String dado9 = table.getValueAt(selectedRow, 12).toString();
            String dado10 = table.getValueAt(selectedRow, 13).toString();
            String dado11 = table.getValueAt(selectedRow, 15).toString();
            
//            String dado12 = table.getValueAt(selectedRow, 5).toString();
//            String dado13 = table.getValueAt(selectedRow, 6).toString();
                String dado12 = "";
                String dado13 = "";
                String dado14 = "";
                String dado15 = "";
                Object value;

                // Obter valor da coluna 5
                value = table.getValueAt(selectedRow, 5);
                if (value != null) {
                    dado12 = value.toString();
                }

                // Obter valor da coluna 6
                value = table.getValueAt(selectedRow, 6);
                if (value != null) {
                    dado13 = value.toString();
                }

                value = table.getValueAt(selectedRow, 7);
                if (value != null) {
                    dado14 = value.toString();;
                }
                    value = table.getValueAt(selectedRow, 8);
                if (value != null) {
                    dado15 = value.toString();;
                }
                
             String statusColuna2 = table.getValueAt(selectedRow, 14).toString();
            if ("AGUARDANDO LANÇAMENTO NO SICA".equals(statusColuna2)) {
                // Executar o código normalmente
                FrmNotasFiscaisPendentesReceber form = new FrmNotasFiscaisPendentesReceber();
                try {
                    form.setDados(dado1, dado2, dado3,dado4, dado6, dado7, dado8, dado9, dado10, dado11, dado12, dado13, dado14, dado15/*...*/);
                } catch (ParseException ex) {
                    Logger.getLogger(FrmNotasFiscaisNOVO.class.getName()).log(Level.SEVERE, null, ex);
                }
                form.setUsuario(textoDoLabel1);
                form.setVisible(true);
                
            } else {
                // Exibir aviso na tela
                JOptionPane.showMessageDialog(null, "O pedido não pode ser inserido pois está com alguma pendencia em outro setor!");
            }limparTabela(table);
            }  
            
};
                
                
        table.getColumnModel().getColumn(16).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(16).setCellEditor(new TableActionCellEditor(event));
        
        
    }

        
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtNNF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cbSstatus3 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        TxtNof = new javax.swing.JTextField();
        CbAreas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblper = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setForeground(new java.awt.Color(60, 63, 65));

        jLabel1.setText("Nº NF");

        TxtNNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNNFActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbSstatus3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AGUARDANDO LANÇAMENTO NO SICA", "AGUARDANDO RETORNO DO SETOR", "RETORNADO, AGUARDANDO LANÇAMENTO" }));

        jLabel2.setText("STATUS");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATA EMISSAO", "DATA REC", "OBS GERAL NF", "OBS ENCAMINHA", "STATUS1", "MOTIVO", "DATA ENV", "DATA RETURN", "Nº Nota Fiscal", "Nº OF", "Total", "Fornecedor", "Projeto", "Status", "cnpj", "Ação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(40);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(30);
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(0).setMaxWidth(30);
            table.getColumnModel().getColumn(1).setMinWidth(0);
            table.getColumnModel().getColumn(1).setPreferredWidth(0);
            table.getColumnModel().getColumn(1).setMaxWidth(0);
            table.getColumnModel().getColumn(2).setMinWidth(0);
            table.getColumnModel().getColumn(2).setPreferredWidth(0);
            table.getColumnModel().getColumn(2).setMaxWidth(0);
            table.getColumnModel().getColumn(3).setMinWidth(0);
            table.getColumnModel().getColumn(3).setPreferredWidth(0);
            table.getColumnModel().getColumn(3).setMaxWidth(0);
            table.getColumnModel().getColumn(4).setMinWidth(0);
            table.getColumnModel().getColumn(4).setPreferredWidth(0);
            table.getColumnModel().getColumn(4).setMaxWidth(0);
            table.getColumnModel().getColumn(5).setMinWidth(0);
            table.getColumnModel().getColumn(5).setPreferredWidth(0);
            table.getColumnModel().getColumn(5).setMaxWidth(0);
            table.getColumnModel().getColumn(6).setMinWidth(0);
            table.getColumnModel().getColumn(6).setPreferredWidth(0);
            table.getColumnModel().getColumn(6).setMaxWidth(0);
            table.getColumnModel().getColumn(7).setMinWidth(0);
            table.getColumnModel().getColumn(7).setPreferredWidth(0);
            table.getColumnModel().getColumn(7).setMaxWidth(0);
            table.getColumnModel().getColumn(8).setMinWidth(0);
            table.getColumnModel().getColumn(8).setPreferredWidth(0);
            table.getColumnModel().getColumn(8).setMaxWidth(0);
            table.getColumnModel().getColumn(9).setMinWidth(50);
            table.getColumnModel().getColumn(9).setPreferredWidth(50);
            table.getColumnModel().getColumn(9).setMaxWidth(50);
            table.getColumnModel().getColumn(10).setMinWidth(70);
            table.getColumnModel().getColumn(10).setPreferredWidth(70);
            table.getColumnModel().getColumn(10).setMaxWidth(70);
            table.getColumnModel().getColumn(11).setMinWidth(70);
            table.getColumnModel().getColumn(11).setPreferredWidth(70);
            table.getColumnModel().getColumn(11).setMaxWidth(70);
            table.getColumnModel().getColumn(12).setMinWidth(240);
            table.getColumnModel().getColumn(12).setPreferredWidth(240);
            table.getColumnModel().getColumn(12).setMaxWidth(240);
            table.getColumnModel().getColumn(13).setMinWidth(240);
            table.getColumnModel().getColumn(13).setPreferredWidth(240);
            table.getColumnModel().getColumn(13).setMaxWidth(240);
            table.getColumnModel().getColumn(14).setMinWidth(240);
            table.getColumnModel().getColumn(14).setPreferredWidth(240);
            table.getColumnModel().getColumn(14).setMaxWidth(240);
            table.getColumnModel().getColumn(15).setMinWidth(0);
            table.getColumnModel().getColumn(15).setPreferredWidth(0);
            table.getColumnModel().getColumn(15).setMaxWidth(0);
            table.getColumnModel().getColumn(16).setMinWidth(120);
            table.getColumnModel().getColumn(16).setPreferredWidth(120);
            table.getColumnModel().getColumn(16).setMaxWidth(120);
        }

        jLabel3.setText("Nº OF");

        TxtNof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNofActionPerformed(evt);
            }
        });

        CbAreas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AREA PROGRAMATICA 3.1", "AREA PROGRAMATICA 5.2", "AREA PROGRAMATICA 2.2", "HOSPITAL MUNICIPAL PIEDADE", "HOSPITAL MUNICIPAL DR GILSON CANTARINO", "HOSPITAL MUNICIPAL FRANCISCO DA SILVA TELLES", "HOSPITAL MUNICIPAL ALBERT SCHWEITZER" }));
        CbAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbAreasActionPerformed(evt);
            }
        });

        jLabel4.setText("Centro de Custo");

        jLabel9.setText("Usuário:");

        lblusuario.setBackground(new java.awt.Color(51, 255, 102));
        lblusuario.setForeground(new java.awt.Color(0, 204, 51));
        lblusuario.setText("Teste");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LOGO MENOR.png"))); // NOI18N

        lblper.setBackground(new java.awt.Color(51, 255, 102));
        lblper.setForeground(new java.awt.Color(0, 204, 51));
        lblper.setText("Teste");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(TxtNNF, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNof, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CbAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbSstatus3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(jLabel2))
                        .addGap(0, 212, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lblper)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSstatus3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(lblusuario)
                        .addComponent(lblper))
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(28, 170, 158));
        jPanel7.setForeground(new java.awt.Color(0, 0, 51));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CONSULTA STATUS DE NOTAS FISCAIS");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNNFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNNFActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         String of = "%" + TxtNof.getText() + "%" ;         
         String nf = "%"+ TxtNNF.getText() + "%";
         String status = cbSstatus3.getSelectedItem().toString();
        
        NotasFiscaisDAO dao = new NotasFiscaisDAO();
        List<DadosRecebimento> lista = dao.buscaNfPorNumero(of,nf,status);
        DefaultTableModel dados = (DefaultTableModel)table.getModel();
        dados.setNumRows(0);
        
        for (DadosRecebimento c: lista){
        dados.addRow(new Object[]{
            c.getId(),
            c.getData_emissao(),
            c.getData_rec(),
            c.getObs1(),
            c.getObs2(),
            c.getStatus1(),
            c.getMotivo(),
            c.getData_emv(),
            c.getData_return(),
            c.getNumnf(),
            c.getNumeroOF(),
            c.getValor_total(),
            c.getFornecedor(),
            c.getProjeto(),
            c.getStatus(),
            c.getCnpj(),
           
        });
        }
    
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_tableMouseClicked

    private void TxtNofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNofActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNofActionPerformed

    private void CbAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbAreasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbAreasActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        int numero = Integer.parseInt(lblper.getText());
        
        if (numero == 1) {
   DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) CbAreas.getModel();
   model.removeAllElements();
   model.addElement("AREA PROGRAMATICA 3.1");
   model.addElement("AREA PROGRAMATICA 5.2");
   model.addElement("AREA PROGRAMATICA 2.2");
   // Adicione quantos itens desejar
}

    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmNotasFiscaisNOVO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNotasFiscaisNOVO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNotasFiscaisNOVO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNotasFiscaisNOVO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmNotasFiscaisNOVO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbAreas;
    private javax.swing.JTextField TxtNNF;
    private javax.swing.JTextField TxtNof;
    private javax.swing.JComboBox<String> cbSstatus3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblper;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
