/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.getupfit;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author jacie_3u2efj7
 */
public class pruebas extends javax.swing.JFrame {
    
    
            public pruebas() {
            initComponents();
            crearGraficaDeEstadosDeAnimo(); // <- Llamada agregada
        }
            
            private void crearGraficaDeEstadosDeAnimo() {
       // Datos de emociones por día de la semana
       String[] emociones = {"neutro", "feliz", "enojado", "triste", "feliz", "neutro", "triste"};

       // Valores asignados a cada emoción
       int valorFeliz = 4;
       int valorEnojado = 3;
       int valorNeutro = 2;
       int valorTriste = 1;

       DefaultCategoryDataset dataset = new DefaultCategoryDataset();

       String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

       for (int i = 0; i < emociones.length; i++) {
           int valor;
           switch (emociones[i].toLowerCase()) {
               case "feliz":
                   valor = valorFeliz;
                   break;
               case "enojado":
                   valor = valorEnojado;
                   break;
               case "neutro":
                   valor = valorNeutro;
                   break;
               case "triste":
                   valor = valorTriste;
                   break;
               default:
                   valor = valorNeutro;
           }
           dataset.addValue(valor, "Estado de Ánimo", dias[i]);
       }

       // Crear gráfica de líneas
       JFreeChart chart = ChartFactory.createLineChart(
               "Estado de Ánimo por Día", // título
               "Día",                      // eje X
               "",                         // eje Y vacío
               dataset);

       // Personalizar la gráfica
       org.jfree.chart.plot.CategoryPlot plot = chart.getCategoryPlot();

       // Quitar números del eje Y
       plot.getRangeAxis().setTickLabelsVisible(false);
       plot.getRangeAxis().setTickMarksVisible(false);
       plot.getRangeAxis().setAxisLineVisible(false);

       // Cambiar color de la línea a azul
       org.jfree.chart.renderer.category.LineAndShapeRenderer renderer =
               (org.jfree.chart.renderer.category.LineAndShapeRenderer) plot.getRenderer();
       renderer.setSeriesPaint(0, new java.awt.Color(0, 102, 204)); // azul medio

       // Crear y agregar el panel
       ChartPanel chartPanel = new ChartPanel(chart);
       chartPanel.setPreferredSize(jPanel1.getSize());

       jPanel1.removeAll();
       jPanel1.setLayout(new java.awt.BorderLayout());
       jPanel1.add(chartPanel, java.awt.BorderLayout.CENTER);
       jPanel1.validate();
       jPanel1.repaint();
   }




    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lineNeedle1 = new org.jfree.chart.needle.LineNeedle();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reloj.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(174, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pruebas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private org.jfree.chart.needle.LineNeedle lineNeedle1;
    // End of variables declaration//GEN-END:variables
}
