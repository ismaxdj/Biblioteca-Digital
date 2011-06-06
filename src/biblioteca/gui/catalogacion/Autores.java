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
 * GUICAT_Autores.java
 *
 * Created on 7/05/2011, 04:50:06 PM
 */
package biblioteca.gui.catalogacion;


import biblioteca.database2.beans.Autor;
import biblioteca.database2.beans.Documento;
import biblioteca.database2.controladores.ControladorAutor;
import biblioteca.gui.LimitadorDejTextField;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author alejandro
 */
public class Autores extends javax.swing.JPanel {
    Documento documento;
    private ArrayList<Autor> autoresExistentes;
    public static ArrayList<Autor> autoresSeleccionados;
    /** Creates new form GUICAT_Autores */
    public Autores(Documento documento) {
        initComponents();
        this.documento=documento;
        autoresSeleccionados = new ArrayList<Autor>();
        biblioteca.gui.GUICatalogacion.Autores_Guardado=false;
        initAuthorComboBox();
    }
    
    private void initAuthorComboBox(){
        Autores.removeAllItems();
        autoresExistentes = new ControladorAutor().obtenerTodosLosAutores();
        if(!(autoresExistentes==null)){
            for(int i=0;i<autoresExistentes.size();i++){
                Autores.insertItemAt(autoresExistentes.get(i), i);
            }        
            Autores.setSelectedIndex(-1);
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Autores = new javax.swing.JComboBox();
        Agregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Cancelar = new javax.swing.JButton();
        Autor_Correo = new javax.swing.JTextField();
        Autor_Nombre = new javax.swing.JTextField();
        Autor_Apellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Autor_Acronimo = new javax.swing.JTextField();
        Estado = new javax.swing.JLabel();
        Siguiente = new javax.swing.JButton();
        Agregar_Autor = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Autores_Agregados = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel1.setText("Autores Existentes: ");

        setLayout(new java.awt.GridBagLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel4.setText("Autores");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 18;
        add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 527;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(Autores, gridBagConstraints);

        Agregar.setText("Agregar Autor al Documento");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(Agregar, gridBagConstraints);

        jSeparator1.setMinimumSize(new java.awt.Dimension(150, 6));
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.ipadx = 426;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jSeparator1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel2.setText("Agregar un Nuevo Autor: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel2, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("Autores Agregados: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel5, gridBagConstraints);

        jLabel6.setText("Correo Electronico: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(jLabel6, gridBagConstraints);

        jLabel7.setText("Nombre(s): ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(jLabel7, gridBagConstraints);

        jLabel8.setText("Apellido(s): ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(jLabel8, gridBagConstraints);

        Cancelar.setText("Cancelar Operación");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(Cancelar, gridBagConstraints);

        LimitadorDejTextField Autor_CorreoL=new LimitadorDejTextField(40);
        Autor_Correo.setDocument(Autor_CorreoL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 405;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(Autor_Correo, gridBagConstraints);

        LimitadorDejTextField Autor_NombreL=new LimitadorDejTextField(30);
        Autor_Nombre.setDocument(Autor_NombreL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 405;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(Autor_Nombre, gridBagConstraints);

        LimitadorDejTextField Autor_ApellidoL=new LimitadorDejTextField(30);
        Autor_Apellido.setDocument(Autor_ApellidoL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 405;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(Autor_Apellido, gridBagConstraints);

        jLabel9.setText("Acronimo: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(jLabel9, gridBagConstraints);

        LimitadorDejTextField Autor_AcronimoL=new LimitadorDejTextField(6);
        Autor_Acronimo.setDocument(Autor_AcronimoL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 405;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(Autor_Acronimo, gridBagConstraints);

        Estado.setFont(new java.awt.Font("Ubuntu", 0, 24));
        Estado.setForeground(new java.awt.Color(255, 0, 0));
        Estado.setText("[Sin Guardar]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 12, 10, 0);
        add(Estado, gridBagConstraints);

        Siguiente.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        Siguiente.setText("Siguiente Paso");
        Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        add(Siguiente, gridBagConstraints);

        Agregar_Autor.setText("Agregar Autor");
        Agregar_Autor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_AutorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(Agregar_Autor, gridBagConstraints);

        jSeparator2.setMinimumSize(new java.awt.Dimension(150, 6));
        jSeparator2.setPreferredSize(new java.awt.Dimension(200, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.ipadx = 426;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jSeparator2, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel10.setText("Autores Existentes: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jLabel10, gridBagConstraints);

        Autores_Agregados.setColumns(20);
        Autores_Agregados.setRows(5);
        Autores_Agregados.setMinimumSize(new java.awt.Dimension(200, 200));
        Autores_Agregados.setPreferredSize(new java.awt.Dimension(300, 500));
        jScrollPane1.setViewportView(Autores_Agregados);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 350;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jScrollPane1, gridBagConstraints);

        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        add(jLabel18, gridBagConstraints);

        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        add(jLabel19, gridBagConstraints);

        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        add(jLabel20, gridBagConstraints);

        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        add(jLabel21, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        if(!autoresSeleccionados.contains((Autor)Autores.getSelectedItem())){
            autoresSeleccionados.add((Autor)Autores.getSelectedItem());
            refreshAutoresSeleccionados();
            biblioteca.gui.GUICatalogacion.Autores_Guardado=false;
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteActionPerformed
        if(!autoresSeleccionados.isEmpty()){
            biblioteca.gui.GUICatalogacion.Autores_Guardado=true;
            Estado.setForeground(Color.green);
            Estado.setText("[Guardado]");
            JTabbedPane parent =(JTabbedPane) this.getParent();
            parent.setSelectedIndex(2);
            Autores.setEnabled(false);
            Agregar.setEnabled(false);
        }
        else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar almenos un autor", "Error", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_SiguienteActionPerformed

    private void Agregar_AutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_AutorActionPerformed
        if(checkEmptyFieldsAuthor()){
            if(new ControladorAutor().insertarAutor(Autor_Nombre.getText(), Autor_Apellido.getText(), Autor_Correo.getText().toLowerCase(), Autor_Acronimo.getText())!=-1){
                JOptionPane.showMessageDialog(this, "El autor con correo "+Autor_Correo.getText()+ " ha sido agregado", "Notificación", JOptionPane.INFORMATION_MESSAGE);
                Autor_Correo.setText("");
                Autor_Apellido.setText("");
                Autor_Acronimo.setText("");
                Autor_Nombre.setText("");
                initAuthorComboBox();
            }
            else{
                JOptionPane.showMessageDialog(this, "El autor con correo "+Autor_Correo.getText()+ " ya existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_Agregar_AutorActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        autoresSeleccionados.clear();
        refreshAutoresSeleccionados();
        biblioteca.gui.GUICatalogacion.Autores_Guardado=false;
        Estado.setForeground(Color.red);
        Estado.setText("[Sin Guardar]");
        Autores.setEnabled(true);
        Agregar.setEnabled(true);
    }//GEN-LAST:event_CancelarActionPerformed

    private boolean checkEmptyFieldsAuthor(){
        if(Autor_Correo.getText()==null || Autor_Correo.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Autor Correo no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(Autor_Nombre.getText()==null || Autor_Nombre.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Autor_Nombre no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(Autor_Apellido.getText()==null || Autor_Apellido.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Autor_Apellido no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(Autor_Acronimo.getText()==null || Autor_Acronimo.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Autor_Acronimo no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else return true;
    }    
    
    private void refreshAutoresSeleccionados(){
        String nuevoTexto="";
        for(int i=0;i<autoresSeleccionados.size();i++){
            nuevoTexto+=autoresSeleccionados.get(i).toString();
            if(i!=(autoresSeleccionados.size()-1))
                nuevoTexto+="\n";
        }
        Autores_Agregados.setText(nuevoTexto);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Agregar_Autor;
    private javax.swing.JTextField Autor_Acronimo;
    private javax.swing.JTextField Autor_Apellido;
    private javax.swing.JTextField Autor_Correo;
    private javax.swing.JTextField Autor_Nombre;
    private javax.swing.JComboBox Autores;
    private javax.swing.JTextArea Autores_Agregados;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Estado;
    private javax.swing.JButton Siguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
