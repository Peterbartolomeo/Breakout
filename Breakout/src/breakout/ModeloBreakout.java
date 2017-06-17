package breakout;



import java.util.Observable;

import javax.swing.JOptionPane;

import static breakout.Valores.*;

public class ModeloBreakout extends Observable
{
	private Juego pelota;      
	private Juego ladrillos[];  
	private Juego barra;       

	private ModeloPelota modP  = new ModeloPelota( this );
	private Thread hilo  = new Thread( modP );
	private VistaBreakout vistita = new VistaBreakout();
	private boolean estado = true;

	private int marcador = 0;

	public void crearObjetos(int nivel)
	{
		pelota   = new Juego(ancho/2, altura/2, pelotaTamano, pelotaTamano, Colores.GRAY );
		barra    = new Juego(350, altura - alturaBloque*2, anchoBloque*4, 
				alturaBloque, Colores.YELLOW);
		ladrillos = new Juego[nivel];


		int desplazamientox = 30; 
		int desplazamientoy = 90; 

		int bloques = ancho/anchoBloque-1; 
		int lineaBloques = 1; 

		for (int a = 0; a < ladrillos.length; a++) //Setear ladrillos
		{
			if (bloques == lineaBloques) 
			{
				desplazamientoy+=alturaBloque+30;
				lineaBloques = 1; 
				desplazamientox = 30; 
			}

			ladrillos[a] = new Juego (desplazamientox, desplazamientoy, anchoBloque, alturaBloque, Colores.WHITE);
			desplazamientox+=anchoBloque+4;//espacio entre bloques
			lineaBloques++; 


		}
	}
	public boolean detener(){
		return modP.flag();
	}

	public void iniciarJuego(){ 
		hilo.start();

	}

	public Juego obtenerPelota() {
		return pelota; 
	}

	public Juego[] obtenerLadrillos(){
		//int x =ladrillos.length;
		//System.out.println(x);
		return ladrillos; 
	}

	public Juego obtenerBarra(){
		return barra; 
		}

	public void anadirMarcador( int n ){
		marcador += n;
		}

	public int obtenerMarcador(){
		int x = marcador;
		//System.out.println(x);
		if(marcador == ladrillos.length*50){
			JOptionPane.showMessageDialog(null,"Has Ganado");
			hilo.stop();
		}
		return marcador; 
		}
	public void obtenerEstado(boolean es){
		estado = es;
	}
	public boolean estado (){
		//estado = true;
		return estado;
	}
	public void paraHilo(){
		hilo.stop();;
	//	VistaBreakout vista = new VistaBreakout();
		//vista.volverMenu();
	}
	public void pararJuego() { 
		hilo.suspend();
	}
	public void reanudarJuego(){
		hilo.resume();
		
	}


	public void moverBarra( float dist )
	{
	
		if ((barra.obtenerX()>0 && dist<0) || (barra.obtenerX()<ancho-anchoBloque*3 && dist>0)){ 
			barra.moverenX(dist); 
		}
	}


	public void cambiomodelo()
	{
	//	vistita.setEstadoJuego(true);
		
		setChanged();
		notifyObservers();
	}
	public void juegoPerdido()
	{
		this.deleteObservers();

	}

}
