package hotelaria.Controle;

import hotelaria.DAO.DaoFuncionario;
import hotelaria.DAO.DaoQuartos;
import hotelaria.DAO.DaoServico;
import hotelaria.Funcionario;
import hotelaria.Quartos;
import hotelaria.Servico;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ControleServico {
    
    private Servico servico;
    private ArrayList<Servico> listaservico;
    private ArrayList<Quartos> listaquarto;
    private ArrayList<Funcionario> listafuncionario;
    private DaoServico dao;
    private DaoQuartos daoq;  
    private DaoFuncionario daof;
    private boolean editarCadastro = false;
    private boolean removerCadastro = false;
    

    public ControleServico() {
        servico = new Servico();
        dao = new DaoServico();
        daoq = new DaoQuartos();    
        daof = new DaoFuncionario();
        listaservico = new ArrayList<>();       
        listaquarto = daoq.carregarQuartos();
        listafuncionario = daof.carregarFuncionario();
    }    

    

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public void setEditarCadastro(boolean editarCadastro) {
        this.editarCadastro = editarCadastro;
    }

    public void carregarServico(int idservico){
        servico = dao.carregarServicoId(idservico);
    }

    public ArrayList<Servico> getListaservico() {
        return listaservico;
    }
    
    
    public boolean salvar() {
        if(this.editarCadastro == true){
            return dao.atualizar(servico);
        }else {
            return dao.salvar(servico);
        }
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
    
    public ArrayList<Funcionario> getListafuncionario() {
        return listafuncionario;
    }
    
    public String[] getNomeFuncionario(){
        String [] cliente = new String[listafuncionario.size()];
        for (int i = 0; i < listafuncionario.size(); i++) {
            cliente[i] = listafuncionario.get(i).getNome();     
        }
        return cliente;
    }
    public boolean remover(Servico servico) {
        return dao.remover(servico);       
    }
    
    public void carregarServico() {
        listaservico = dao.carregarServico();
    }
    
    public DefaultTableModel gerarTableModel(){
        carregarServico();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("tipo");
        model.addColumn("valor");
        for (int i = 0; i < listaservico.size(); i++) {
            Servico cli = listaservico.get(i);
            Object[] dados = {
                cli.getId(),
                cli.getTipo(),
                cli.getValor()
                
                
            };
            model.addRow(dados);
            
        }
        return model;
    }
    
}
