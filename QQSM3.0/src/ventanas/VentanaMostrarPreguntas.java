package ventanas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



import ventanas.PreguntasVentana.Position;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaMostrarPreguntas extends JFrame {

	
	private static final long serialVersionUID = 1L;


	public VentanaMostrarPreguntas(){


		FondoMPreguntas fondo = new FondoMPreguntas();
		getContentPane().add(fondo, BorderLayout.CENTER);

		fondo.setLayout(null);
		
		JLabel lblIntroducirPreguntas = new JLabel("PREGUNTAS EN LA BD");
		lblIntroducirPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroducirPreguntas.setForeground(Color.WHITE);
		lblIntroducirPreguntas.setFont(new Font("Segoe Script", Font.BOLD, 45));
		lblIntroducirPreguntas.setBounds(316, 40, 603, 57);
		fondo.add(lblIntroducirPreguntas);
		
		JButton btnIntroducirPreguntaNueva = new JButton("INTRODUCIR PREGUNTA NUEVA");
		btnIntroducirPreguntaNueva.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnIntroducirPreguntaNueva.setBounds(707, 672, 463, 64);
		btnIntroducirPreguntaNueva.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				MeterPreguntas mp = new MeterPreguntas();
				mp.setVisible(true);
				eliminarVentana();
			}
		});
		fondo.add(btnIntroducirPreguntaNueva);
		
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
	VentanaMostrarPreguntas f= new VentanaMostrarPreguntas();
	}
}

/**
 * @author Asier
 *clase para ponerle un fondo a la ventana
 */
class FondoMPreguntas extends JPanel {



	public void paintComponent (Graphics g){
		Dimension tamaño= getSize();
		ImageIcon imagenFondo= new ImageIcon (new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
}



