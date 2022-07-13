
package hotelaria;

import hotelaria.DAO.conexaoBD;
import hotelaria.visao.main;


public class Hotelaria {

    
    public static void main(String[] args) {
       
        conexaoBD.abrirconexao();   
        
        
        main tela = new main();
        tela.setVisible(true);
    }
    
}
