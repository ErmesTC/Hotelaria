package hotelaria.DAO;

import hotelaria.Quartos;
import hotelaria.Servico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoServico extends DAO {

    private DaoQuartos daoquarto;
    private DaoFuncionario daof;

    public ArrayList<Servico> carregarServico() {
        ArrayList<Servico> servico = new ArrayList<>();

        try {

            String sql = "SELECT * FROM public.servico "
                    + " left join funcionario as fun on fun.id = servico.funcionario_id "
                    + " left join quartos as qt on qt.id = servico.quartos_id ";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Servico Servico = new Servico();
                Servico.setId(rs.getInt("id"));
                Servico.setTipo(rs.getString("tipo"));
                Servico.setValor(rs.getString("valor"));
                Servico.setDescricao(rs.getString("descricao"));
                if (rs.getObject("quartos_id", Integer.class) != null) {
                    Servico.getQuartos().setId(rs.getInt("cliente_id"));
                    Servico.getQuartos().setTipo(rs.getString("tipo"));
                    Servico.getQuartos().setOcupados(rs.getString("ocupados"));
                    Servico.getQuartos().setN_camas(rs.getString("n_camas"));
                    Servico.getQuartos().setValor(rs.getString("valor"));
                    Servico.getQuartos().setNumero(rs.getString("numeros"));
                }
                if (rs.getObject("funcionario_id", Integer.class) != null) {
                    Servico.getFuncionario().setId(rs.getInt("cliente_id"));
                    Servico.getFuncionario().setNome(rs.getString("nome"));
                    Servico.getFuncionario().setCpf(rs.getString("cpf"));
                    Servico.getFuncionario().setRg(rs.getString("rg"));
                    Servico.getFuncionario().setCargo(rs.getString("cargo"));
                    Servico.getFuncionario().setData_nasc(rs.getDate("data_nasc"));
                    Servico.getFuncionario().setCtps(rs.getString("ctps"));
                    Servico.getFuncionario().setTelefone(rs.getString("telefone"));

                }

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

            String sql = "SELECT * FROM public.servico \n"
                    + "left join funcionario as fun on fun.id = servico.funcionario_id \n"
                    + "left join quartos as qt on qt.id = servico.quartos_id "
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
            if (servico.getQuartos() != null && servico.getQuartos().getId() == null || servico.getQuartos().getId() == 0) {
                daoquarto.salvar(servico.getQuartos());

                if (servico.getQuartos() != null) {
                    ps.setInt(5, servico.getQuartos().getId());
                }
            } else {
                ps.setObject(5, null);
            }
        
            if (servico.getFuncionario() != null && servico.getFuncionario().getId() == null || servico.getFuncionario().getId() == 0) {
                daof.salvar(servico.getFuncionario());

                if (servico.getQuartos() != null) {
                    ps.setInt(6, servico.getFuncionario().getId());
                }
            } else {
                ps.setObject(6, null);
            }

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
            if (servico.getQuartos() != null) {
                if (servico.getQuartos().getId() != null) {
                    daoquarto.atualizar(servico.getQuartos());
                } else {
                    daoquarto.salvar(servico.getQuartos());
                }
                ps.setInt(4, servico.getQuartos().getId());
            } else {
                ps.setObject(4, null);
            }
            if (servico.getFuncionario() != null) {
                if (servico.getFuncionario().getId() != null) {
                    daof.atualizar(servico.getFuncionario());
                } else {
                    daof.salvar(servico.getFuncionario());
                }
                ps.setInt(5, servico.getFuncionario().getId());
            } else {
                ps.setObject(5, null);
            }

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
