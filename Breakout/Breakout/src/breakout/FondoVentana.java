package breakout;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

public class FondoVentana extends JDesktopPane {

  private Image imagen;
 
     public FondoVentana() {
  
       this.setLayout(null); 
      // this.setToolTipText("Ventana Principal");
       //this.setBounds(0, 0, 600, 400);
  
  try {
       imagen=ImageIO.read(getClass().getResource("/Imagenes/wallpaper.jpg"));
  }
 catch (IOException e) {
   e.printStackTrace();
  }

  }
 
 public void paintComponent(Graphics g){
  
     super.paintComponent(g);
     g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
     setOpaque(false);
 }

}