package breakout;

import java.io.Serializable;

public class Marcador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	String score;
	String nombre;
}
