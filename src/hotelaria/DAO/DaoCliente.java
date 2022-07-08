
package hotelaria.DAO;

import hotelaria.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoCliente extends DAO {

    public DaoCliente() {

    }

    public ArrayList<Cliente> carregarCliente() {
        ArrayList<Cliente> cliente = new ArrayList<>();

        try {

            String sql = "select * from cliente";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Cliente Cliente = new Cliente();
                Cliente.setId(rs.getInt("id"));
                Cliente.setCpf(rs.getString("cpf"));
                Cliente.setNome(rs.getString("nome"));
                Cliente.setRg(rs.getString("rg"));
                Cliente.setTelefone(rs.getString("telefone"));
                Cliente.setData_nasc(rs.getDate("data_nasc"));

                cliente.add(Cliente);

            }
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return cliente;

    }

    public Cliente carregarClienteId(int idCliente) {
        Cliente cliente = null;

        try {

            String sql = "select * from cliente"
                    + " where cliente.id = " + idCliente;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setRg(rs.getString("rg"));
                cliente.setTelefone(rs.getString("email"));
                cliente.setData_nasc(rs.getDate("data_nasc"));

            }
        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
        return cliente;

    }

    public boolean salvar(Cliente cliente) {
        try {
            String sql = "INSERT INTO public.cliente(\n"
                    + " id, nome, cpf,  rg, telefone, data_nasc)\n"
                    + "	VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = criarPrepareStatement(sql);
            cliente.setId(gerarProximoId("cliente"));
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getRg());
            ps.setString(5, cliente.getTelefone());
            ps.setDate(6, new java.sql.Date(cliente.getData_nasc().getTime()));

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("falha ao salvar Cliente\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Cliente cliente) {
        try {
            String sql = "UPDATE public.cliente\n"
                    + "	SET nome=?, cpf=?, rg=?, telefone=?, data_nasc=?\n"
                    + "	WHERE id = " + cliente.getId();

            PreparedStatement ps = criarPrepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getRg());
            ps.setString(4, cliente.getTelefone());
            ps.setDate(5, new java.sql.Date(cliente.getData_nasc().getTime()));

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao editar cliente\n" + e.getMessage());

        }
        return false;
    }

    public boolean remover(Cliente cliente) {
        try {
            String sql = "DELETE FROM public.cliente\n"
                    + "	WHERE id=" + cliente.getId();
            executarSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao deletar cliente\n" + e.getMessage());
            return false;
        }
    }
}
