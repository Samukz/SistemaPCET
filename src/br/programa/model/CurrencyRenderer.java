package br.programa.model;

import java.awt.Component;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CurrencyRenderer extends DefaultTableCellRenderer {
    private NumberFormat currencyFormatter;

    public CurrencyRenderer() {
        // Configura o formato de moeda
        currencyFormatter = NumberFormat.getCurrencyInstance();
        setHorizontalAlignment(SwingConstants.RIGHT); // Alinha o valor à direita
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Converte o valor para moeda formatada
        if (value instanceof String) { // Modifica para tratar como String
            String stringValue = value.toString();
            try {
                double doubleValue = Double.parseDouble(stringValue.replace(",", ".")); // Converte para double, substituindo ',' por '.'
                label.setText(currencyFormatter.format(doubleValue));
            } catch (NumberFormatException e) {
                label.setText(stringValue); // Se não for possível converter, mantém o valor original
            }
        }

        return label;
    }
}

