
package hotelaria.lista;

import hotelaria.Controle.ControleQuartos;
import hotelaria.Quartos;
import hotelaria.visao.quartos;
import javax.swing.JOptionPane;


public class listaQuartos extends javax.swing.JFrame {

    private ControleQuartos controle;

    public listaQuartos() {
        controle = new ControleQuartos();
        initComponents();

        setLocationRelativeTo(null);
        inicializarcomponentesTela();
    }

    private void inicializarcomponentesTela() {
        jTablelista.setModel(controle.gerarTableModel());
    }

    public void atualizarTabela() {
        jTablelista.setModel(controle.gerarTableModel());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablelista = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonCadastroNovo = new javax.swing.JButton();
        jButtoneditar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTablelista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablelista);

        jLabel1.setText("Cadastro Quartos");

        jButtonCadastroNovo.setText("cadastro novo");
        jButtonCadastroNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroNovoActionPerformed(evt);
            }
        });

        jButtoneditar.setText("Editar");
        jButtoneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoneditarActionPerformed(evt);
            }
        });

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(303, 303, 303))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtoneditar)
                    .addComponent(jButtonRemover)
                    .addComponent(jButtonCadastroNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButtonCadastroNovo)
                        .addGap(34, 34, 34)
                        .addComponent(jButtoneditar)
                        .addGap(36, 36, 36)
                        .addComponent(jButtonRemover)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastroNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroNovoActionPerformed
        quartos tela = new quartos(this  );
        tela.setVisible(true);
    }//GEN-LAST:event_jButtonCadastroNovoActionPerformed

    private void jButtoneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoneditarActionPerformed
        int linha = jTablelista.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "selecione um quarto para editar", "selecionar quartos", JOptionPane.WARNING_MESSAGE);
        } else {
            int idQuartos = controle.getListaquartos().get(linha).getId();
            quartos telaCadastro = new quartos(this, idQuartos);
            telaCadastro.setVisible(true);
        }
    }//GEN-LAST:event_jButtoneditarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        int linha = jTablelista.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "selecione um quarto para remove-lo", "selecionar quartos", JOptionPane.WARNING_MESSAGE);
        } else {
            Quartos cli = controle.getListaquartos().get(linha);
            int opcao = JOptionPane.showConfirmDialog(null,
                "Voce tem certeza que deseja remover o quarto ? " + cli.getTipo(),
                "Corfirmar Remoçao", JOptionPane.YES_NO_CANCEL_OPTION);
            if (opcao == 0 && controle.remover(cli)) {
                atualizarTabela();
            }
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastroNovo;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtoneditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablelista;
    // End of variables declaration//GEN-END:variables
}
