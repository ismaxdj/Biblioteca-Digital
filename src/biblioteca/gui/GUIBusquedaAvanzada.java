/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIBusquedaAvanzada.java
 *
 * Created on 15/05/2011, 04:17:18 PM
 */

package biblioteca.gui;

import biblioteca.database2.beans.Area;
import biblioteca.database2.controladores.ControladorArea;
import biblioteca.database2.controladores.ControladorDocumento;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Cris
 */
public class GUIBusquedaAvanzada extends javax.swing.JFrame {
    biblioteca.gui.GUIBusqueda parent;
    /** Creates new form GUIBusquedaAvanzada */
    public GUIBusquedaAvanzada(biblioteca.gui.GUIBusqueda parent) {
        this.parent=parent;
        initComponents();
        initComboBoxArea();
        this.setLocationRelativeTo(parent);
    }


     private void initComboBoxArea(){
        AreaComboBox.removeAllItems();
        ArrayList<Area> areasExistentes= new ControladorArea().consultarTodasLasAreas();
        if(areasExistentes!=null){
            for(int i=0;i<areasExistentes.size();i++){
                AreaComboBox.insertItemAt(areasExistentes.get(i).toString(), i);
            }
            AreaComboBox.insertItemAt("Cualquiera", 0);
            AreaComboBox.setSelectedIndex(0);
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        titlelabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        TituloLabel = new javax.swing.JLabel();
        AutorLabel = new javax.swing.JLabel();
        PalabraClaveLabel = new javax.swing.JLabel();
        TituloTextField = new javax.swing.JTextField();
        AutorTextField = new javax.swing.JTextField();
        PalabraClaveTextField = new javax.swing.JTextField();
        TituloComboBox = new javax.swing.JComboBox();
        AutorComboBox = new javax.swing.JComboBox();
        PalabraClaveComboBox = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        AreaLabel = new javax.swing.JLabel();
        AreaComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        TipoMaterialComboBox = new javax.swing.JComboBox();
        MaterialLabel = new javax.swing.JLabel();
        IdiomaComboBox = new javax.swing.JComboBox();
        FechaLabel = new javax.swing.JLabel();
        FechaComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        FormatoComboBox = new javax.swing.JComboBox();
        EditorialLabel = new javax.swing.JLabel();
        EditorialTextField = new javax.swing.JTextField();
        BuscarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Búsqueda Avanzada");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N

        titlelabel.setFont(new java.awt.Font("Arial", 1, 24));
        titlelabel.setText("Busqueda Avanzada");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189)
                .addComponent(titlelabel)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(titlelabel)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        TituloLabel.setFont(new java.awt.Font("Arial", 0, 12));
        TituloLabel.setText("Titulo:");

        AutorLabel.setFont(new java.awt.Font("Arial", 0, 12));
        AutorLabel.setText("Autor:");

        PalabraClaveLabel.setFont(new java.awt.Font("Arial", 0, 12));
        PalabraClaveLabel.setText("Palabra Clave:");

        TituloTextField.setFont(new java.awt.Font("Arial", 0, 12));

        AutorTextField.setFont(new java.awt.Font("Arial", 0, 12));

        PalabraClaveTextField.setFont(new java.awt.Font("Arial", 0, 12));

        TituloComboBox.setFont(new java.awt.Font("Arial", 0, 12));
        TituloComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "con todas las palabras", "con la frase exacta", "con alguna de las palabras", "sin las palabras" }));

        AutorComboBox.setFont(new java.awt.Font("Arial", 0, 12));
        AutorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "con todas las palabras", "con la frase exacta", "con alguna de las palabras", "sin las palabras" }));
        AutorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutorComboBoxActionPerformed(evt);
            }
        });

        PalabraClaveComboBox.setFont(new java.awt.Font("Arial", 0, 12));
        PalabraClaveComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "con todas las palabras", "con la frase exacta", "con alguna de las palabras", "sin las palabras" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AutorLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PalabraClaveLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PalabraClaveTextField)
                    .addComponent(AutorTextField)
                    .addComponent(TituloTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AutorComboBox, 0, 210, Short.MAX_VALUE)
                    .addComponent(TituloComboBox, 0, 210, Short.MAX_VALUE)
                    .addComponent(PalabraClaveComboBox, 0, 210, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloLabel)
                    .addComponent(TituloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TituloComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AutorLabel)
                    .addComponent(AutorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PalabraClaveLabel)
                    .addComponent(PalabraClaveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PalabraClaveComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        AreaLabel.setFont(new java.awt.Font("Arial", 0, 12));
        AreaLabel.setText("Area: ");

        AreaComboBox.setFont(new java.awt.Font("Arial", 0, 12));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel6.setText("Idioma:");

        TipoMaterialComboBox.setFont(new java.awt.Font("Arial", 0, 12));
        TipoMaterialComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cualquiera", "Libro", "Articulo", "Memoria", "Tesis de Maestría", "Tesis de Doctorado", "Material de Clase" }));

        MaterialLabel.setFont(new java.awt.Font("Arial", 0, 12));
        MaterialLabel.setText("Tipo de Material: ");

        IdiomaComboBox.setFont(new java.awt.Font("Arial", 0, 12));
        IdiomaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cualquiera", "Español", "Ingles", "Frances", "Aleman", "Japones" }));

        FechaLabel.setFont(new java.awt.Font("Arial", 0, 12));
        FechaLabel.setText("Fecha de Publicación: ");

        FechaComboBox.setFont(new java.awt.Font("Arial", 0, 12));
        FechaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cualquier Fecha", "En el ultimo mes", "Hace 6 meses", "Hace un año", "Hace 2 años", "Hace 5 años" }));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel9.setText("Formato Archivo: ");

        FormatoComboBox.setFont(new java.awt.Font("Arial", 0, 12));
        FormatoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pdf", "doc", "jpg", "odt" }));

        EditorialLabel.setFont(new java.awt.Font("Arial", 0, 12));
        EditorialLabel.setText("Editorial: ");

        EditorialTextField.setFont(new java.awt.Font("Arial", 0, 12));

        BuscarButton.setText("Buscar");
        BuscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(AreaLabel)
                                .addComponent(MaterialLabel)))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(FechaLabel)))
                    .addComponent(EditorialLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(EditorialTextField)
                        .addComponent(AreaComboBox, 0, 430, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(FechaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(TipoMaterialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addComponent(jLabel6)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdiomaComboBox, 0, 147, Short.MAX_VALUE)
                            .addComponent(FormatoComboBox, 0, 147, Short.MAX_VALUE))))
                .addGap(34, 34, 34)
                .addComponent(BuscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AreaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AreaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditorialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditorialLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoMaterialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdiomaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaterialLabel)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaLabel)
                    .addComponent(FechaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FormatoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(BuscarButton))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButtonActionPerformed
        String titulo=TituloTextField.getText();
        String autor=AutorTextField.getText();
        String pc=PalabraClaveTextField.getText();
        int tituloopcion=TituloComboBox.getSelectedIndex();
        int autoropcion=AutorComboBox.getSelectedIndex();
        int pcopcion=PalabraClaveComboBox.getSelectedIndex();
        String area=(String)AreaComboBox.getSelectedItem();
        String editorial=EditorialTextField.getText();
        int tipo_material=TipoMaterialComboBox.getSelectedIndex();
        String idioma=(String)IdiomaComboBox.getSelectedItem();
        int fecha=FechaComboBox.getSelectedIndex();
        String formato=(String)FormatoComboBox.getSelectedItem();
       
       
       ArrayList<String> Titulo=new ArrayList<String>();
       ArrayList<String> Autor=new ArrayList<String>();
       ArrayList<String> PalabraClave=new ArrayList<String>();
       if(tituloopcion==1) Titulo.add(titulo);
       else {
           StringTokenizer titulotokens = new StringTokenizer(titulo, " ");
           while(titulotokens.hasMoreTokens())  Titulo.add(titulotokens.nextToken());
           }
       if(autoropcion==1) Autor.add(autor);
       else {
           StringTokenizer autortokens = new StringTokenizer(autor, " ");
            while(autortokens.hasMoreTokens()) Autor.add(autortokens.nextToken());
           }
       if(pcopcion==1) PalabraClave.add(pc);
       else {
            StringTokenizer palabraclavetokens = new StringTokenizer(pc, " ");
            while(palabraclavetokens.hasMoreTokens()) PalabraClave.add(palabraclavetokens.nextToken());
           }
       
       


       ArrayList<String> resultados = new ControladorDocumento().consultaDocumentoAvanzada( Titulo, Autor,
             PalabraClave,  tituloopcion, autoropcion,  pcopcion, area,
            editorial, tipo_material, idioma, fecha,formato);

       if(!resultados.isEmpty()){
                new GUIResultados(resultados, this).setVisible(true);
                this.setVisible(false);
            }

            else
                JOptionPane.showMessageDialog(this, "La busqueda no ha retornado resultados", "Erorr", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_BuscarButtonActionPerformed



    private void AutorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AutorComboBoxActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AreaComboBox;
    private javax.swing.JLabel AreaLabel;
    private javax.swing.JComboBox AutorComboBox;
    private javax.swing.JLabel AutorLabel;
    private javax.swing.JTextField AutorTextField;
    private javax.swing.JButton BuscarButton;
    private javax.swing.JLabel EditorialLabel;
    private javax.swing.JTextField EditorialTextField;
    private javax.swing.JComboBox FechaComboBox;
    private javax.swing.JLabel FechaLabel;
    private javax.swing.JComboBox FormatoComboBox;
    private javax.swing.JComboBox IdiomaComboBox;
    private javax.swing.JLabel MaterialLabel;
    private javax.swing.JComboBox PalabraClaveComboBox;
    private javax.swing.JLabel PalabraClaveLabel;
    private javax.swing.JTextField PalabraClaveTextField;
    private javax.swing.JComboBox TipoMaterialComboBox;
    private javax.swing.JComboBox TituloComboBox;
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JTextField TituloTextField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel titlelabel;
    // End of variables declaration//GEN-END:variables

}
