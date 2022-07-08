package hotelaria.DAO;

import hotelaria.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoReserva extends DAO {

    public ArrayList<Reserva> carregarReserva() {
        ArrayList<Reserva> reserva = new ArrayList<>();

        try {

            String sql = "select * from reserva";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Reserva Reserva = new Reserva();
                Reserva.setId(rs.getInt("id"));
                Reserva.setValor(rs.getString("valor"));

                reserva.add(Reserva);

            }
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return reserva;

    }

    public Reserva carregarReservaId(int idReserva) {
        Reserva reserva = null;

        try {

            String sql = "select * from reserva"
                    + " where reserva.id = " + idReserva;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setValor(rs.getString("valor"));

            }
        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
        return reserva;

    }

    public boolean salvar(Reserva reserva) {
        try {
            String sql = "INSERT INTO public.reserva(\n"
                    + "	id, valor, cliente_id, estadia_id)\n"
                    + "	VALUES (?, ?, ?, ?)";
            PreparedStatement ps = criarPrepareStatement(sql);
            reserva.setId(gerarProximoId("reserva"));
            ps.setInt(1, reserva.getId());
            ps.setString(2, reserva.getValor());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("falha ao salvar reserva\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Reserva reserva) {
        try {
            String sql = "UPDATE public.reserva\n"
                    + "	SET id=?, valor=?, cliente_id=?, estadia_id=?\n"
                    + "	WHERE  id = " + reserva.getId();

            PreparedStatement ps = criarPrepareStatement(sql);
            ps.setString(1, reserva.getValor());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao editar reserva\n" + e.getMessage());

        }
        return false;
    }

    public boolean remover(Reserva reserva) {
        try {
            String sql = "DELETE FROM public.reserva\n"
                    + "	WHERE id=" + reserva.getId();
            executarSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao deletar reserva\n" + e.getMessage());
            return false;
        }
    }

}
