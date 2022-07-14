package hotelaria.DAO;

import hotelaria.Estadia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEstadia extends DAO {

    public ArrayList<Estadia> carregarEstadia() {
        ArrayList<Estadia> estadia = new ArrayList<>();

        try {

            String sql = "select * from estadia";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Estadia Estadia = new Estadia();
                Estadia.setId(rs.getInt("id"));
                Estadia.setData_inicio(rs.getDate("data_inicio"));
                Estadia.setData_termino(rs.getDate("data_termino"));

                estadia.add(Estadia);

            }
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return estadia;

    }

    public Estadia carregarEstadiaId(int idEstadia) {
        Estadia estadia = null;

        try {

            String sql = "select * from estadia"
                    + " where estadia.id = " + idEstadia;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                estadia = new Estadia();
                estadia.setId(rs.getInt("id"));
                estadia.setData_inicio(rs.getDate("data_inicio"));
                estadia.setData_termino(rs.getDate("data_termino"));

            }
        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
        return estadia;

    }

    public boolean salvar(Estadia estadia) {
        try {
            String sql = "INSERT INTO public.estadia(\n"
                    + "	id, data_inicio, data_termino)\n"
                    + "	VALUES (?, ?, ?)";
            PreparedStatement ps = criarPrepareStatement(sql);
            estadia.setId(gerarProximoId("estadia"));
            ps.setInt(1, estadia.getId());
            ps.setDate(2, new java.sql.Date(estadia.getData_inicio().getTime()));
            ps.setDate(3, new java.sql.Date(estadia.getData_termino().getTime()));

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("falha ao salvar estadia\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Estadia estadia) {
        try {
            String sql = "UPDATE public.estadia\n"
                    + "	SET data_inicio=?, data_termino=?\n"
                    + "	WHERE  id = " + estadia.getId();

            PreparedStatement ps = criarPrepareStatement(sql);
            ps.setDate(1, new java.sql.Date(estadia.getData_inicio().getTime()));
            ps.setDate(2, new java.sql.Date(estadia.getData_termino().getTime()));

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao editar estadia\n" + e.getMessage());

        }
        return false;
    }

    public boolean remover(Estadia estadia) {
        try {
            String sql = "DELETE FROM public.estadia\n"
                    + "	WHERE id=" + estadia.getId();
            executarSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao deletar estadia\n" + e.getMessage());
            return false;
        }
    }

}
