import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

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
        
         if (table.getTableHeader() != null) {
            table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD));
        }

        return cellComponent;
    }
}
