import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.*;

public class SeuAplicativo {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        // adicione o restante do código do seu aplicativo aqui
    }
}
