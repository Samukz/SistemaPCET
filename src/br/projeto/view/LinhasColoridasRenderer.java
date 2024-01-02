/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.projeto.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author samuc
 */
public class LinhasColoridasRenderer extends DefaultTableCellRenderer {

    private Color cor1;
    private Color cor2;

    public LinhasColoridasRenderer(Color cor1, Color cor2) {
        this.cor1 = cor1;
        this.cor2 = cor2;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Define a cor de fundo com base na paridade da linha
        if (row % 2 == 0) {
            cellComponent.setBackground(cor1);
        } else {
            cellComponent.setBackground(cor2);
        }

        // Define a cor da fonte com base na seleção da linha
        if (isSelected) {
            cellComponent.setForeground(Color.BLACK); // Define a cor da fonte para preto
            cellComponent.setBackground(table.getSelectionBackground()); // Define a cor de fundo da célula selecionada
        } else {
            cellComponent.setForeground(table.getForeground()); // Mantém a cor da fonte padrão da tabela
        }

        return cellComponent;
    }
}
