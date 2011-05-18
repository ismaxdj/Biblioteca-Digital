/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Selecc_Areas.java
 *
 * Created on 7/05/2011, 08:16:46 PM
 */
package biblioteca.gui.modificacion;

import biblioteca.database2.beans.Area;
import biblioteca.database2.controladores.ControladorArea;
import biblioteca.database2.controladores.ControladorDocumento;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author alejandro
 */
public class Selecc_Areas extends javax.swing.JPanel {
    ArrayList<Area> areasExistentes;
    static public ArrayList<Area> areasSeleccionadas;
    /** Creates new form Selecc_Areas */
    public Selecc_Areas() {
        initComponents();
        areasSeleccionadas=new ArrayList<Area>();
        initComboBox();
    }
    
    public void inicializarDocumento(){
        ArrayList<Area> areaDoc = new ControladorDocumento().obtenerAreas(biblioteca.gui.GUIModificacionDocumento.documento.getID_documento());
        for(int i=0;i<areaDoc.size();i++){
            areasSeleccionadas.add(areaDoc.get(i));
        }
        new ControladorDocumento().eliminarAreas(biblioteca.gui.GUIModificacionDocumento.documento.getID_documento(), areaDoc);
        refreshAreas();
    }
    
    private void initComboBox(){
        Areas.removeAllItems();
        Area_Padre.removeAllItems();
        areasExistentes= new ControladorArea().consultarTodasLasAreas();
        if(areasExistentes!=null){
            for(int i=0;i<areasExistentes.size();i++){
                if(i!=0)
                    Areas.insertItemAt(areasExistentes.get(i).toString(), i-1);
                Area_Padre.insertItemAt(areasExistentes.get(i).toString(), i);
            }
            Areas.setSelectedIndex(-1);
            Area_Padre.setSelectedIndex(-1);
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

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Areas = new javax.swing.JComboBox();
        Cancelar = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Area_Nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Area_Descripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Area_Padre = new javax.swing.JComboBox();
        Siguiente = new javax.swing.JButton();
        Estado = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Agregar_Area = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Areas_Agregadas = new javax.swing.JTextArea();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel4.setText("Áreas de Interés");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel5.setText("Áreas Existentes: ");

        Cancelar.setText("Cancelar Operación");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Agregar.setText("Agregar Área al Documento");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        jSeparator1.setMinimumSize(new java.awt.Dimension(150, 6));
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel2.setText("Agregar una Nueva Área: ");

        jLabel6.setText("Nombre: ");

        jLabel1.setText("Descripción: ");

        jLabel7.setText("Área Padre: ");

        Siguiente.setFont(new java.awt.Font("Ubuntu", 1, 15));
        Siguiente.setText("Siguiente Paso");
        Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteActionPerformed(evt);
            }
        });

        Estado.setFont(new java.awt.Font("Ubuntu", 0, 24));
        Estado.setForeground(new java.awt.Color(255, 0, 0));
        Estado.setText("[Sin Guardar]");

        jSeparator2.setMinimumSize(new java.awt.Dimension(150, 6));
        jSeparator2.setPreferredSize(new java.awt.Dimension(200, 10));

        Agregar_Area.setText("Agregar Área de Interes");
        Agregar_Area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_AreaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel8.setText("Áreas Agregadas: ");

        Areas_Agregadas.setColumns(20);
        Areas_Agregadas.setRows(5);
        Areas_Agregadas.setMinimumSize(new java.awt.Dimension(200, 200));
        Areas_Agregadas.setPreferredSize(new java.awt.Dimension(300, 500));
        jScrollPane1.setViewportView(Areas_Agregadas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jLabel4))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(Agregar_Area))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Estado)
                        .addGap(311, 311, 311)
                        .addComponent(Siguiente))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(260, 260, 260)
                        .addComponent(Cancelar))
                    .addComponent(Areas, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(203, 203, 203)
                        .addComponent(Agregar)))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel6)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Area_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Area_Descripcion, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Area_Padre, javax.swing.GroupLayout.Alignment.LEADING, 0, 406, Short.MAX_VALUE)))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5))
                    .addComponent(Cancelar))
                .addGap(10, 10, 10)
                .addComponent(Areas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Agregar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(Area_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Area_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7))
                    .addComponent(Area_Padre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(Agregar_Area)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Estado)
                    .addComponent(Siguiente))
                .addGap(13, 13, 13))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        if(Areas.getSelectedIndex()!=-1){
            if(!areasSeleccionadas.contains(areasExistentes.get(Areas.getSelectedIndex()))){
                areasSeleccionadas.add(areasExistentes.get(Areas.getSelectedIndex()+1));
            }
        }
        refreshAreas();
}//GEN-LAST:event_AgregarActionPerformed

    private void refreshAreas(){
        String texto="";
        for(int i=0;i<areasSeleccionadas.size();i++){
            texto+=areasSeleccionadas.get(i).toString()+"\n";
        }
        Areas_Agregadas.setText(texto);
    }
    
    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteActionPerformed
        if(!areasSeleccionadas.isEmpty()){
            Estado.setForeground(Color.green);
            Estado.setText("[Guardado]");
            JTabbedPane parent =(JTabbedPane) this.getParent();
            parent.setSelectedIndex(3);
            Cancelar.setEnabled(true);
            Agregar.setEnabled(false);
            Areas.setEnabled(false);
            Areas.setSelectedIndex(-1);
            biblioteca.gui.GUIModificacionDocumento.Areas_Guardadas=true;
        }
        else JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un area", "Error", JOptionPane.ERROR_MESSAGE);
        
        
}//GEN-LAST:event_SiguienteActionPerformed

    private void Agregar_AreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_AreaActionPerformed
        if(checkEmptyFieldsArea()){
            System.out.println(areasExistentes.get(Area_Padre.getSelectedIndex()).getID());
            new ControladorArea().insertarArea(Area_Descripcion.getText(), Area_Nombre.getText(), areasExistentes.get(Area_Padre.getSelectedIndex()).getID());
            JOptionPane.showMessageDialog(this, "El el area con nombre "+Area_Nombre.getText()+ " ha sido agregado", "Notificación", JOptionPane.INFORMATION_MESSAGE);
            Area_Nombre.setText("");
            Area_Descripcion.setText("");
            Area_Padre.setSelectedIndex(-1);
            Areas.setSelectedIndex(-1);
            initComboBox();
        }
    }//GEN-LAST:event_Agregar_AreaActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        biblioteca.gui.GUIModificacionDocumento.Areas_Guardadas=false;
        Cancelar.setEnabled(false);
        Agregar.setEnabled(true);
        Areas.setEnabled(true);
        areasSeleccionadas.clear();
        refreshAreas();
        Estado.setForeground(Color.red);
        Estado.setText("[Sin Guardar]");
    }//GEN-LAST:event_CancelarActionPerformed

    private boolean checkEmptyFieldsArea(){
        if(Area_Nombre.getText()==null || Area_Nombre.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Area Nombre no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(Area_Descripcion.getText()==null || Area_Descripcion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Area Descripcion no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(Area_Padre.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(this, "El campo Area Padre no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Agregar_Area;
    private javax.swing.JTextField Area_Descripcion;
    private javax.swing.JTextField Area_Nombre;
    private javax.swing.JComboBox Area_Padre;
    private javax.swing.JComboBox Areas;
    private javax.swing.JTextArea Areas_Agregadas;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Estado;
    private javax.swing.JButton Siguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
