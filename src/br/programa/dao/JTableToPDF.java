package br.programa.dao;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.programa.model.DadosRecebimento;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.filechooser.FileNameExtensionFilter;



public class JTableToPDF {
    
    
   public static void exportToPDF(JTable table,DadosRecebimento dados, ArrayList<Integer> selectedRowList) throws DocumentException {
       
//       DadosRecebimento dados = new DadosRecebimento();

                dados.getNumnf();
                dados.getNumeroOF();
                dados.getData_emissao();
                dados.getData_rec();
                dados.getFornecedor();
                dados.getProjeto();
                dados.getData_emv();
                dados.getData_return();
                dados.getStatus();
                dados.getMotivo();
                dados.getObs1();
                dados.getObs2();
                dados.getCnpj();
                dados.getValor_total();
                
                
                JFileChooser fileChooser = new JFileChooser();
int result = fileChooser.showSaveDialog(null);

if (result == JFileChooser.APPROVE_OPTION) {
    File file = fileChooser.getSelectedFile();
    if (!file.getName().endsWith(".pdf")) {
        file = new File(file.getParentFile(), file.getName() + ".pdf");
    }

    Document document = new Document(PageSize.A4);

    try {
        PdfWriter.getInstance(document, new FileOutputStream(file));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

                   document.open();
          

         // Adicionando a imagem ao PDF
            Image image = null;
            try {
                image = Image.getInstance("src/imagens/DO IT LOOGO.png");
                image.scaleToFit(60,60);
                float x = (PageSize.A4.getWidth() - image.getScaledWidth()) / 1-35; // Calcula a coordenada X para o centro da página
                float y = PageSize.A4.getHeight() - 70; // Define a coordenada Y para o canto superior
                image.setAbsolutePosition(x, y);
                document.add(image);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Image image2 = null;
            try {
                image2 = Image.getInstance("src/imagens/vr-removebg-preview.png");
                image2.scaleToFit(60,60);
                float x2 = (PageSize.A4.getWidth() - image2.getScaledWidth()) / 12; // Calcula a coordenada X para o centro da página
                float y2 = PageSize.A4.getHeight() - 80; // Define a coordenada Y para o canto superior
                image2.setAbsolutePosition(x2, y2);
                document.add(image2);
            } catch (Exception e) {
                e.printStackTrace();
            }
         
                            Font font = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
                            Font font2 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

               Paragraph title = new Paragraph("PROTOCOLO DE ENVIO DE NOTA FISCAL", font);
               title.setAlignment(Element.ALIGN_CENTER);

               try {          
                   document.add(title);
               } catch (DocumentException ex) {
                   Logger.getLogger(JTableToPDF.class.getName()).log(Level.SEVERE, null, ex);
               }
                     
          
           Paragraph branco = new Paragraph("                       ");
            branco.setAlignment(Element.ALIGN_CENTER);
          try {
              document.add(branco);
          } catch (DocumentException ex) {
              Logger.getLogger(JTableToPDF.class.getName()).log(Level.SEVERE, null, ex);
          }
          
//          String text = dados.getMotivo();
//          Paragraph paragraph = new Paragraph(text);
//          document.add(paragraph);
            document.add(Chunk.NEWLINE);   
            
            LocalDate dataAtual = LocalDate.now();
            
            Paragraph Protocolo = new Paragraph("PROTOCOLO Nº:"+ dados.getNumnf()  + dataAtual.getDayOfMonth() +dataAtual.getMonthValue()+ dataAtual.getYear(),font2);
            Protocolo.setAlignment(Element.ALIGN_RIGHT);
            try {
              document.add(Protocolo);
          } catch (DocumentException ex) {
              Logger.getLogger(JTableToPDF.class.getName()).log(Level.SEVERE, null, ex);
          }
            

            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("DE: RESSUPRIMENTOS E LOGÍSTICA",font2));            
            document.add(new Paragraph("PARA: "+dados.getStatus(),font2));            
            document.add(Chunk.NEWLINE);
            
            document.add(new Paragraph("Nº NF: "+ dados.getNumnf(),font2));            
            document.add(new Paragraph("VALOR TOTAL DA NF: "+ dados.getValor_total(),font2));            
            document.add(new Paragraph("EMISSÃO: " + dados.getData_emissao(),font2));            
            document.add(new Paragraph("FORNECEDOR: " + dados.getFornecedor(),font2));            
            document.add(new Paragraph("CNPJ: " + dados.getCnpj(),font2));            
            document.add(new Paragraph("OF: " + dados.getNumeroOF(),font2));            
            document.add(new Paragraph("CENTRO DE CUSTO: " + dados.getProjeto(),font2));                     
            
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            
            
            
            /////////////TABELA DE ITENS////////////
                    Font fonte = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

PdfPCell headerCell;
headerCell = new PdfPCell(new Phrase("CÓDIGO VR", new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
headerCell.setMinimumHeight(30f);
pdfTable.addCell(headerCell);

headerCell = new PdfPCell(new Phrase("NOMENCLATURA", new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
headerCell.setMinimumHeight(30f);
pdfTable.addCell(headerCell);

headerCell = new PdfPCell(new Phrase("UNIT", new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
headerCell.setMinimumHeight(30f);
pdfTable.addCell(headerCell);

headerCell = new PdfPCell(new Phrase("QTD", new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
headerCell.setMinimumHeight(30f);
pdfTable.addCell(headerCell);

// Define as larguras das colunas em pontos
// Define as larguras das colunas em pontos
float[] columnWidths = new float[] {70f, 290f,35f,35f}; // Exemplo de larguras das colunas em pontos
pdfTable.setWidths(columnWidths);

// Obter as linhas selecionadas
int[] selectedRows = table.getSelectedRows();

// Adiciona as células na tabela
for (int i = 0; i < table.getRowCount(); i++) {
    for (int j = 0; j < table.getColumnCount(); j++) {
        PdfPCell cell;
        boolean isSelected = false;
        for (int k = 0; k < selectedRows.length; k++) {
            if (i == selectedRows[k]) {
                isSelected = true;
                break;
            }
        }
        if (isSelected) {
            cell = new PdfPCell(new Phrase(table.getValueAt(i, j).toString()));
            cell.setBackgroundColor(BaseColor.YELLOW);
        } else {
            cell = new PdfPCell(new Phrase(table.getValueAt(i, j).toString()));
        }
        cell.setMinimumHeight(30f); // Define a altura mínima da célula para aumentar a altura da linha
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Define alinhamento vertical das células como central
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfTable.addCell(cell);
    }
}




try {
    document.add(pdfTable);
} catch (DocumentException e) {
    e.printStackTrace();
}

         
         document.add(Chunk.NEWLINE);  
         
         
            document.add(new Paragraph("MOTIVO DO ENVIO: " + dados.getMotivo(),font2));            
            document.add(Chunk.NEWLINE);
            
            document.add(new Paragraph("OBS: " + dados.getObs2(),font2));
            document.add(Chunk.NEWLINE);  

            
            Paragraph branco1 = new Paragraph("__________________________"+"                        "+"__________________________");
            branco1.setAlignment(Element.ALIGN_CENTER);
            try {
              document.add(branco1);
          } catch (DocumentException ex) {
              Logger.getLogger(JTableToPDF.class.getName()).log(Level.SEVERE, null, ex);
          }
            
//            document.add(Chunk.NEWLINE);
            
            Paragraph branco2 = new Paragraph("(CARIMBO E ASSINATURA)"+"                                           "+"(CARIMBO E ASSINATURA)",font2);
            branco2.setAlignment(Element.ALIGN_CENTER);
            try {
              document.add(branco2);
          } catch (DocumentException ex) {
              Logger.getLogger(JTableToPDF.class.getName()).log(Level.SEVERE, null, ex);
          }
            
             
         document.close();
      }
   }


}
