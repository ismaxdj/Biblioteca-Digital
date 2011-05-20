/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIInformacionDocumento.java
 *
 * Created on 15/05/2011, 05:08:13 PM
 */
package biblioteca.gui;

import biblioteca.database2.beans.Documento;
import biblioteca.database2.controladores.ControladorDocumento;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class GUIInformacionDocumento extends javax.swing.JFrame {
    private String documento_id;
    private Documento documento;
    private ControladorDocumento controlador;
    biblioteca.gui.GUIResultados parent;
    /** Creates new form GUIInformacionDocumento */
    public GUIInformacionDocumento(biblioteca.gui.GUIResultados parent, String documento_id) {
        this.documento_id=documento_id;
        this.parent=parent;
        this.setLocationRelativeTo(parent);
        controlador  = new ControladorDocumento();
        initComponents();
        inicializarDocumento();
        this.setResizable(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    private void inicializarDocumento(){
        this.documento=controlador.usuarioConsultaDocumento(documento_id, biblioteca.Main.BibliotecaDigital.LOGGED_USER);
        this.Titulo_Principal.setText(documento.getTituloPrincipal());
        this.ID.setText(documento.getID_documento());
        this.Titulo_Secundario.setText(documento.getTituloSecundario());
        this.Editorial.setText(documento.getEditorial());
        this.Fecha_Publicacion.setText(documento.getFechaPublicacion());
        this.Fecha_Catalogacion.setText(documento.getFechaCatalogacion().substring(0, 10));
        this.Idioma.setText(documento.getIdioma());
        this.Derechos_Autor.setText(documento.getDerechosAutor());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Titulo_Principal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Titulo_Secundario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Editorial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Fecha_Publicacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Fecha_Catalogacion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Idioma = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Derechos_Autor = new javax.swing.JTextField();
        Descargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel4.setText("Información Avanzada de documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Identificación: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        ID.setEditable(false);
        ID.setMinimumSize(new java.awt.Dimension(130, 22));
        ID.setPreferredSize(new java.awt.Dimension(130, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        getContentPane().add(ID, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Titulo: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        Titulo_Principal.setEditable(false);
        Titulo_Principal.setPreferredSize(new java.awt.Dimension(150, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        getContentPane().add(Titulo_Principal, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText("Titulo Secundario: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        Titulo_Secundario.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(Titulo_Secundario, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText("Editorial: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(jLabel6, gridBagConstraints);

        Editorial.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(Editorial, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setText("Fec. Public: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 0);
        getContentPane().add(jLabel7, gridBagConstraints);

        Fecha_Publicacion.setEditable(false);
        Fecha_Publicacion.setPreferredSize(new java.awt.Dimension(50, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(Fecha_Publicacion, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Fec. Catalog: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        getContentPane().add(jLabel8, gridBagConstraints);

        Fecha_Catalogacion.setEditable(false);
        Fecha_Catalogacion.setPreferredSize(new java.awt.Dimension(50, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(Fecha_Catalogacion, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel9.setText("Idioma: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(jLabel9, gridBagConstraints);

        Idioma.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(Idioma, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel10.setText("Derechos de Autor: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        getContentPane().add(jLabel10, gridBagConstraints);

        Derechos_Autor.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(Derechos_Autor, gridBagConstraints);

        Descargar.setText("Descargar Documento");
        Descargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescargarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(Descargar, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescargarActionPerformed
        if(!biblioteca.Main.BibliotecaDigital.LOGGED_USER.equals("dummyuser")){
            controlador.usuarioDescargaDocumento(documento_id, biblioteca.Main.BibliotecaDigital.LOGGED_USER);
            JFileChooser JFC= new JFileChooser();
            JFC.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            JFC.showSaveDialog(this);
            try{
                //guardar archivo
                FileInputStream fileInput = new FileInputStream(documento.getUbicacion());
                StringTokenizer stk = new StringTokenizer(documento.getUbicacion(), ".");
                stk.nextToken();
                BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
                /// Se abre el fichero donde se hará la copia
                File newFile = JFC.getSelectedFile();
                if(!newFile.exists()){
                    newFile.createNewFile();
                }
                String newFilePath=newFile.getAbsolutePath()+"/"+documento.getTituloPrincipal()+"."+stk.nextToken();
                FileOutputStream fileOutput = new FileOutputStream (newFilePath);
                BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
                // Bucle para leer de un fichero y escribir en el otro.
                byte [] array = new byte[1000];
                int leidos = bufferedInput.read(array);
                while (leidos > 0){
                    bufferedOutput.write(array,0,leidos);
                    leidos=bufferedInput.read(array);
                }
                // Cierre de los ficheros
                bufferedInput.close();
                bufferedOutput.close();
                JOptionPane.showMessageDialog(this, "El documento ha sido guardado en "+newFilePath, "Notificación", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(IOException ioe){
                System.err.println(ioe);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Debe ser un usuario registrado para descargar este documento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DescargarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Derechos_Autor;
    private javax.swing.JButton Descargar;
    private javax.swing.JTextField Editorial;
    private javax.swing.JTextField Fecha_Catalogacion;
    private javax.swing.JTextField Fecha_Publicacion;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField Idioma;
    private javax.swing.JTextField Titulo_Principal;
    private javax.swing.JTextField Titulo_Secundario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
