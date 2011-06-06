/*
 * This file is part of Biblioteca-Digital de Univalle.
 *
 * Biblioteca-Digital de Univalle is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Biblioteca-Digital de Univalle is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Biblioteca-Digital de Univalle.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

/*
 * Selecc_Pal_Clave.java
 *
 * Created on 7/05/2011, 08:31:41 PM
 */
package biblioteca.gui.modificacion;

import biblioteca.database2.beans.PalabraClave;
import biblioteca.database2.beans.Documento;
import biblioteca.database2.controladores.ControladorDocumento;
import biblioteca.database2.controladores.ControladorPalabraClave;
import biblioteca.gui.LimitadorDejTextField;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author alejandro
 */
public class Selecc_Pal_Clave extends javax.swing.JPanel {
    ArrayList<PalabraClave> palabrasClaveExistentes;
    static public ArrayList<PalabraClave> palabrasClaveSeleccionadas;
    /** Creates new form Selecc_Pal_Clave */
    public Selecc_Pal_Clave() {
        initComponents();
        palabrasClaveSeleccionadas = new ArrayList<PalabraClave>();
        initComboBox();
    }

    public void inicializarDocumento(){
        initComboBox();
        ArrayList<PalabraClave> palabrasDoc = new ControladorDocumento().obtenerPalabrasClave(biblioteca.gui.GUIModificacionDocumento.documento.getID_documento());
        for(int i=0;i<palabrasDoc.size();i++){
            palabrasClaveSeleccionadas.add(palabrasDoc.get(i));
        }
        refreshPalabrasClave();
        new ControladorDocumento().eliminarPalabrasClave(biblioteca.gui.GUIModificacionDocumento.documento.getID_documento(), palabrasDoc);
    }
    
    
    private void initComboBox() {
     Palabras_Clave.removeAllItems();
     palabrasClaveExistentes=null;
     palabrasClaveExistentes=new ControladorPalabraClave().consultarTodasLasPalabrasClaves();
     if(palabrasClaveExistentes!=null){
         for(int i=0;i<palabrasClaveExistentes.size();i++){
             Palabras_Clave.insertItemAt(palabrasClaveExistentes.get(i).getNombre(), i);
         }
         Palabras_Clave.setSelectedIndex(-1);
     }
    }
    
    private void refreshPalabrasClave(){
        String texto="";
        for(int i=0;i<palabrasClaveSeleccionadas.size();i++){
            texto+=palabrasClaveSeleccionadas.get(i).getNombre();
            if(i!=(palabrasClaveSeleccionadas.size()-1)){
                texto+=", ";
            }
        }
        PC_Agregadas.setText(texto);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Palabras_Clave = new javax.swing.JComboBox();
        Cancelar = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PC_Nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        PC_Descripcion = new javax.swing.JTextField();
        Siguiente = new javax.swing.JButton();
        Estado = new javax.swing.JLabel();
        Agregar_Palabra_Clave = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PC_Agregadas = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel4.setText("Palabras Clave");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 16;
        add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel5.setText("Palabras Clave Existentes: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 350;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(Palabras_Clave, gridBagConstraints);

        Cancelar.setText("Cancelar Operación");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(Cancelar, gridBagConstraints);

        Agregar.setText("Agregar Palabra Clave al Documento");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(Agregar, gridBagConstraints);

        jSeparator1.setMinimumSize(new java.awt.Dimension(150, 6));
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 350;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(jSeparator1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel2.setText("Agregar una Nueva Palabra Clave: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel2, gridBagConstraints);

        jLabel6.setText("Nombre: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(jLabel6, gridBagConstraints);

        LimitadorDejTextField PCL=new LimitadorDejTextField(70);
        PC_Nombre.setDocument(PCL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 350;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(PC_Nombre, gridBagConstraints);

        jLabel1.setText("Descripción: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(jLabel1, gridBagConstraints);

        LimitadorDejTextField PC_DescripcionL=new LimitadorDejTextField(200);
        PC_Descripcion.setDocument(PC_DescripcionL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 350;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(PC_Descripcion, gridBagConstraints);

        Siguiente.setFont(new java.awt.Font("Ubuntu", 1, 15));
        Siguiente.setText("Siguiente Paso");
        Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        add(Siguiente, gridBagConstraints);

        Estado.setFont(new java.awt.Font("Ubuntu", 0, 24));
        Estado.setForeground(new java.awt.Color(255, 0, 0));
        Estado.setText("[Sin Guardar]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 12, 10, 0);
        add(Estado, gridBagConstraints);

        Agregar_Palabra_Clave.setText("Agregar Palabra Clave");
        Agregar_Palabra_Clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_Palabra_ClaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(Agregar_Palabra_Clave, gridBagConstraints);

        jSeparator2.setMinimumSize(new java.awt.Dimension(150, 6));
        jSeparator2.setPreferredSize(new java.awt.Dimension(200, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 350;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(jSeparator2, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel7.setText("Palabras Clave Agregadas: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel7, gridBagConstraints);

        PC_Agregadas.setColumns(20);
        PC_Agregadas.setRows(5);
        PC_Agregadas.setMinimumSize(new java.awt.Dimension(200, 200));
        PC_Agregadas.setPreferredSize(new java.awt.Dimension(300, 500));
        jScrollPane1.setViewportView(PC_Agregadas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 350;
        gridBagConstraints.ipady = 75;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jScrollPane1, gridBagConstraints);

        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        add(jLabel20, gridBagConstraints);

        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        add(jLabel21, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        if(Palabras_Clave.getSelectedIndex()!=-1){
            if(!palabrasClaveSeleccionadas.contains(palabrasClaveExistentes.get(Palabras_Clave.getSelectedIndex()))){
                palabrasClaveSeleccionadas.add(palabrasClaveExistentes.get(Palabras_Clave.getSelectedIndex()));
                refreshPalabrasClave();
                biblioteca.gui.GUIModificacionDocumento.Palabras_Clave_Guardadas=false;
            }
        }
}//GEN-LAST:event_AgregarActionPerformed

    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteActionPerformed
        if(!palabrasClaveSeleccionadas.isEmpty()){
            Palabras_Clave.setEnabled(false);
            Palabras_Clave.setSelectedIndex(-1);
            Agregar.setEnabled(false);
            Estado.setForeground(Color.green);
            Estado.setText("[Guardado]");
            JTabbedPane parent =(JTabbedPane) this.getParent();
            parent.setSelectedIndex(4);
            biblioteca.gui.GUIModificacionDocumento.Palabras_Clave_Guardadas=true;
            
        }else JOptionPane.showMessageDialog(this, "Debe seleccionar almenos una palabra clave", "Error", JOptionPane.ERROR_MESSAGE);
}//GEN-LAST:event_SiguienteActionPerformed

    private void Agregar_Palabra_ClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_Palabra_ClaveActionPerformed
        if(checkEmptyFieldsPC()){
            if(new ControladorPalabraClave().InsertarPalabraClave(PC_Nombre.getText().toLowerCase().replaceAll("[']", "`"), PC_Descripcion.getText().replaceAll("[']", "`"))!=-1){
                JOptionPane.showMessageDialog(this, PC_Nombre.getText()+ " ha sido agregada", "Notificaición", JOptionPane.INFORMATION_MESSAGE);
                PC_Nombre.setText("");
                PC_Descripcion.setText("");
                initComboBox();
            }
            else{
                JOptionPane.showMessageDialog(this, PC_Nombre.getText()+ " ya existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_Agregar_Palabra_ClaveActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        palabrasClaveSeleccionadas.clear();
        refreshPalabrasClave();
        biblioteca.gui.GUIModificacionDocumento.Palabras_Clave_Guardadas=false;
        Palabras_Clave.setEnabled(true);
        Agregar.setEnabled(true);
        Estado.setForeground(Color.red);
        Estado.setText("[Sin guardar]");
    }//GEN-LAST:event_CancelarActionPerformed

    private boolean checkEmptyFieldsPC(){
        if(PC_Nombre.getText()==null || PC_Nombre.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Nombre no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(PC_Descripcion.getText()==null || PC_Descripcion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Descripcion no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else return true;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Agregar_Palabra_Clave;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Estado;
    private javax.swing.JTextArea PC_Agregadas;
    private javax.swing.JTextField PC_Descripcion;
    private javax.swing.JTextField PC_Nombre;
    private javax.swing.JComboBox Palabras_Clave;
    private javax.swing.JButton Siguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    
}
