package hotelaria.DAO;
import hotelaria.Quartos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DaoQuartos extends DAO {

    public ArrayList<Quartos> carregarQuartos() {
        ArrayList<Quartos> quartos = new ArrayList<>();

        try {

            String sql = "select * from quartos";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Quartos Quartos = new Quartos();
                Quartos.setId(rs.getInt("id"));
                Quartos.setTipo(rs.getString("tipo"));
                Quartos.setValor(rs.getString("valor"));
                Quartos.setOcupados(rs.getString("ocupados"));
                Quartos.setN_camas(rs.getString("n_camas"));

                quartos.add(Quartos);

            }
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return quartos;

    }

    public Quartos carregarQuartosId(int idQuartos) {
        Quartos quartos = null;

        try {

            String sql = "select * from quartos"
                    + " where quartos.id = " + idQuartos;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                quartos = new Quartos();
                quartos.setId(rs.getInt("id"));
                quartos.setTipo(rs.getString("tipo"));
                quartos.setOcupados(rs.getString("ocupados"));
                quartos.setN_camas(rs.getString("n_camas"));
                quartos.setValor(rs.getString("valor"));

            }
        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
        return quartos;

    }

    public boolean salvar(Quartos quartos) {
        try {
            String sql = "INSERT INTO public.quartos(\n"
                    + "	id, tipo, ocupados, n_camas, valor)\n"
                    + "	VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = criarPrepareStatement(sql);
            quartos.setId(gerarProximoId("cliente"));
            ps.setInt(1, quartos.getId());
            ps.setString(2, quartos.getTipo());
            ps.setString(3, quartos.getOcupados());
            ps.setString(4, quartos.getN_camas());
            ps.setString(5, quartos.getValor());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("falha ao salvar quartos\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Quartos quartos) {
        try {
            String sql = "UPDATE public.quartos\n"
                    + "	SET  tipo=?, ocupados=?, n_camas=?, valor=?, fk_estadia_id=?\n"
                    + "	WHERE id = " + quartos.getId();

            PreparedStatement ps = criarPrepareStatement(sql);
            ps.setString(1, quartos.getTipo());
            ps.setString(2, quartos.getOcupados());
            ps.setString(3, quartos.getN_camas());
            ps.setString(4, quartos.getValor());
            
           

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao editar quartos\n" + e.getMessage());

        }
        return false;
    }

    public boolean remover(Quartos quartos) {
        try {
            String sql = "DELETE FROM public.quartos\n"
                    + "	WHERE id=" + quartos.getId();
            executarSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao deletar funcionario\n" + e.getMessage());
            return false;
        }
    }

}
