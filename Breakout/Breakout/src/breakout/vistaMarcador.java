package breakout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class vistaMarcador extends JFrame{
			public static final int ANCHO = 600;
			public static final int ALTO = 800;
		
		private ArrayList<Marcador> lista= new ArrayList<>();
		DefaultTableModel tableModel = new DefaultTableModel();
		Archivo asr = new Archivo();
		
		public vistaMarcador(){


			
			lista = asr.leer();
			JTable  tabla = new JTable();
			String[] columnas = {"Nombre", "Puntuacion"};
			tableModel.setColumnIdentifiers(columnas);
			Object[] fila = new Object[tableModel.getColumnCount()];

			for (int i = 0; i < lista.size(); i++) {

			fila[0] = lista.get(i).nombre;
			fila[1] = lista.get(i).score;

			tableModel.addRow(fila);
			}

			tabla.setModel(tableModel);
			
			getContentPane().add(new JScrollPane(tabla));
			
			this.setTitle("Marcadores del Juego");
			this.setSize(ANCHO, ALTO);
			this.setLocationRelativeTo(null);
			this.getContentPane().setBackground(Color.cyan);
			this.setVisible(true);
		
			
		}

	
}
