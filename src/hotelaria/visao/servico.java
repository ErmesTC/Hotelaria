/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelaria.visao;

import hotelaria.Controle.ControleServico;
import hotelaria.lista.listaServico;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class servico extends javax.swing.JFrame {

    private ControleServico controle;
    private listaServico telalistaquartos;

    public servico(listaServico telalistaservico) {
        this.telalistaquartos = telalistaquartos;
        controle = new ControleServico();
        initComponents();
        inicializarComponentesTela();
    }

    public servico(listaServico telalistaservico, int idServico) {
        this.telalistaquartos = telalistaquartos;
        controle = new ControleServico();
        controle.carregarServico(idServico);
        controle.setEditarCadastro(true);
        initComponents();
        setLocationRelativeTo(null);
        inicializarComponentesTela();
        setarDados();
    }

    private void inicializarComponentesTela() {
        DefaultComboBoxModel<String> model
                = new DefaultComboBoxModel<>(controle.getTipoQuarto());
        jComboBoxQuartos.setModel(model);
    }

    private void setarDados() {
        jTextFieldTipo.setText(controle.getServico().getTipo());
        jTextFieldValor.setText(controle.getServico().getValor());
        jTextFielddescricao.setText(controle.getServico().getDescricao());
        jComboBoxQuartos.setSelectedItem(controle.getServico().getQuartos().getTipo());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cpf = new javax.swing.JLabel();
        jTextFieldTipo = new javax.swing.JTextField();
        jTextFieldValor = new javax.swing.JTextField();
        telefone = new javax.swing.JLabel();
        jTextFielddescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        jComboBoxQuartos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        butonsave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cpf.setText("cpf");

        telefone.setText("telefone");

        jLabel1.setText("Cliente");

        nome.setText("nome");

        jLabel2.setText("Quartos");

        butonsave.setText("Cadastrar");
        butonsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonsaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFielddescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(butonsave)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFielddescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(149, 149, 149)
                .addComponent(butonsave)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butonsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonsaveActionPerformed
        try {
            controle.getServico().setTipo(jTextFieldTipo.getText());
            controle.getServico().setValor(jTextFieldValor.getText());
            controle.getServico().setDescricao(jTextFielddescricao.getText());
            int posicao = jComboBoxQuartos.getSelectedIndex();
            controle.getServico().setQuartos(controle.getListaquartos().get(posicao));
            

            if (controle.salvar()) {
                JOptionPane.showMessageDialog(null, "exito em salvar o cadastro\n", "Erro", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                if (telalistaquartos != null) {
                    telalistaquartos.atualizarTabela();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar servico\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butonsaveActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butonsave;
    private javax.swing.JLabel cpf;
    private javax.swing.JComboBox<String> jComboBoxQuartos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldTipo;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField jTextFielddescricao;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel telefone;
    // End of variables declaration//GEN-END:variables
}
