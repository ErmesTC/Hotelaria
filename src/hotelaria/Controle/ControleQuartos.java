
package hotelaria.Controle;

import hotelaria.Cliente;
import hotelaria.DAO.DaoCliente;
import hotelaria.DAO.DaoQuartos;
import hotelaria.Quartos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ControleQuartos {
    private Quartos quartos;
    private ArrayList<Quartos> listaquartos;
    private ArrayList<Cliente> listacliente;
    private DaoQuartos dao;
    private DaoCliente daoc;
    private boolean editarCadastro = false;
    private boolean removerCadastro = false;
    

    public ControleQuartos() {
        quartos = new Quartos();
        dao = new DaoQuartos(); 
        daoc = new DaoCliente();
        listaquartos = new ArrayList<>();
        listacliente = daoc.carregarCliente();
        
    }    

    

    public Quartos getQuartos() {
        return quartos;
    }

    public void setQuartos(Quartos quartos) {
        this.quartos = quartos;
    }

    public void setEditarCadastro(boolean editarCadastro) {
        this.editarCadastro = editarCadastro;
    }

    public void carregarQuartos(int idquartos){
        quartos = dao.carregarQuartosId(idquartos);
    }

    public ArrayList<Quartos> getListaquartos() {
        return listaquartos;
    }
    
    
    public boolean salvar() {
        if(this.editarCadastro == true){
            return dao.atualizar(quartos);
        }else {
            return dao.salvar(quartos);
        }
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
    
    public boolean remover(Quartos quartos) {
        return dao.remover(quartos);       
    }
    
    public void carregarQuartos() {
        listaquartos = dao.carregarQuartos();
    }
    
    public DefaultTableModel gerarTableModel(){
        carregarQuartos();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Número");
        model.addColumn("Número de Camas");
        model.addColumn("Status");
        for (int i = 0; i < listaquartos.size(); i++) {
            Quartos cli = listaquartos.get(i);
            Object[] dados = {
                cli.getNumero(),
                cli.getN_camas(),
                cli.getOcupados()
                
            };
            model.addRow(dados);
            
        }
        return model;
    }
    
}
