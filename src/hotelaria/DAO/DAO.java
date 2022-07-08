
package hotelaria.DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DAO {
    
    private Connection conexao;
    private Statement statement;
    
    public DAO() {
        conexao = conexaoBD.getConexao();
        try {
            statement = conexao.createStatement();
         
        } catch (SQLException ex){
        JOptionPane.showMessageDialog(null, "Falha ao criar Statement\n" +ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
         
                 }
    }
    
    public ResultSet consultaSQL(String comandoSQL) throws SQLException  {
        ResultSet rs = statement.executeQuery(comandoSQL);
        return rs;
    }
    
    public PreparedStatement criarPrepareStatement (String sql) throws SQLException{
        return conexao.prepareStatement(sql);
    }
    
    public int gerarProximoId(String tabela) {
        try {
            ResultSet rs = consultaSQL("select max(id) from "+tabela);
            if(rs.next()){
                return rs.getInt(1)+1;
            }
        }catch (SQLException ex){
            System.out.println("Falha ao gerar proximo id"+ex.getMessage());
        }
        return -1;
    }
    
    public void executarSql(String sql) throws SQLException{
        Statement st = conexao.createStatement();
        st.executeUpdate(sql);
        st.close();
    }
    
    
}
