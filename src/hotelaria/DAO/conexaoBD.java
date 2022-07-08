package hotelaria.DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class conexaoBD {
    
    private static Connection conexao;
    
    public static void abrirconexao(){
        try {
            String baseDados = "hotelaria";
            String usuario = "postgres";
            String senha = "postgres";
            String url = "jdbc:postgresql://localhost:5432/"+baseDados;
            
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conexao realizada!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao abrir conexao\n" +ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao abrir\n" +ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } 
        
    }
    public static Connection getConexao(){
        if (conexao == null){
            abrirconexao();
        }
        return conexao;
    } 
    
}
