import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

public class BarChartExample {

   public static void main(String[] args) {
      
      // Conexão com o banco de dados MySQL
      String url = "jdbc:mysql://database-2.clcsny69ew1x.sa-east-1.rds.amazonaws.com/db-programanovo";
      String usuario = "admin";
      String senha = "UhHca4ppl9SrlmVfrx3m";
      Connection conexao = null;
      try {
         conexao = DriverManager.getConnection(url, usuario, senha);
      } catch (SQLException ex) {
         System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
         return;
      }
      
      // Consulta SQL para recuperar os dados da tabela
      String sql = "SELECT status, qtd FROM tb_lista_pedidos";
      PreparedStatement stmt = null;
      ResultSet rs = null;
      try {
         stmt = conexao.prepareStatement(sql);
         rs = stmt.executeQuery();
      } catch (SQLException ex) {
         System.out.println("Erro ao executar a consulta SQL: " + ex.getMessage());
         return;
      }
      
      // Cria um conjunto de dados para o gráfico de pizza
      DefaultPieDataset dataset = new DefaultPieDataset();
      int totalPedidos = 0;
      try {
         while (rs.next()) {
            String status = rs.getString("status");
            int qtd = rs.getInt("qtd");
            totalPedidos += qtd;
            dataset.setValue(status, qtd);
         }
      } catch (SQLException ex) {
         System.out.println("Erro ao recuperar os dados da tabela: " + ex.getMessage());
         return;
      }
      
      // Cria o gráfico de pizza usando o conjunto de dados
      JFreeChart pieChart = ChartFactory.createPieChart(
         "Gráfico de pizza 3D com dados da tabela 'tb_lista_pedidos'", // título do gráfico
         dataset, // conjunto de dados
         true, // inclui legenda
         true, // inclui tooltips
         false // não inclui URLs
      );
      
      // Configura o gráfico de pizza
      PiePlot3D plot = (PiePlot3D) pieChart.getPlot();
      plot.setStartAngle(290);
      plot.setDirection(Rotation.CLOCKWISE);
      plot.setForegroundAlpha(0.5f);
      plot.setNoDataMessage("Nenhum dado disponível");
      plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} - {1} ({2})"));
      
      // Cria uma janela para exibir o gráfico
      ChartFrame frame = new ChartFrame("Gráfico de pizza 3D com dados da tabela 'tb_lista_pedidos'", pieChart);
      frame.setVisible(true);
      frame.setSize(600, 400);
      
      // Exibe o total de pedidos
      System.out.println("Total de pedidos: " + totalPedidos);
      
      // Fecha as conexões com o banco de dados
      try {
         rs.close();
         stmt.close();
         conexao.close();
      } catch (SQLException ex) {
         System.out.println("Erro ao fechar as conexões com o banco de dados: " + ex.getMessage());
      }
   }
}
