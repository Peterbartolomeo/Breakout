package breakout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class vistaMenu extends JFrame{
	public static final int ANCHO = 600;
	public static final int ALTO = 800;
	JButton botonPrincipiante;
	JButton botonIntermedio;
	JButton botonDificil;
	JButton marcadores;
	DefaultTableModel tableModel = new DefaultTableModel();

	public  vistaMenu() {
		this.getContentPane().setBackground(Color.orange);
		this.setTitle("Break Out Juego");
		this.setSize(ANCHO, ALTO);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		this.setLayout(null); 
		this.botonPrincipiante = new JButton("Principiante");
		botonPrincipiante.setBounds(200, 100, 120, 50);
		this.botonIntermedio = new JButton("Intermedio");
		botonIntermedio.setBounds(200, 200, 120, 50);
		this.botonDificil = new JButton("Dificil");
		botonDificil.setBounds(200, 300, 120, 50);
		this.marcadores = new JButton("Marcadores");
		this.marcadores.setBounds(200, 400, 120, 50);

		botonPrincipiante.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ModeloBreakout model = new ModeloBreakout();
				VistaBreakout  view  = new VistaBreakout();
				new Controlador( model, view );

				model.crearObjetos(30);       
				model.addObserver( view );       

				view.setVisible(true);           
				model.iniciarJuego();              
				dispose();
			}
		});

		botonIntermedio.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ModeloBreakout model = new ModeloBreakout();
				VistaBreakout  view  = new VistaBreakout();
				new Controlador( model, view );

				model.crearObjetos(40);      
				model.addObserver( view );       

				view.setVisible(true);           
				model.iniciarJuego();               
				dispose();
			}
		});

		botonDificil.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ModeloBreakout model = new ModeloBreakout();
				VistaBreakout  view  = new VistaBreakout();
				new Controlador( model, view );

				model.crearObjetos(60);       
				model.addObserver( view );      

				view.setVisible(true);           
				model.iniciarJuego();               

				dispose();

			}
		});
		marcadores.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				vistaMarcador vista = new vistaMarcador();
				



			}
		});
		this.add(botonDificil);
		this.add(botonIntermedio);
		this.add(botonPrincipiante);
		this.add(marcadores);

	}

}
