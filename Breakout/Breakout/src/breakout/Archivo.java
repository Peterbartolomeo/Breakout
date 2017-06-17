package breakout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Archivo {
	ArrayList<Marcador> scores = new ArrayList<Marcador>();

	
	public void escribirArchivo(Marcador score) throws FileNotFoundException{
		
		scores = this.leer();
		scores.add(score);
		try{
			FileOutputStream fos= new FileOutputStream("archi");
			ObjectOutputStream oos= new ObjectOutputStream(fos);

			oos.writeObject(scores);
			oos.close();
			fos.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		
	}

	public ArrayList<Marcador> leer(){
		ArrayList<Marcador> lee = new ArrayList<Marcador>();

		try
		{
			FileInputStream fis = new FileInputStream("archi");
			ObjectInputStream ois = new ObjectInputStream(fis);
			lee = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException ioe){
			ioe.printStackTrace();

		}catch(ClassNotFoundException c){
			System.out.println("Class not found");
			c.printStackTrace();

		}
		
		return lee;


	}
}
