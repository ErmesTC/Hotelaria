package hotelaria.DAO;

import hotelaria.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoFuncionario extends DAO {

    public ArrayList<Funcionario> carregarFuncionario() {
        ArrayList<Funcionario> funcionario = new ArrayList<>();

        try {

            String sql = "select * from cliente";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Funcionario Funcionario = new Funcionario();
                Funcionario.setId(rs.getInt("id"));
                Funcionario.setCpf(rs.getString("cpf"));
                Funcionario.setNome(rs.getString("nome"));
                Funcionario.setRg(rs.getString("rg"));
                Funcionario.setTelefone(rs.getString("telefone"));
                Funcionario.setData_nasc(rs.getDate("data_nasc"));
                Funcionario.setCargo(rs.getString("cargo"));
                Funcionario.setCtps(rs.getString("ctps"));

                funcionario.add(Funcionario);

            }
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return funcionario;

    }

    public Funcionario carregarFuncionarioId(int idFuncionario) {
        Funcionario funcionario = null;

        try {

            String sql = "select * from funcionario"
                    + " where funcionario.id = " + idFuncionario;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setRg(rs.getString("rg"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setData_nasc(rs.getDate("data_nasc"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setCtps(rs.getString("ctps"));

            }
        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
        return funcionario;

    }

    public boolean salvar(Funcionario funcionario) {
        try {
            String sql = "INSERT INTO public.funcionario(\n"
                    + "	id, cargo, ctps, nome, cpf, rg, data_nasc, telefone)\n"
                    + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = criarPrepareStatement(sql);
            funcionario.setId(gerarProximoId("funcionario"));
            ps.setInt(1, funcionario.getId());
            ps.setString(2, funcionario.getCargo());
            ps.setString(3, funcionario.getCtps());
            ps.setString(4, funcionario.getNome());
            ps.setString(5, funcionario.getCpf());
            ps.setString(6, funcionario.getRg());
            ps.setDate(7, new java.sql.Date(funcionario.getData_nasc().getTime()));
            ps.setString(8, funcionario.getTelefone());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("falha ao salvar Cliente\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Funcionario funcionario) {
        try {
            String sql = "UPDATE public.funcionario\n"
                    + "	SET cargo=?, ctps=?, nome=?, cpf=?, rg=?, data_nasc=?, telefone=?\n"
                    + "	WHERE id = " + funcionario.getId();

            PreparedStatement ps = criarPrepareStatement(sql);
            ps.setString(1, funcionario.getCargo());
            ps.setString(2, funcionario.getCtps());
            ps.setString(3, funcionario.getNome());
            ps.setString(4, funcionario.getCpf());
            ps.setString(5, funcionario.getRg());
            ps.setString(6, funcionario.getTelefone());
            ps.setDate(7, new java.sql.Date(funcionario.getData_nasc().getTime()));

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao editar cliente\n" + e.getMessage());

        }
        return false;
    }

    public boolean remover(Funcionario funcionario) {
        try {
            String sql = "DELETE FROM public.funcionario\n"
                    + "	WHERE id=" + funcionario.getId();
            executarSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao deletar funcionario\n" + e.getMessage());
            return false;
        }
    }

}
