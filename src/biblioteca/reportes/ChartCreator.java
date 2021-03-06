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
package biblioteca.reportes;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
/**
 * Esta clase provee una interfaz entre los resultados de las consultas de la base
 * de datos para los reportes y estadisticas, y el modulo de creación de graficos,
 * JFreeChart, para el manejo de graficos en los reportes
 * 
 * @author Alejandro Valdés Villada
 * @author María Cristina Bustos Rodríguez
 */
public class ChartCreator {
        
    public static DefaultPieDataset asignarPieDataset(ArrayList<String> Valores){
         DefaultPieDataset dataSet = new DefaultPieDataset();
      int size=Valores.size();
      size=(size<=32)? size: 32;
      for(int i=2;i<size;i+=2){
           dataSet.setValue(Valores.get(i), Double.parseDouble(Valores.get(i+1)));
        }
        return dataSet;
    }
   
    public static DefaultCategoryDataset asignarBarDataset(ArrayList<String> Valores){
      DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
      int size=Valores.size();
      size=(size<=32)? size: 32;
      for(int i=2;i<size;i+=2){
           dataSet.setValue(Double.parseDouble(Valores.get(i+1)),"Grafica",Valores.get(i));
        }
        return dataSet;
    }
    
    /*public static DefaultPieDataset DataPieSetConIndices(ArrayList<String> Valores){
      DefaultPieDataset dataSet = new DefaultPieDataset();
      int size=(Valores.size()<=32)? Valores.size() : 32;
      for(int i=2;i<size;i+=2){
           System.out.println(Valores.get(i)+" "+Valores.get(i+1));
           dataSet.setValue((i+1)+"", Double.parseDouble(Valores.get(i+1)));
        }
        return dataSet;
    }
    
    public static DefaultCategoryDataset DataBarSetConIndices(ArrayList<String> Valores){
      DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
      for(int i=2;i<Valores.size();i+=2){
           System.out.println(Valores.get(i)+" "+Valores.get(i+1));
           dataSet.setValue(Double.parseDouble(Valores.get(i+1)),"Grafica",(i+1)+"");
        }
        return dataSet;
    }*/
    
    public static JFreeChart generatePieChart(DefaultPieDataset dataSet, String titulo) {
   
        JFreeChart chart = ChartFactory.createPieChart(
                titulo, dataSet, true, true, false);
 
       /* ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        frame.setVisible(true);*/
        return chart;
        
    }
    
     public static JFreeChart generateBarChart(DefaultCategoryDataset dataSet, String Titulo, String tituloX, String tituloY) {
      
        JFreeChart chart = ChartFactory.createBarChart(
                Titulo, tituloX, tituloY,
                dataSet, PlotOrientation.VERTICAL, false, true, false);
      
        return chart;
    }
    
}
