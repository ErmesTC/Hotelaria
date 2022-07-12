
package hotelaria.Controle;

import hotelaria.Cliente;
import hotelaria.DAO.DaoCliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ControleCliente {
    private Cliente cliente;
    private ArrayList<Cliente> listacliente;
    private DaoCliente dao;
    private boolean editarCadastro = false;
    private boolean removerCadastro = false;
    

    public ControleCliente() {
        cliente = new Cliente();
        dao = new DaoCliente();
        listacliente = new ArrayList<>();
    }    

    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEditarCadastro(boolean editarCadastro) {
        this.editarCadastro = editarCadastro;
    }

    public void carregarCliente(int idcliente){
        cliente = dao.carregarClienteId(idcliente);
    }

    public ArrayList<Cliente> getListacliente() {
        return listacliente;
    }
    
    
    public boolean salvar() {
        if(this.editarCadastro == true){
            return dao.atualizar(cliente);
        }else {
            return dao.salvar(cliente);
        }
    }
    
    public boolean remover(Cliente cliente) {
        return dao.remover(cliente);       
    }
    
    public void carregarCliente() {
        listacliente = dao.carregarCliente();
    }
    
    public DefaultTableModel gerarTableModel(){
        carregarCliente();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("nome");
        model.addColumn("cpf");
        for (int i = 0; i < listacliente.size(); i++) {
            Cliente cli = listacliente.get(i);
            Object[] dados = {
                cli.getId(),
                cli.getNome(),
                cli.getCpf()
                
            };
            model.addRow(dados);
            
        }
        return model;
    }
    
    
}
