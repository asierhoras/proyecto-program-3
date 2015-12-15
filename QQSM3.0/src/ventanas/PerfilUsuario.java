package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ventanas.PreguntasVentana.Position;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;

public class PerfilUsuario extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JButton btnVolver;


	public PerfilUsuario(){

		Fondoper fondo = new Fondoper();
		getContentPane().add(fondo, BorderLayout.CENTER);

		fondo.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Caladea", Font.PLAIN, 55));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(445, 86, 348, 117);
		fondo.add(lblNombre);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Caladea", Font.PLAIN, 55));
		lblUsuario.setBounds(445, 216, 348, 117);
		fondo.add(lblUsuario);
		
		JLabel lblRecord = new JLabel("record");
		lblRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecord.setForeground(Color.WHITE);
		lblRecord.setFont(new Font("Caladea", Font.PLAIN, 55));
		lblRecord.setBounds(445, 334, 348, 117);
		fondo.add(lblRecord);
		
		JLabel lblMiembroDesde = new JLabel("miembro desde");
		lblMiembroDesde.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiembroDesde.setForeground(Color.WHITE);
		lblMiembroDesde.setFont(new Font("Caladea", Font.PLAIN, 55));
		lblMiembroDesde.setBounds(445, 466, 368, 117);
		fondo.add(lblMiembroDesde);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnVolver = new JButton("Salir");
		btnVolver.setFont(new Font("Yu Gothic", Font.PLAIN, 24));
		btnVolver.setBounds(33, 652, 200, 50);
		fondo.add(btnVolver);
		
		JButton btnCerrarSesion = new JButton("CERRAR SESION");
		btnCerrarSesion.setFont(new Font("Kristen ITC", Font.PLAIN, 35));
		btnCerrarSesion.setBackground(Color.BLACK);
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setBounds(804, 652, 378, 74);
		fondo.add(btnCerrarSesion);
		btnVolver.addActionListener(this);
		
		
		
		
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
		PerfilUsuario f= new PerfilUsuario();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
JButton botonPulsado = (JButton) e.getSource();
		
		if (botonPulsado == btnVolver){
			new Menu();
			this.dispose();
		}
	}
}

/**
 * @author Asier
 *clase para ponerle un fondo a la ventana
 */
class Fondoper extends JPanel {



	public void paintComponent (Graphics g){
		Dimension tamaño= getSize();
		ImageIcon imagenFondo= new ImageIcon (new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);

	}

}



