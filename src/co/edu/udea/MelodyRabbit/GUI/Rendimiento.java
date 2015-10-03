/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.MelodyRabbit.GUI;

/**
 *
 * @author jeison.triana
 */
public class Rendimiento extends javax.swing.JPanel {

    /**
     * Creates new form Puntaje
     */
    public Rendimiento() {
        initComponents();
        this.setOpaque(false);
    }
    
    public void setPuntaje(int p){
        puntaje.setText(Integer.toString(p));
    }
    
    public void setCombo(int c){
        combo.setText(Integer.toString(c)+"X");
    }
    
    public void setMalas(int m){
        malas.setText(Integer.toString(m));
    }
    
    public void setNivel(int m){
        nivel.setText(Integer.toString(m));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNivel = new javax.swing.JLabel();
        lblPuntaje = new javax.swing.JLabel();
        puntaje = new javax.swing.JLabel();
        lblPuntaje1 = new javax.swing.JLabel();
        combo = new javax.swing.JLabel();
        lblPuntaje2 = new javax.swing.JLabel();
        malas = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(250, 80));

        lblNivel.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        lblNivel.setForeground(new java.awt.Color(254, 254, 254));
        lblNivel.setText("Nivel:");

        lblPuntaje.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        lblPuntaje.setForeground(new java.awt.Color(254, 254, 254));
        lblPuntaje.setText("Puntaje:");

        puntaje.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        puntaje.setForeground(new java.awt.Color(254, 254, 254));
        puntaje.setText("100");

        lblPuntaje1.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        lblPuntaje1.setForeground(new java.awt.Color(254, 254, 254));
        lblPuntaje1.setText("Malas:");

        combo.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        combo.setForeground(new java.awt.Color(254, 254, 254));
        combo.setText("0");

        lblPuntaje2.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        lblPuntaje2.setForeground(new java.awt.Color(254, 254, 254));
        lblPuntaje2.setText("Combo:");

        malas.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        malas.setForeground(new java.awt.Color(254, 254, 254));
        malas.setText("0");

        nivel.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        nivel.setForeground(new java.awt.Color(254, 254, 254));
        nivel.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPuntaje)
                    .addComponent(lblPuntaje2)
                    .addComponent(lblPuntaje1)
                    .addComponent(lblNivel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(malas)
                    .addComponent(combo)
                    .addComponent(nivel)
                    .addComponent(puntaje))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNivel)
                    .addComponent(nivel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPuntaje)
                    .addComponent(puntaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo)
                    .addComponent(lblPuntaje2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPuntaje1)
                    .addComponent(malas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel combo;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JLabel lblPuntaje1;
    private javax.swing.JLabel lblPuntaje2;
    private javax.swing.JLabel malas;
    private javax.swing.JLabel nivel;
    private javax.swing.JLabel puntaje;
    // End of variables declaration//GEN-END:variables
}