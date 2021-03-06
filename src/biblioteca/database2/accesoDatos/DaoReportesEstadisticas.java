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
package biblioteca.database2.accesoDatos;


import biblioteca.database2.fachada.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoReportesEstadisticas {
    Fachada Fachada;
    static ArrayList<String> NombreTablas;
    
    public DaoReportesEstadisticas(){
        Fachada = new Fachada();
    }
    
    public void printResultSet(ResultSet salida) throws SQLException{
      if(salida==null){
          System.out.print("ResultSet Vacia");
          return;
      }
      ResultSetMetaData rs=salida.getMetaData();
      int Cols=rs.getColumnCount();
      while(salida.next()){
     for(int i=1; i<=Cols;i++){
          System.out.print(salida.getString(i)+"  ");
     }
       System.out.println();
    }
    }
    
    public ResultSet ResultSetConsultarLista(String consultar){
        System.out.println(consultar);
         try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida = sentencia.executeQuery(consultar+";");
            conn.close();
            return salida;
      }        
        catch (SQLException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
         return null;  
     }
    
    public ArrayList<String> getNombreTablas(){
        return NombreTablas;
    }
    ///Para panel usuarios
    //para la lista unida
    public ResultSet ConsultarListaUsuario(String dow, String dom, String month, String year, String[] franja, String[] desde, String[] Hasta, String tipo,
            String genero, String Estado, String area, String vinculo){
      
      String sql_consultar="", inter=" intersect ";
      int cont=0;
      
      sql_consultar+=ConsultarDowUsuarios(dow);
      if(!ConsultarDomUsuarios(dom).isEmpty())  {
          cont++;
      sql_consultar+=ConsultarDomUsuarios(dom);}
      
      if(!ConsultarMonthUsuarios(month).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarMonthUsuarios(month);}
      
      if(!ConsultarYearUsuarios(year).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarYearUsuarios(year);}
      
      if(!ConsultarFranjaUsuarios(franja).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarFranjaUsuarios(franja);}
      
      if(!ConsultarIntervaloUsuarios(desde,Hasta).isEmpty())  {
         if(cont>0)  sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarIntervaloUsuarios(desde,Hasta);}
      
      if(!ConsultarTipoUsuarios(tipo).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarTipoUsuarios(tipo);}
      
      if(!ConsultarVinculoUsuarios(vinculo).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarVinculoUsuarios(vinculo);}
      
       if(!ConsultarGeneroUsuarios(genero).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarGeneroUsuarios(genero);}
       
        if(!ConsultarEstadoUsuarios(Estado).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarEstadoUsuarios(Estado);}
        
        if(!ConsultarAreasUsuarios(area).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarAreasUsuarios(area);}
        
     
      if(cont>0) sql_consultar+=";";
      
      System.out.println(sql_consultar);
      try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida = sentencia.executeQuery(sql_consultar);
            conn.close();
            return salida;
      }        
        catch (SQLException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
      return null;
    }
    
    //para la lista separada
     public ArrayList<ResultSet> ConsultarListaSeparadaUsuario(String dow, String dom, String month, String year, String[] franja, String[] desde, String[] Hasta, String tipo, String genero, String Estado, String area, String vinculo) throws SQLException {
  
      ArrayList<ResultSet> Consultas=new ArrayList<ResultSet>(10);
      NombreTablas=new ArrayList<String>(10);
      String temp=ConsultarDowUsuarios(dow);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Usuarios Registrados por dia de la semana");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarDomUsuarios(dom);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Usuarios Registrados por dia del mes");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarMonthUsuarios(month);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Usuarios Registrados por mes");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarYearUsuarios(year);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Usuarios Registrados por año");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarFranjaUsuarios(franja);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Usuarios Registrados por franja horaria");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarIntervaloUsuarios(desde,Hasta);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Usuarios Registrados por intervalo de tiempo");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarTipoUsuarios(tipo);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Usuarios Registrados por tipo de usuario");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarVinculoUsuarios(vinculo);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Usuarios Registrados por Vinculo con Univalle");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarGeneroUsuarios(genero);
      if(!temp.isEmpty())  {
          NombreTablas.add("Lista de Usuarios Registrados por genero");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarEstadoUsuarios(Estado);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Usuarios Registrados por estado");
          Consultas.add(ResultSetConsultarLista(temp));
      } 
      temp=ConsultarAreasUsuarios(area);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Usuarios Registrados por area");
          Consultas.add(ResultSetConsultarLista(temp));
      }
           
      return Consultas;
    }
     
    
    private String ConsultarDowUsuarios(String dow){
        String consultar="";
        if(dow != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where date_part('dow',fecha_registro)="+dow+" "; }
        return consultar;
    }
    private String ConsultarDomUsuarios(String dom){
        String consultar="";
        if(dom != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where date_part('day',fecha_registro)="+dom+" "; }
        return consultar;
    }
    private String ConsultarMonthUsuarios(String month){
        String consultar="";
        if(month != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where date_part('month',fecha_registro)="+month+" "; }
        return consultar;
    }
    private String ConsultarYearUsuarios(String year){
        String consultar="";
        if(year != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where date_part('year',fecha_registro)="+year+" "; }
        return consultar;
    }
    private String ConsultarTipoUsuarios(String tipo){
        String consultar="";
        if(tipo != null){
            if(tipo.equals("1"))
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where tipo_usuario='3' ";
            else  consultar="Select username, nombres, apellidos, fecha_registro from usuarios where tipo_usuario='2' ";
        }
        return consultar;
    }
    private String ConsultarGeneroUsuarios(String genero){
        String consultar="";
        if(genero != null){
            if(genero.equals("1"))
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where genero='M' ";
            else  consultar="Select username, nombres, apellidos, fecha_registro from usuarios where genero='F' ";
        }
        return consultar;
    }
    private String ConsultarEstadoUsuarios(String Estado){
        String consultar="";
        if(Estado != null){
            if(Estado.equals("1"))
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where activo='t' ";
            else  consultar="Select username, nombres, apellidos, fecha_registro from usuarios where activo='f' ";
        }
        return consultar;
    }
    private String ConsultarFranjaUsuarios(String[] franja){
        String consultar="";
        if(franja != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where date_part('hour',fecha_registro)>="+franja[0]+" and date_part('hour',fecha_registro)<="+franja[1]+" "; }
        return consultar;
    }
    private String ConsultarIntervaloUsuarios(String[] desde, String[] Hasta){
        String consultar="";
        if(desde != null && Hasta != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where fecha_registro between '"+desde[0]+"-"+desde[1]+"-"+desde[2]+"' AND '"
                    +Hasta[0]+"-"+Hasta[1]+"-"+Hasta[2]+"' ";
        }
        return consultar;
    }
    private String ConsultarAreasUsuarios(String id_area){
        String consultar="";
        if(id_area != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios natural join usuario_areas_computacion where area_id='"+id_area+"' ";}
        return consultar;
    }
    
     private String ConsultarVinculoUsuarios(String vinculo){
        String consultar="";
        if(vinculo != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where vinculo_con_univalle='"+vinculo+"' ";
             }
        return consultar;
    }
 //////////////////////////////////////////////////////////////////
    //Para el panel de documentos existentes
    public ResultSet ConsultarListaDocumentosExistentes(String area, String autor, String tipo, String editorial, String idioma, String estado, String[] desde, String[] hasta) {
     String sql_consultar="", inter=" intersect ";
      int cont=0;
      
      if(!ConsultarAreasDocumentosExistentes(area).isEmpty())  {
          cont++;
      sql_consultar+=ConsultarAreasDocumentosExistentes(area);}
           
      if(!ConsultarAutorDocumentosExistentes(autor).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarAutorDocumentosExistentes(autor);}
       
      if(!ConsultarTipoDocumentosExistentes(tipo).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarTipoDocumentosExistentes(tipo);}
       
      if(!ConsultarEditorialDocumentosExistentes(editorial).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarEditorialDocumentosExistentes(editorial);}
      
      if(!ConsultarIdiomaDocumentosExistentes(idioma).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarIdiomaDocumentosExistentes(idioma);}
      
      if(!ConsultarEstadoDocumentosExistentes(estado).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarEstadoDocumentosExistentes(estado);}
     
      
      if(!ConsultarIntervaloDocumentosExistentes(desde,hasta).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarIntervaloDocumentosExistentes(desde,hasta);}
      
      if(cont>0) sql_consultar+=";";
      
      System.out.println(sql_consultar);
      try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida = sentencia.executeQuery(sql_consultar);
            //printResultSet(salida);
            conn.close();
            return salida;
      }        
        catch (SQLException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
       return null;
    }
    
    public ArrayList<ResultSet> ConsultarListaSeparadaDocumentosExistentes(String area, String autor, String tipo, String editorial, String idioma, String estado, String[] desde, String[] hasta) {
      ArrayList<ResultSet> Consultas=new ArrayList<ResultSet>(6); 
      NombreTablas=new ArrayList<String>(6);
      String temp=ConsultarAreasDocumentosExistentes(area);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Existentes por Area");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarAutorDocumentosExistentes(autor);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Existentes por Autor");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarTipoDocumentosExistentes(tipo);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Documentos Existentes por Tipo de Documento");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarEditorialDocumentosExistentes(editorial);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Documentos Existentes por editorial");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarIdiomaDocumentosExistentes(idioma);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Existentes por Idioma");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarEstadoDocumentosExistentes(estado);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Existentes por Estado");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarIntervaloDocumentosExistentes(desde,hasta);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Documentos Existentes por Intervalo");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      return Consultas;
    }
    
    
   private String ConsultarAreasDocumentosExistentes(String id_area){
        String consultar="";
        if(id_area != null){
            consultar="Select doc_id, titulo_principal from documentos natural join documento_areas_computacion where area_id='"+id_area+"' ";}
        return consultar;
    }
   private String ConsultarAutorDocumentosExistentes(String correo){
        String consultar="";
        if(correo != null){
            consultar="Select doc_id, titulo_principal from documentos natural join documento_autor where autor_correo='"+correo+"' ";}
        return consultar;
    }
   private String ConsultarTipoDocumentosExistentes(String tipo){
        String consultar="";
        if(tipo != null){
            consultar="Select doc_id, titulo_principal from documentos where tipo_documento='"+tipo+"' ";}
        return consultar;
    }
   private String ConsultarEditorialDocumentosExistentes(String editorial){
        String consultar="";
        if(editorial != null){
            consultar="Select doc_id, titulo_principal from documentos where editorial ilike '"+editorial+"' ";}
        return consultar;
    }
   private String ConsultarIdiomaDocumentosExistentes(String idioma){
        String consultar="";
        if(idioma != null){
            consultar="Select doc_id, titulo_principal from documentos where idioma='"+idioma+"' ";}
        return consultar;
    }
   private String ConsultarEstadoDocumentosExistentes(String estado){
        String consultar="";
        if(estado != null){
            if(estado.equals("1"))
            consultar="Select doc_id, titulo_principal from documentos where activo='t' ";
            else  consultar="Select doc_id, titulo_principal from documentoswhere activo='f' ";
        }
        return consultar;
    }
   private String ConsultarIntervaloDocumentosExistentes(String[] desde, String[] Hasta){
        String consultar="";
        if(desde != null && Hasta != null){
            consultar="Select doc_id, titulo_principal from documentos where fecha_publicacion between '"+desde[0]+"-"+desde[1]+"-"+desde[2]+"' AND '"
                    +Hasta[0]+"-"+Hasta[1]+"-"+Hasta[2]+"' ";
        }
        return consultar;
    }
   
   //////////////////////////////////////////////////////////////////
   //Para el panel de documentos consultados
   public ResultSet ConsultarListaDocumentosConsultados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] Hasta,String area,String autor,String doc_tipo,String usuario){
       String sql_consultar="", inter=" intersect ";
      int cont=0;
      
      if(!ConsultarDowDocConsultados(dow).isEmpty())  {
          cont++;
      sql_consultar+=ConsultarDowDocConsultados(dow);}
      if(!ConsultarDomDocConsultados(dom).isEmpty())  {
          cont++;
      sql_consultar+=ConsultarDomDocConsultados(dom);}
      
      if(!ConsultarMonthDocConsultados(month).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarMonthDocConsultados(month);}
      
      if(!ConsultarYearDocConsultados(year).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarYearDocConsultados(year);}
      
      if(!ConsultarFranjaDocConsultados(franja).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarFranjaDocConsultados(franja);}
      
      if(!ConsultarIntervaloDocConsultados(desde,Hasta).isEmpty())  {
         if(cont>0)  sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarIntervaloDocConsultados(desde,Hasta);}
      
      if(!ConsultarTipoUserDocConsultados(tipo_usuario).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarTipoUserDocConsultados(tipo_usuario);}
      
      
      if(!ConsultarAreasDocConsultados(area).isEmpty())  {
          cont++;
      sql_consultar+=ConsultarAreasDocConsultados(area);}
           
      if(!ConsultarAutorDocConsultados(autor).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarAutorDocConsultados(autor);}
       
      if(!ConsultarTipoDocConsultados(doc_tipo).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarTipoDocConsultados(doc_tipo);}
      
      if(!ConsultarUsuarioDocConsultados(usuario).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarUsuarioDocConsultados(usuario);}
      
      sql_consultar+=";";
      System.out.println(sql_consultar);
      try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida = sentencia.executeQuery(sql_consultar);
            conn.close();
            return salida;
      }        
        catch (SQLException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
       return null;
   }
   //para las listas separadas panel de documentos consultados
  public ArrayList<ResultSet> ConsultarListaSeparadaDocumentosConsultados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] Hasta,String area,String autor,String doc_tipo,String usuario){
      
      ArrayList<ResultSet> Consultas=new ArrayList<ResultSet>(10); 
      NombreTablas=new ArrayList<String>(10);
      String temp=ConsultarDowDocConsultados(dow);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Documentos Consultados por dia de la ");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarDomDocConsultados(dom);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Consultados por dia del mes");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarMonthDocConsultados(month);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Consultados por mes");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarYearDocConsultados(year);
      if(!temp.isEmpty()) {
         NombreTablas.add("Lista de Documentos Consultados por año");
         Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarFranjaDocConsultados(franja);
      if(!temp.isEmpty()) {
         NombreTablas.add("Lista de Documentos Consultados por franja horaria");
         Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarIntervaloDocConsultados(desde,Hasta);
      if(!temp.isEmpty()){
         NombreTablas.add("Lista de Documentos Consultados por intervalo de tiempo");
         Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarTipoUserDocConsultados(tipo_usuario);
      if(!temp.isEmpty()){
         NombreTablas.add("Lista de Documentos Consultados por tipo de usuario");
         Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarAreasDocConsultados(area);
      if(!temp.isEmpty()){
         NombreTablas.add("Lista de Documentos Consultados por Area");
         Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarAutorDocConsultados(autor);
      if(!temp.isEmpty()){
           NombreTablas.add("Lista de Documentos Consultados por Autor");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarTipoDocConsultados(doc_tipo);
      if(!temp.isEmpty()) {
           NombreTablas.add("Lista de Documentos Consultados por tipo de documento");
           Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarUsuarioDocConsultados(usuario);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Consultados un usuario especifico");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      return Consultas;
   }
  
    private String ConsultarDowDocConsultados(String dow) {
         String consultar="";
        if(dow != null){
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_consulta_documento where date_part('dow',fecha_hora)="+dow+" "; }
        return consultar;
    }
    private String ConsultarDomDocConsultados(String dom) {
        String consultar="";
        if(dom != null){
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_consulta_documento where date_part('day',fecha_hora)="+dom+" "; }
        return consultar;
    }
    private String ConsultarMonthDocConsultados(String month) {
         String consultar="";
        if(month != null){
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_consulta_documento where date_part('month',fecha_hora)="+month+" "; }
        return consultar;
    }
    private String ConsultarYearDocConsultados(String year) {String consultar="";
        if(year != null){
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_consulta_documento where date_part('year',fecha_hora)="+year+" "; }
        return consultar;
    }
    private String ConsultarFranjaDocConsultados(String[] franja) {String consultar="";
        if(franja != null){
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_consulta_documento where date_part('hour',fecha_hora)>="+franja[0]+" and date_part('hour',fecha_hora)<="+franja[1]+" "; }
        return consultar;
    }
    private String ConsultarIntervaloDocConsultados(String[] desde, String[] Hasta) {
           String consultar="";
        if(desde != null && Hasta != null){
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_consulta_documento where fecha_hora between '"+desde[0]+"-"+desde[1]+"-"+desde[2]+"' AND '"
                    +Hasta[0]+"-"+Hasta[1]+"-"+Hasta[2]+"' ";
        }
        return consultar;
    }
    private String ConsultarTipoUserDocConsultados(String tipo) {
       String consultar="";
        if(tipo != null){
            if(tipo.equals("1"))
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_consulta_documento inner join usuarios on "
                    + "usuario_consulta_documento.username=usuarios.username where tipo_usuario='3' ";
            else  consultar="Select doc_id, titulo_principal from documentos natural join usuario_consulta_documento inner join usuarios on "
                    + "usuario_consulta_documento.username=usuarios.username where tipo_usuario='2' ";
        }
        return consultar;
    }
    private String ConsultarAreasDocConsultados(String area) {
      String consultar="";
        if(area != null){
            consultar="Select documentos.doc_id, titulo_principal from documentos natural join usuario_consulta_documento inner join documento_areas_computacion"
                    + " on documentos.doc_id=documento_areas_computacion.doc_id where area_id='"+area+"' ";}
        return consultar;
    }
    private String ConsultarAutorDocConsultados(String correo) {
        String consultar="";
        if(correo != null){
            consultar="Select documentos.doc_id, titulo_principal from documentos natural join usuario_consulta_documento inner join documento_autor"
                    + " on documentos.doc_id=documento_autor.doc_id where autor_correo='"+correo+"' ";}
        return consultar;
    }
    private String ConsultarTipoDocConsultados(String tipo) {
       String consultar="";
        if(tipo != null){
            consultar="Select documentos.doc_id, titulo_principal from documentos natural join usuario_consulta_documento  "
                    + "where tipo_documento='"+tipo+"' ";}
        return consultar;
    }
    private String ConsultarUsuarioDocConsultados(String usuario) {
       String consultar="";
        if(usuario != null)
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_consulta_documento inner join usuarios on "
                    + "usuario_consulta_documento.username=usuarios.username where usuario_consulta_documento.username='"+usuario+"' ";
        return consultar;
    }


    /////////////////////////////////////////////////////////////////////////
    //para el panel de documentos descargados
    public ResultSet ConsultarListaDocumentosDescargados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] Hasta,String area,String autor,String doc_tipo,String usuario){
       String sql_consultar="", inter=" intersect ";
      int cont=0;
      
      if(!ConsultarDowDocDescargados(dow).isEmpty())  {
          cont++;
      sql_consultar+=ConsultarDowDocDescargados(dow);}
      if(!ConsultarDomDocDescargados(dom).isEmpty())  {
          cont++;
      sql_consultar+=ConsultarDomDocDescargados(dom);}
      
      if(!ConsultarMonthDocDescargados(month).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarMonthDocDescargados(month);}
      
      if(!ConsultarYearDocDescargados(year).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarYearDocDescargados(year);}
      
      if(!ConsultarFranjaDocDescargados(franja).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarFranjaDocDescargados(franja);}
      
      if(!ConsultarIntervaloDocDescargados(desde,Hasta).isEmpty())  {
         if(cont>0)  sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarIntervaloDocDescargados(desde,Hasta);}
      
      if(!ConsultarTipoUserDocDescargados(tipo_usuario).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarTipoUserDocDescargados(tipo_usuario);}
      
      
      if(!ConsultarAreasDocDescargados(area).isEmpty())  {
          cont++;
      sql_consultar+=ConsultarAreasDocDescargados(area);}
           
      if(!ConsultarAutorDocDescargados(autor).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarAutorDocDescargados(autor);}
       
      if(!ConsultarTipoDocDescargados(doc_tipo).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarTipoDocDescargados(doc_tipo);}
      
      if(!ConsultarUsuarioDocDescargados(usuario).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarUsuarioDocDescargados(usuario);}
      
      sql_consultar+=";";
      System.out.println(sql_consultar);
      try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida = sentencia.executeQuery(sql_consultar);
            conn.close();
            return salida;
      }        
        catch (SQLException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
       return null;
   }
    //para las listas separadas panel documentos descargados
    public ArrayList<ResultSet> ConsultarListaSeparadaDocumentosDescargados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] Hasta,String area,String autor,String doc_tipo,String usuario){
       
      ArrayList<ResultSet> Consultas=new ArrayList<ResultSet>(11);
      NombreTablas=new ArrayList<String>(11);
      String temp=ConsultarDowDocDescargados(dow);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Descargados por dia de la semana");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarDomDocDescargados(dom);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Descargados por dia del mes");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarMonthDocDescargados(month);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Documentos Descargados por mes");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarYearDocDescargados(year);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Documentos Descargados por año");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarFranjaDocDescargados(franja);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Documentos Descargados por franja horario");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarIntervaloDocDescargados(desde,Hasta);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Documentos Descargados por intervalo de tiempo");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarTipoUserDocDescargados(tipo_usuario);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Documentos Descargados por tipo de usuario");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarAreasDocDescargados(area);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Documentos Descargados por Area");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarAutorDocDescargados(autor);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Documentos Descargados por Autor");
          Consultas.add(ResultSetConsultarLista(temp));
      } 
      temp=ConsultarTipoDocDescargados(doc_tipo);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Descargados por tipo de documento");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarUsuarioDocDescargados(usuario);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Descargados por un Usuario especifico");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      return Consultas;
   }
    
    private String ConsultarDowDocDescargados(String dow) {
         String consultar="";
        if(dow != null){
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_descarga_documento where date_part('dow',fecha_hora)="+dow+" "; }
        return consultar;
    }
    private String ConsultarDomDocDescargados(String dom) {
        String consultar="";
        if(dom != null){
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_descarga_documento where date_part('day',fecha_hora)="+dom+" "; }
        return consultar;
    }
    private String ConsultarMonthDocDescargados(String month) {
         String consultar="";
        if(month != null){
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_descarga_documento where date_part('month',fecha_hora)="+month+" "; }
        return consultar;
    }
    private String ConsultarYearDocDescargados(String year) {String consultar="";
        if(year != null){
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_descarga_documento where date_part('year',fecha_hora)="+year+" "; }
        return consultar;
    }
    private String ConsultarFranjaDocDescargados(String[] franja) {String consultar="";
        if(franja != null){
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_descarga_documento where date_part('hour',fecha_hora)>="+franja[0]+" and date_part('hour',fecha_hora)<="+franja[1]+" "; }
        return consultar;
    }
    private String ConsultarIntervaloDocDescargados(String[] desde, String[] Hasta) {
           String consultar="";
        if(desde != null && Hasta != null){
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_descarga_documento where fecha_hora between '"+desde[0]+"-"+desde[1]+"-"+desde[2]+"' AND '"
                    +Hasta[0]+"-"+Hasta[1]+"-"+Hasta[2]+"' ";
        }
        return consultar;
    }
    private String ConsultarTipoUserDocDescargados(String tipo) {
       String consultar="";
        if(tipo != null){
            if(tipo.equals("1"))
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_descarga_documento inner join usuarios on "
                    + "usuario_descarga_documento.username=usuarios.username where tipo_usuario='3' ";
            else  consultar="Select doc_id, titulo_principal from documentos natural join usuario_descarga_documento inner join usuarios on "
                    + "usuario_descarga_documento.username=usuarios.username where tipo_usuario='2' ";
        }
        return consultar;
    }
    private String ConsultarAreasDocDescargados(String area) {
      String consultar="";
        if(area != null){
            consultar="Select documentos.doc_id, titulo_principal from documentos natural join usuario_descarga_documento inner join documento_areas_computacion"
                    + " on documentos.doc_id=documento_areas_computacion.doc_id where area_id='"+area+"' ";}
        return consultar;
    }
    private String ConsultarAutorDocDescargados(String correo) {
        String consultar="";
        if(correo != null){
            consultar="Select documentos.doc_id, titulo_principal from documentos natural join usuario_descarga_documento inner join documento_autor"
                    + " on documentos.doc_id=documento_autor.doc_id where autor_correo='"+correo+"' ";}
        return consultar;
    }
    private String ConsultarTipoDocDescargados(String tipo) {
       String consultar="";
        if(tipo != null){
            consultar="Select documentos.doc_id, titulo_principal from documentos natural join usuario_descarga_documento  "
                    + "where tipo_documento='"+tipo+"' ";}
        return consultar;
    }
    private String ConsultarUsuarioDocDescargados(String usuario) {
        String consultar="";
        if(usuario != null)
            consultar="Select doc_id, titulo_principal from documentos natural join usuario_descarga_documento inner join usuarios on "
                    + "usuario_descarga_documento.username=usuarios.username where usuario_descarga_documento.username='"+usuario+"' ";
        return consultar;
    }

    
    
    ///PANEL USUARIOS CATALOGADOS
    public ResultSet ConsultarListaDocumentosCatalogados(String dow, String dom, String month, String year, String[] franja, String[] desde, String[] Hasta, String area, String autor, String doc_tipo, String usuario) {
      
       String sql_consultar="", inter=" intersect ";
      int cont=0;
      
      if(!ConsultarDowDocCatalogados(dow).isEmpty())  {
          cont++;
      sql_consultar+=ConsultarDowDocCatalogados(dow);}
      if(!ConsultarDomDocCatalogados(dom).isEmpty())  {
          cont++;
      sql_consultar+=ConsultarDomDocCatalogados(dom);}
      
      if(!ConsultarMonthDocCatalogados(month).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarMonthDocCatalogados(month);}
      
      if(!ConsultarYearDocCatalogados(year).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarYearDocCatalogados(year);}
      
      if(!ConsultarFranjaDocCatalogados(franja).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarFranjaDocCatalogados(franja);}
      
      if(!ConsultarIntervaloDocCatalogados(desde,Hasta).isEmpty())  {
         if(cont>0)  sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarIntervaloDocCatalogados(desde,Hasta);}
      
      if(!ConsultarAreasDocCatalogados(area).isEmpty())  {
          cont++;
      sql_consultar+=ConsultarAreasDocCatalogados(area);}
           
      if(!ConsultarAutorDocCatalogados(autor).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarAutorDocCatalogados(autor);}
       
      if(!ConsultarTipoDocCatalogados(doc_tipo).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarTipoDocCatalogados(doc_tipo);}
      
      if(!ConsultarUsuarioDocCatalogados(usuario).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarUsuarioDocCatalogados(usuario);}
      
      sql_consultar+=";";
      System.out.println(sql_consultar);
      try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida = sentencia.executeQuery(sql_consultar);
            conn.close();
            return salida;
      }        
        catch (SQLException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
       return null;
    }
   
    public  ArrayList<ResultSet> ConsultarListaSeparadaDocumentosCatalogados(String dow, String dom, String month, String year, String[] franja, String[] desde, String[] Hasta, String area, String autor, String doc_tipo, String usuario) {
      ArrayList<ResultSet> Consultas=new ArrayList<ResultSet>(10);
      NombreTablas=new ArrayList<String>(10);
      String temp=ConsultarDowDocCatalogados(dow);
      if(!temp.isEmpty())  {
          NombreTablas.add("Lista de Documentos Catalogados por dia de la semana");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarDomDocCatalogados(dom);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Catalogados por dia del mes");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarMonthDocCatalogados(month);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Catalogados por mes");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarYearDocCatalogados(year);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Documentos Catalogados por año");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarFranjaDocCatalogados(franja);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Catalogados por franja horaria");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarIntervaloDocCatalogados(desde,Hasta);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Catalogados por intervalo de tiempo");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarAreasDocCatalogados(area);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Catalogados por Area");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarAutorDocCatalogados(autor);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Catalogados por Autor");
          Consultas.add(ResultSetConsultarLista(temp));
      }
      temp=ConsultarTipoDocCatalogados(doc_tipo);
      if(!temp.isEmpty()){
          NombreTablas.add("Lista de Documentos Catalogados por tipo de documento");
          Consultas.add(ResultSetConsultarLista(temp));
      } 
      temp=ConsultarUsuarioDocCatalogados(usuario);
      if(!temp.isEmpty()) {
          NombreTablas.add("Lista de Documentos Catalogados por un usuario especifico");
          Consultas.add(ResultSetConsultarLista(temp));
      }
           
      return Consultas;
    }
     
    private String ConsultarDowDocCatalogados(String dow) {
         String consultar="";
        if(dow != null){
            consultar="Select doc_id, titulo_principal from documentos where date_part('dow',fecha_catalogacion)="+dow+" "; }
        return consultar;
    }
    private String ConsultarDomDocCatalogados(String dom) {
        String consultar="";
        if(dom != null){
            consultar="Select doc_id, titulo_principal from documentos where date_part('day',fecha_catalogacion)="+dom+" "; }
        return consultar;
    }
    private String ConsultarMonthDocCatalogados(String month) {
         String consultar="";
        if(month != null){
            consultar="Select doc_id, titulo_principal from documentos where date_part('month',fecha_catalogacion)="+month+" "; }
        return consultar;
    }
    private String ConsultarYearDocCatalogados(String year) {String consultar="";
        if(year != null){
            consultar="Select doc_id, titulo_principal from documentos where date_part('year',fecha_catalogacion)="+year+" "; }
        return consultar;
    }
    private String ConsultarFranjaDocCatalogados(String[] franja) {String consultar="";
        if(franja != null){
            consultar="Select doc_id, titulo_principal from documentos where date_part('hour',fecha_catalogacion)>="+franja[0]+" and date_part('hour',fecha_catalogacion)<="+franja[1]+" "; }
        return consultar;
    }
    private String ConsultarIntervaloDocCatalogados(String[] desde, String[] Hasta) {
           String consultar="";
        if(desde != null && Hasta != null){
            consultar="Select doc_id, titulo_principal from documentos where fecha_catalogacion between '"+desde[0]+"-"+desde[1]+"-"+desde[2]+"' AND '"
                    +Hasta[0]+"-"+Hasta[1]+"-"+Hasta[2]+"' ";
        }
        return consultar;
    }
    private String ConsultarAreasDocCatalogados(String area) {
      String consultar="";
        if(area != null){
            consultar="Select documentos.doc_id, titulo_principal from documentos natural join documento_areas_computacion"
                    + " where area_id='"+area+"' ";}
        return consultar;
    }
    private String ConsultarAutorDocCatalogados(String correo) {
        String consultar="";
        if(correo != null){
            consultar="Select documentos.doc_id, titulo_principal from documentos natural join documento_autor"
                    + " where autor_correo='"+correo+"' ";}
        return consultar;
    }
    private String ConsultarTipoDocCatalogados(String tipo) {
       String consultar="";
        if(tipo != null){
            consultar="Select documentos.doc_id, titulo_principal from documentos "
                    + "where tipo_documento='"+tipo+"' ";}
        return consultar;
    }
    private String ConsultarUsuarioDocCatalogados(String usuario) {
       String consultar="";
        if(usuario != null)
            consultar="Select doc_id, titulo_principal from documentos"
                    + " where catalogador='"+usuario+"' ";
        return consultar;
    }

}