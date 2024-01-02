import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class ReadExcelFile {

    public static void main(String[] args) throws IOException {
        // Caminho do arquivo Excel
        String excelFilePath = "C:\\Users\\samuc\\OneDrive\\Área de Trabalho\\Novo Pedido.xlsx";

        // Abrir arquivo Excel em um FileInputStream
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Criação do objeto Workbook usando o FileInputStream
        Workbook workbook = WorkbookFactory.create(inputStream);

        // Obter a primeira planilha do arquivo Excel
        Sheet sheet = workbook.getSheetAt(0);

        // Loop para ler todas as linhas da planilha
        for (Row row : sheet) {
            // Loop para ler todas as células de cada linha
            for (Cell cell : row) {
                // Obter o valor da célula como uma String e imprimir
                String cellValue = cell.getStringCellValue();
                System.out.print(cellValue + "\t");
            }
            System.out.println(); // Imprimir uma nova linha após cada linha lida
        }

        // Fechar o arquivo e liberar os recursos
        workbook.close();
        inputStream.close();
    }
}
