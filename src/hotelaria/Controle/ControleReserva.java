
package hotelaria.Controle;

import hotelaria.Cliente;
import hotelaria.DAO.DaoCliente;
import hotelaria.DAO.DaoQuartos;
import hotelaria.DAO.DaoReserva;
import hotelaria.Estadia;
import hotelaria.Quartos;
import hotelaria.Reserva;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ControleReserva {
    
    private Reserva reserva;
    private ArrayList<Reserva> listareserva;
    private ArrayList<Cliente> listacliente;
    private ArrayList<Quartos> listaquarto;
    private DaoReserva dao;
    private DaoCliente daoc;
    private DaoQuartos daoq;
    private boolean editarCadastro = false;
    private boolean removerCadastro = false;
    

    public ControleReserva() {
        reserva = new Reserva();
        dao = new DaoReserva(); 
        daoc = new DaoCliente();
        daoq = new DaoQuartos();
        listareserva = new ArrayList<>();
        listacliente = daoc.carregarCliente();
        listaquarto = daoq.carregarQuartos();
    }    

    

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setEditarCadastro(boolean editarCadastro) {
        this.editarCadastro = editarCadastro;
    }

    public void carregarReserva(int idreserva){
        reserva = dao.carregarReservaId(idreserva);
    }

    public ArrayList<Reserva> getListareserva() {
        return listareserva;
    }
    
    public ArrayList<Cliente> getListacliente() {
        return listacliente;        
    }
    
    public String[] getNomeCliente(){
        String [] cliente = new String[listacliente.size()];
        for (int i = 0; i < listacliente.size(); i++) {
            cliente[i] = listacliente.get(i).getNome();     
        }
        return cliente;
    }
    
     public ArrayList<Quartos> getListaquartos() {
        return listaquarto;
    }
    
    public String[] getTipoQuarto(){
        String [] cliente = new String[listaquarto.size()];
        for (int i = 0; i < listaquarto.size(); i++) {
            cliente[i] = listaquarto.get(i).getNumero();     
        }
        return cliente;
    }
    
    public boolean salvar() {
        if(this.editarCadastro == true){
            return dao.atualizar(reserva);
        }else {
            return dao.salvar(reserva);
        }
    }
    
    
    public boolean remover(Reserva reserva) {
        return dao.remover(reserva);       
    }
    
    public void carregarReserva() {
        listareserva = dao.carregarReserva();
    }
    
    public DefaultTableModel gerarTableModel(){
        carregarReserva();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("nome");
        for (int i = 0; i < listareserva.size(); i++) {
            Reserva cli = listareserva.get(i);
            Object[] dados = {
                cli.getId(),
                cli.getCliente().getNome()
                
            };
            model.addRow(dados);
            
        }
        return model;
    }
    
}
