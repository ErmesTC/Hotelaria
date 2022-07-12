
package hotelaria.Controle;

import hotelaria.DAO.DaoFuncionario;
import hotelaria.Funcionario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ControleFuncionario {
    

    private Funcionario funcionario;
    private ArrayList<Funcionario> listafuncionario;
    private DaoFuncionario dao;
    private boolean editarCadastro = false;
    private boolean removerCadastro = false;
    

    public ControleFuncionario() {
        funcionario = new Funcionario();
        dao = new DaoFuncionario();        
        listafuncionario = new ArrayList<>();
    }    

    

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setEditarCadastro(boolean editarCadastro) {
        this.editarCadastro = editarCadastro;
    }

    public void carregarFuncionario(int idfuncionario){
        funcionario = dao.carregarFuncionarioId(idfuncionario);
    }

    public ArrayList<Funcionario> getListafuncionario() {
        return listafuncionario;
    }
    
    
    public boolean salvar() {
        if(this.editarCadastro == true){
            return dao.atualizar(funcionario);
        }else {
            return dao.salvar(funcionario);
        }
    }
    
    public boolean remover(Funcionario funcionario) {
        return dao.remover(funcionario);       
    }
    
    public void carregarFuncionario() {
        listafuncionario = dao.carregarFuncionario();
    }
    
    public DefaultTableModel gerarTableModel(){
        carregarFuncionario();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("nome");
        model.addColumn("cpf");
        for (int i = 0; i < listafuncionario.size(); i++) {
            Funcionario cli = listafuncionario.get(i);
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
