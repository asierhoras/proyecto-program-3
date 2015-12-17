package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.temporal.JulianFields;






import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;

import clases.Jugador;


public class ventanaMostrarUsuarios extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JScrollPane scrollPaneListaJugadores;
	JList JList;
	private DefaultListModel<Jugador>modeloLista;
	
	
	public ventanaMostrarUsuarios(){
		
		Fondou fondo = new Fondou();
		getContentPane().add(fondo, BorderLayout.CENTER);

		fondo.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(1200,800);
		this.setResizable(false);


		//codigo JList//
		
		
		
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = getSize();
		// cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2,
				(pantalla.height - ventana.height) / 2);
		this.setVisible(true);
		
		
	}
	

	public static void main(String[] args) {
		ventanaMostrarUsuarios a= new ventanaMostrarUsuarios();
		
	}
	
	
}


class Fondou extends JPanel {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent (Graphics g){
		Dimension tamaño= getSize();
		ImageIcon imagenFondo= new ImageIcon (new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);

	}

}