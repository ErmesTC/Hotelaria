
package hotelaria.Controle;

import hotelaria.DAO.DaoReserva;
import hotelaria.Reserva;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ControleReserva {
    
    private Reserva reserva;
    private ArrayList<Reserva> listareserva;
    private DaoReserva dao;
    private boolean editarCadastro = false;
    private boolean removerCadastro = false;
    

    public ControleReserva() {
        reserva = new Reserva();
        dao = new DaoReserva();        
        listareserva = new ArrayList<>();
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
        model.addColumn("valor");
        for (int i = 0; i < listareserva.size(); i++) {
            Reserva cli = listareserva.get(i);
            Object[] dados = {
                cli.getId(),
                cli.getValor()
                
            };
            model.addRow(dados);
            
        }
        return model;
    }
    
}
