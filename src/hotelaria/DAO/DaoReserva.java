package hotelaria.DAO;

import hotelaria.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoReserva extends DAO {

    private DaoCliente daoc;
    private DaoEstadia daoe;
    private DaoQuartos daoq;

    public DaoReserva() {
        daoc = new DaoCliente();
        daoe = new DaoEstadia();
        daoq = new DaoQuartos();
    }
    
    
    
    public ArrayList<Reserva> carregarReserva() {
        ArrayList<Reserva> reserva = new ArrayList<>();

        try {

            String sql = "select * from reserva"
                    + " left join estadia as est on est.id = reserva.estadia_id "
                    + " left join cliente as cli on cli.id = reserva.cliente_id "
                    + " left join quartos as qt on qt.id = reserva.quartos_id ";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Reserva Reserva = new Reserva();
                Reserva.setId(rs.getInt("id"));
                if (rs.getObject("cliente_id", Integer.class) != null) {
                    Reserva.getCliente().setId(rs.getInt("cliente_id"));                  
                    Reserva.getCliente().setNome(rs.getString("nome"));
                    Reserva.getCliente().setCpf(rs.getString("cpf"));
                    Reserva.getCliente().setRg(rs.getString("rg"));
                    Reserva.getCliente().setTelefone(rs.getString("telefone"));
                    Reserva.getCliente().setData_nasc(rs.getDate("data_nasc"));
                    
                }
                if (rs.getObject("estadia_id", Integer.class) != null) {
                    Reserva.getEstadia().setId(rs.getInt("estadia_id"));
                    Reserva.getEstadia().setData_inicio(rs.getDate("data_inicio"));
                    Reserva.getEstadia().setData_termino(rs.getDate("data_termino"));
                }
                if (rs.getObject("quartos_id", Integer.class) != null) {
                    Reserva.getQuartos().setId(rs.getInt("quartos_id"));
                    Reserva.getQuartos().setTipo(rs.getString("tipo"));
                    Reserva.getQuartos().setOcupados(rs.getString("ocupados"));
                    Reserva.getQuartos().setN_camas(rs.getString("n_camas"));
                    Reserva.getQuartos().setNumero(rs.getString("numeros"));
                    Reserva.getQuartos().setValor(rs.getString("valor"));
                }

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

            String sql = "select * from reserva "
                    + " left join estadia as est on est.id = reserva.estadia_id "
                    + " left join cliente as cli on cli.id = reserva.cliente_id "
                    + " left join quartos as qt on qt.id = reserva.quartos_id "
                    + " where reserva.id = " + idReserva;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                if (rs.getObject("cliente_id", Integer.class) != null) {
                    reserva.getCliente().setId(rs.getInt("cliente_id"));                  
                    reserva.getCliente().setNome(rs.getString("nome"));
                    reserva.getCliente().setCpf(rs.getString("cpf"));
                    reserva.getCliente().setRg(rs.getString("rg"));
                    reserva.getCliente().setTelefone(rs.getString("telefone"));
                    reserva.getCliente().setData_nasc(rs.getDate("data_nasc"));
                    
                }
                if (rs.getObject("estadia_id", Integer.class) != null) {
                    reserva.getEstadia().setId(rs.getInt("estadia_id"));
                    reserva.getEstadia().setData_inicio(rs.getDate("data_inicio"));
                    reserva.getEstadia().setData_termino(rs.getDate("data_termino"));
                }
                if (rs.getObject("quartos_id", Integer.class) != null) {
                    reserva.getQuartos().setId(rs.getInt("quartos_id"));
                    reserva.getQuartos().setTipo(rs.getString("tipo"));
                    reserva.getQuartos().setOcupados(rs.getString("ocupados"));
                    reserva.getQuartos().setN_camas(rs.getString("n_camas"));
                    reserva.getQuartos().setNumero(rs.getString("numeros"));
                    reserva.getQuartos().setValor(rs.getString("valor"));
                }

                
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
        return reserva;

    }

    public boolean salvar(Reserva reserva) {
        try {
            String sql = "INSERT INTO public.reserva(\n"
                    + "	id, estadia_id, cliente_id , quartos_id)\n"
                    + "	VALUES (?, ?, ? ,? )";
            PreparedStatement ps = criarPrepareStatement(sql);
            reserva.setId(gerarProximoId("reserva"));
            ps.setInt(1, reserva.getId());
           if (reserva.getEstadia()!= null && reserva.getEstadia().getId() == null || reserva.getEstadia().getId() == 0) {
                daoe.salvar(reserva.getEstadia());

                if (reserva.getEstadia()!= null) {
                    ps.setInt(2, reserva.getEstadia().getId());
                }
            } else {
                ps.setObject(2, null);
            }
            if (reserva.getCliente()!= null && reserva.getCliente().getId() == null || reserva.getCliente().getId() == 0) {
                daoc.salvar(reserva.getCliente());

                if (reserva.getEstadia()!= null) {
                    ps.setInt(3, reserva.getCliente().getId());
                }
            } else {
                ps.setObject(3, null);
            }
            if (reserva.getQuartos()!= null && reserva.getQuartos().getId() == null || reserva.getQuartos().getId() == 0) {
                daoq.salvar(reserva.getQuartos());

                if (reserva.getEstadia()!= null) {
                    ps.setInt(4, reserva.getCliente().getId());
                }
            } else {
                ps.setObject(4, null);
            }
            

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
                    + "	SET estadia_id=?, cliente_id=?, quartos_id=?\n"
                    + "	WHERE  id = " + reserva.getId();

            PreparedStatement ps = criarPrepareStatement(sql);
            if (reserva.getEstadia()!= null){
                if(reserva.getEstadia().getId() != null){
                    daoe.atualizar(reserva.getEstadia());
                }
                else{
                    daoe.salvar(reserva.getEstadia());
                }
                ps.setInt(1, reserva.getEstadia().getId());
            } else {
                ps.setObject(1, null);
            }
            if (reserva.getCliente()!= null && reserva.getCliente().getId() != null) {
                ps.setInt(2, reserva.getCliente().getId());
            } else {
                ps.setObject(2, null);
            }
            if (reserva.getQuartos()!= null && reserva.getQuartos().getId() != null) {
                ps.setInt(3, reserva.getQuartos().getId());
            } else {
                ps.setObject(3, null);
            }

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
