package hotelaria.DAO;
import hotelaria.Quartos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DaoQuartos extends DAO {
private DaoEstadia daoestadia;
private DaoCliente daocliente;

    public DaoQuartos() {
        daoestadia = new DaoEstadia();
    }


    public ArrayList<Quartos> carregarQuartos() {
        ArrayList<Quartos> Quartos = new ArrayList<>();

        try {

            String sql = "select * from quartos "
                    + " left join estadia as est on est.id = quartos.estadia_id "
                    + " left join cliente as cli on cli.id = quartos.cliente_id ";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Quartos quartos = new Quartos();
                quartos.setId(rs.getInt("id"));
                quartos.setTipo(rs.getString("tipo"));
                quartos.setValor(rs.getString("valor"));
                quartos.setOcupados(rs.getString("ocupados"));
                quartos.setN_camas(rs.getString("n_camas"));
                if (rs.getObject("cliente_id", Integer.class) != null) {
                    quartos.getCliente().setId(rs.getInt("cliente_id"));                  
                    quartos.getCliente().setNome(rs.getString("nome"));
                    quartos.getCliente().setCpf(rs.getString("cpf"));
                    quartos.getCliente().setRg(rs.getString("rg"));
                    quartos.getCliente().setTelefone(rs.getString("telefone"));
                    quartos.getCliente().setData_nasc(rs.getDate("data_nasc"));
                }
                if (rs.getObject("estadia_id", Integer.class) != null) {
                    quartos.getEstadia().setId(rs.getInt("estadia_id"));
                    quartos.getEstadia().setData_inicio(rs.getDate("data_inicio"));
                    quartos.getEstadia().setData_termino(rs.getDate("data_termino"));
                }
                quartos.getReserva().setId(rs.getInt("reserva_id"));
                
                

                Quartos.add(quartos);

            }
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return Quartos;

    }

    public Quartos carregarQuartosId(int idQuartos) {
        Quartos quartos = null;

        try {

            String sql = "select * from quartos"
                    + " left join estadia as est on est.id = quartos.estadia_id "
                    + " left join cliente as cli on cli.id = quartos.cliente_id "
                    + " where quartos.id = " + idQuartos;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                quartos = new Quartos();
                quartos.setId(rs.getInt("id"));
                quartos.setTipo(rs.getString("tipo"));
                quartos.setOcupados(rs.getString("ocupados"));
                quartos.setN_camas(rs.getString("n_camas"));
                quartos.setValor(rs.getString("valor"));
                if (rs.getObject("cliente_id", Integer.class) != null) {
                    quartos.getCliente().setId(rs.getInt("cliente_id"));                  
                    quartos.getCliente().setNome(rs.getString("nome"));
                    quartos.getCliente().setCpf(rs.getString("cpf"));
                    quartos.getCliente().setRg(rs.getString("rg"));
                    quartos.getCliente().setTelefone(rs.getString("telefone"));
                    quartos.getCliente().setData_nasc(rs.getDate("data_nasc"));
                    
                }
                if (rs.getObject("estadia_id", Integer.class) != null) {
                    quartos.getEstadia().setId(rs.getInt("estadia_id"));
                    quartos.getEstadia().setData_inicio(rs.getDate("data_inicio"));
                    quartos.getEstadia().setData_termino(rs.getDate("data_termino"));
                }
                quartos.getReserva().setId(rs.getInt("reserva_id"));

            }
        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
        return quartos;

    }

    public boolean salvar(Quartos quartos) {
        try {
            String sql = "INSERT INTO public.quartos(\n"
                    + "	id, tipo, ocupados, n_camas, valor, estadia_id, cliente_id)\n"
                    + "	VALUES (?, ?, ?, ?, ?, ?, ? )";
            PreparedStatement ps = criarPrepareStatement(sql);
            quartos.setId(gerarProximoId("quartos"));
            ps.setInt(1, quartos.getId());
            ps.setString(2, quartos.getTipo());
            ps.setString(3, quartos.getOcupados());
            ps.setString(4, quartos.getN_camas());
            ps.setString(5, quartos.getValor());
            if (quartos.getEstadia()!= null && quartos.getEstadia().getId() == null || quartos.getEstadia().getId() == 0) {
                daoestadia.salvar(quartos.getEstadia());

                if (quartos.getEstadia()!= null) {
                    ps.setInt(6, quartos.getEstadia().getId());
                }
            } else {
                ps.setObject(6, null);
            }
            if (quartos.getCliente()!= null && quartos.getCliente().getId() == null || quartos.getCliente().getId() == 0) {
                daocliente.salvar(quartos.getCliente());

                if (quartos.getEstadia()!= null) {
                    ps.setInt(7, quartos.getCliente().getId());
                }
            } else {
                ps.setObject(7, null);
            }
            
            //ps.setInt(8, quartos.getReserva().getId());

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
                    + "	SET  tipo=?, ocupados=?, n_camas=?, valor=?, estadia_id=?, cliente_id=?\n"
                    + "	WHERE id = " + quartos.getId();

            PreparedStatement ps = criarPrepareStatement(sql);
            ps.setString(1, quartos.getTipo());
            ps.setString(2, quartos.getOcupados());
            ps.setString(3, quartos.getN_camas());
            ps.setString(4, quartos.getValor());
            if (quartos.getEstadia()!= null){
                if(quartos.getEstadia().getId() != null){
                    daoestadia.atualizar(quartos.getEstadia());
                }
                else{
                    daoestadia.salvar(quartos.getEstadia());
                }
                ps.setInt(5, quartos.getEstadia().getId());
            } else {
                ps.setObject(5, null);
            }
            if (quartos.getCliente()!= null && quartos.getCliente().getId() != null) {
                ps.setInt(6, quartos.getCliente().getId());
            } else {
                ps.setObject(6, null);
            }
            //ps.setInt(7, quartos.getReserva().getId());
            
           

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
            System.out.println("Falha ao deletar quartos\n" + e.getMessage());
            return false;
        }
    }

}
