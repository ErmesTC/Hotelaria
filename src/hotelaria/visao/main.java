
package hotelaria.visao;

import hotelaria.lista.listaCliente;
import hotelaria.lista.listaFuncionario;
import hotelaria.lista.listaQuartos;


public class main extends javax.swing.JFrame {

    private listaFuncionario listafunc;
    private listaCliente listacli;
    private listaQuartos listaqua;
    
    public main() {
        initComponents();
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCliente = new javax.swing.JButton();
        jButtonFuncionario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonQuartos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonCliente.setText("Cliente");
        jButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClienteActionPerformed(evt);
            }
        });

        jButtonFuncionario.setText("funcionario");
        jButtonFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFuncionarioActionPerformed(evt);
            }
        });

        jLabel1.setText("CADASTRO GERAL");

        jButtonQuartos.setText("Quartos");
        jButtonQuartos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuartosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonCliente)
                .addGap(38, 38, 38)
                .addComponent(jButtonFuncionario)
                .addGap(28, 28, 28)
                .addComponent(jButtonQuartos)
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCliente)
                    .addComponent(jButtonFuncionario)
                    .addComponent(jButtonQuartos))
                .addContainerGap(236, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFuncionarioActionPerformed
        listafunc = new listaFuncionario();
        listafunc.setVisible(true);
    }//GEN-LAST:event_jButtonFuncionarioActionPerformed

    private void jButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClienteActionPerformed
        listacli = new listaCliente();
        listacli.setVisible(true);
    }//GEN-LAST:event_jButtonClienteActionPerformed

    private void jButtonQuartosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuartosActionPerformed
        listaqua = new listaQuartos();
        listaqua.setVisible(true);
    }//GEN-LAST:event_jButtonQuartosActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCliente;
    private javax.swing.JButton jButtonFuncionario;
    private javax.swing.JButton jButtonQuartos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}