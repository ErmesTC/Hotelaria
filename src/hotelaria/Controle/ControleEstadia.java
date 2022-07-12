package hotelaria.Controle;

import hotelaria.DAO.DaoEstadia;
import hotelaria.Estadia;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ControleEstadia {
    private Estadia estadia;
    private ArrayList<Estadia> listaestadia;
    private DaoEstadia dao;
    private boolean editarCadastro = false;
    private boolean removerCadastro = false;
    

    public ControleEstadia() {
        estadia = new Estadia();
        dao = new DaoEstadia();        
        listaestadia = new ArrayList<>();
    }    

    

    public Estadia getEstadia() {
        return estadia;
    }

    public void setEstadia(Estadia estadia) {
        this.estadia = estadia;
    }

    public void setEditarCadastro(boolean editarCadastro) {
        this.editarCadastro = editarCadastro;
    }

    public void carregarEstadia(int idestadia){
        estadia = dao.carregarEstadiaId(idestadia);
    }

    public ArrayList<Estadia> getListaestadia() {
        return listaestadia;
    }
    
    
    public boolean salvar() {
        if(this.editarCadastro == true){
            return dao.atualizar(estadia);
        }else {
            return dao.salvar(estadia);
        }
    }
    
    public boolean remover(Estadia estadia) {
        return dao.remover(estadia);       
    }
    
    public void carregarEstadia() {
        listaestadia = dao.carregarEstadia();
    }
    
    public DefaultTableModel gerarTableModel(){
        carregarEstadia();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("inicio");
        model.addColumn("termino");
        for (int i = 0; i < listaestadia.size(); i++) {
            Estadia cli = listaestadia.get(i);
            Object[] dados = {
                cli.getId(),
                cli.getData_inicio(),
                cli.getData_termino()
                
            };
            model.addRow(dados);
            
        }
        return model;
    }
    
}
