package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaAdministrador extends JFrame implements ActionListener{

	
	private JButton btnNuevaPregunta,btnUsuarios;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public VentanaAdministrador(){
		
		

		ventanas.Fondo fondo = new Fondo();
		getContentPane().add(fondo, BorderLayout.CENTER);

		fondo.setLayout(null);
		
		btnNuevaPregunta = new JButton("PREGUNTAS");
		btnNuevaPregunta.setFont(new Font("Stencil", Font.PLAIN, 44));
		btnNuevaPregunta.setForeground(Color.BLUE);
		btnNuevaPregunta.addActionListener(this);
		
		btnNuevaPregunta.setBounds(391, 233, 429, 65);
		fondo.add(btnNuevaPregunta);
		
		btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.setForeground(Color.BLUE);
		btnUsuarios.setFont(new Font("Stencil", Font.PLAIN, 44));
		btnUsuarios.setBounds(391, 396, 429, 65);
		fondo.add(btnUsuarios);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setResizable(false);


		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = getSize();
		// cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2,
				(pantalla.height - ventana.height) / 2);


		this.setVisible(true);
	}



	protected void eliminarVentana() {
		this.dispose();
	}



	public static void main(String[] args) {    
		// TODO Auto-generated method stub
		Entrada f= new Entrada();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton botonPulsado = (JButton) e.getSource();
		
		if (botonPulsado==btnUsuarios){
			
		}
		
	}



	
}

class Fondo extends JPanel {



	public void paintComponent (Graphics g){
		Dimension tamaño= getSize();
		ImageIcon imagenFondo= new ImageIcon (new ImageIcon(getClass().getResource("/imagenes/fondo2.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
}