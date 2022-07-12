package hotelaria.DAO;

import hotelaria.Quartos;
import hotelaria.Servico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoServico extends DAO {

    public ArrayList<Servico> carregarServico() {
        ArrayList<Servico> servico = new ArrayList<>();

        try {

            String sql = "select * from servico";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Servico Servico = new Servico();
                Servico.setId(rs.getInt("id"));
                Servico.setTipo(rs.getString("tipo"));
                Servico.setValor(rs.getString("valor"));
                Servico.setDescricao(rs.getString("descricao"));
                Servico.getQuartos().setId(rs.getInt("quartos_id"));
                Servico.getFuncionario().setId(rs.getInt("funcionario_id"));

                servico.add(Servico);

            }
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return servico;

    }

    public Servico carregarServicoId(int idServico) {
        Servico servico = null;

        try {

            String sql = "select * from servico"
                    + " where servico.id = " + idServico;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                servico = new Servico();
                servico.setId(rs.getInt("id"));
                servico.setTipo(rs.getString("tipo"));
                servico.setValor(rs.getString("valor"));
                servico.setDescricao(rs.getString("descricao"));
                servico.getQuartos().setId(rs.getInt("quartos_id"));
                servico.getFuncionario().setId(rs.getInt("funcionario_id"));

            }
        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
        return servico;

    }

    public boolean salvar(Servico servico) {
        try {
            String sql = "INSERT INTO public.servico(\n"
                    + "	id, tipo, valor, descricao, quartos_id, funcionario_id)\n"
                    + "	VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = criarPrepareStatement(sql);
            servico.setId(gerarProximoId("servico"));
            ps.setInt(1, servico.getId());
            ps.setString(2, servico.getTipo());
            ps.setString(3, servico.getValor());
            ps.setString(4, servico.getDescricao());
            ps.setInt(5, servico.getQuartos().getId());
            ps.setInt(6, servico.getFuncionario().getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("falha ao salvar servico\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Servico servico) {
        try {
            String sql = "UPDATE public.servico\n"
                    + "	SET id=?, tipo=?, valor=?, descricao=?, quartos_id=?, funcionario_id=?\n"
                    + "	WHERE  id = " + servico.getId();

            PreparedStatement ps = criarPrepareStatement(sql);
            ps.setString(1, servico.getTipo());
            ps.setString(2, servico.getValor());
            ps.setString(3, servico.getDescricao());
            ps.setInt(4, servico.getQuartos().getId());
            ps.setInt(5, servico.getFuncionario().getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao editar servico\n" + e.getMessage());

        }
        return false;
    }

    public boolean remover(Servico servico) {
        try {
            String sql = "DELETE FROM public.servico\n"
                    + "	WHERE id=" + servico.getId();
            executarSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao deletar servico\n" + e.getMessage());
            return false;
        }
    }


    }
