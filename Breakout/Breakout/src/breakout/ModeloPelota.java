package breakout;



import static breakout.Valores.*;

import javax.swing.JOptionPane;


public class ModeloPelota implements Runnable
{
	private ModeloBreakout model;
	private boolean iniciarJuego = true;
	private VistaBreakout vista;
	private boolean flags = false;

	public ModeloPelota(ModeloBreakout breakModel)
	{
		model = breakModel;
	}


	public void detenerJuego(){
		iniciarJuego = false; 
	}
	
	public boolean flag() {
		return flags;
	}

	@Override
	public void run()
	{
		final float S = 4; // velocidad
		try
		{
			Juego pelota     = model.obtenerPelota();     
			Juego bloque[] = model.obtenerLadrillos();   
			Juego barra      = model.obtenerBarra();      

			while (iniciarJuego)
			{
				double x = pelota.obtenerX();
				double y = pelota.obtenerY();
				if (x >= ancho - borde - pelotaTamano){
					pelota.cambiarDireccionX();
				}  
				if (x <= 0 + borde  ) {
					pelota.cambiarDireccionX();
					//vista.setEstadoJuego(false);

				} 
				if (y >= altura - borde - pelotaTamano) 
				{ 
					
					Archivo ars = new Archivo();
					Marcador marc = new Marcador();
					model.obtenerEstado(false);
					marc.nombre = JOptionPane.showInputDialog("Escriba su nombre");
					marc.score =Integer.toString( model.obtenerMarcador());
					ars.escribirArchivo(marc);
					pelota.cambiarDireccionY(); 
					JOptionPane.showMessageDialog(null,"Perdiste");
				//	model.juegoPerdido();

					//model.paraHilo();

					//flags = true;
					//vista.volverMenu(true);
					
					
					//model.pararJuego();
					
					//model.paraHilo();
					//	vista.volverMenu();

				}
				if (y <= 0 + bordeT ){
					pelota.cambiarDireccionY();

				}  

				pelota.moverenX(S);  
				pelota.moverenY(S);

				for (int a =0; a<bloque.length; a++)
				{ 
					if(bloque[a]!=null && bloque[a].choque(pelota) == Juego.Collision.choque)
					{ 
						bloque[a] = null; 
						pelota.cambiarDireccionY(); //Cambiar direccion cuando golpee bloque

						model.anadirMarcador (golpeBloque); 
						model.cambiomodelo();; 
						Thread.sleep(4);
					}

				}

				if (barra.choque(pelota) == Juego.Collision.choque){
					pelota.cambiarDireccionY();
				}


				model.cambiomodelo(); 

				Thread.sleep(10);     
			}
		} catch (Exception e) { } ;
	}
}

