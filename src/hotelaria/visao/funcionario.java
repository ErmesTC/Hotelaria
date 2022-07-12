
package hotelaria.visao;

import hotelaria.Controle.ControleFuncionario;
import hotelaria.lista.listaFuncionario;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class funcionario extends javax.swing.JFrame {

    private ControleFuncionario controle;
    private listaFuncionario telalistafuncionario;
    
    public funcionario (listaFuncionario telalistafuncionario){
        this.telalistafuncionario = telalistafuncionario;
        controle = new ControleFuncionario();
        initComponents();
    }
    
    public funcionario(listaFuncionario telalistafuncionario, int idFuncionario) {
        this.telalistafuncionario = telalistafuncionario;
        controle = new ControleFuncionario();
        controle.carregarFuncionario(idFuncionario);
        controle.setEditarCadastro(true);
        initComponents();
        setLocationRelativeTo(null);
        setarDados();
    }

    private void setarDados() {
        jTextFieldnome.setText(controle.getFuncionario().getNome());
        jTextFieldcpf.setText(controle.getFuncionario().getCpf());
        jTextFieldrg.setText(controle.getFuncionario().getRg());
        jTextFieldtelefone.setText(controle.getFuncionario().getTelefone());
        jComboBoxdia.setSelectedItem(controle.getFuncionario().getData_nasc());
        jComboBoxmes.setSelectedItem(controle.getFuncionario().getData_nasc());
        jComboBoxano.setSelectedItem(controle.getFuncionario().getData_nasc());
        jTextFieldCargo.setText(controle.getFuncionario().getCargo());
        jTextFieldCtps.setText(controle.getFuncionario().getCtps());
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxano = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        cpf = new javax.swing.JLabel();
        jLabeldata_nasc = new javax.swing.JLabel();
        rg = new javax.swing.JLabel();
        jTextFieldnome = new javax.swing.JTextField();
        butonsave = new javax.swing.JButton();
        jTextFieldcpf = new javax.swing.JTextField();
        telefone = new javax.swing.JLabel();
        jTextFieldrg = new javax.swing.JTextField();
        jTextFieldtelefone = new javax.swing.JTextField();
        jComboBoxdia = new javax.swing.JComboBox<>();
        jComboBoxmes = new javax.swing.JComboBox<>();
        jTextFieldCtps = new javax.swing.JTextField();
        Cargo = new javax.swing.JLabel();
        jTextFieldCargo = new javax.swing.JTextField();
        Ctps = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBoxano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1947", "1948", "1947", "1946", "1943", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901" }));

        jLabel1.setText("Cliente");

        nome.setText("nome");

        cpf.setText("cpf");

        jLabeldata_nasc.setText("data de nascimento");

        rg.setText("rg");

        butonsave.setText("Cadastrar");
        butonsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonsaveActionPerformed(evt);
            }
        });

        telefone.setText("telefone");

        jComboBoxdia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jComboBoxmes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jTextFieldCtps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCtpsActionPerformed(evt);
            }
        });

        Cargo.setText("Cargo");

        Ctps.setText("Ctps");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(267, 267, 267)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabeldata_nasc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxdia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(butonsave)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextFieldnome, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextFieldtelefone)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(rg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextFieldrg)
                                                .addComponent(jTextFieldcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Ctps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(219, 219, 219))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(357, 357, 357)
                                .addComponent(jTextFieldCtps)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldtelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Ctps, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCtps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeldata_nasc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxdia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(butonsave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butonsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonsaveActionPerformed
        try {
            controle.getFuncionario().setNome(jTextFieldnome.getText());
            controle.getFuncionario().setCpf(jTextFieldcpf.getText());
            controle.getFuncionario().setRg(jTextFieldrg.getText());
            controle.getFuncionario().setCargo(jTextFieldCargo.getText());
            controle.getFuncionario().setCtps(jTextFieldCtps.getText());
            Calendar cal = Calendar.getInstance();
            cal.set(2022, 1, 1);
            controle.getFuncionario().setData_nasc(cal.getTime());
            if(controle.salvar()){
                JOptionPane.showMessageDialog(null, "exito em salvar o cadastro\n" , "Erro", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                if(telalistafuncionario != null){
                    telalistafuncionario.atualizarTabela();
                }
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar cliente\n" +e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butonsaveActionPerformed

    private void jTextFieldCtpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCtpsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCtpsActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cargo;
    private javax.swing.JLabel Ctps;
    private javax.swing.JButton butonsave;
    private javax.swing.JLabel cpf;
    private javax.swing.JComboBox<String> jComboBoxano;
    private javax.swing.JComboBox<String> jComboBoxdia;
    private javax.swing.JComboBox<String> jComboBoxmes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabeldata_nasc;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldCtps;
    private javax.swing.JTextField jTextFieldcpf;
    private javax.swing.JTextField jTextFieldnome;
    private javax.swing.JTextField jTextFieldrg;
    private javax.swing.JTextField jTextFieldtelefone;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel rg;
    private javax.swing.JLabel telefone;
    // End of variables declaration//GEN-END:variables
}
