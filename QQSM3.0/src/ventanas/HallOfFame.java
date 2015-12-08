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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;

public class HallOfFame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;


	public HallOfFame(){

		
		FondoH fondo = new FondoH();
		getContentPane().add(fondo, BorderLayout.CENTER);

		fondo.setLayout(null);
		
		JLabel lblHallOfFame = new JLabel("HALL OF FAME");
		lblHallOfFame.setHorizontalAlignment(SwingConstants.CENTER);
		lblHallOfFame.setFont(new Font("Lucida Handwriting", Font.PLAIN, 75));
		lblHallOfFame.setForeground(Color.YELLOW);
		lblHallOfFame.setBounds(131, 13, 968, 139);
		fondo.add(lblHallOfFame);
		
		JList list = new JList();
		list.setBounds(366, 165, 505, 486);
		fondo.add(list);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setResizable(false);
		
		btnVolver = new JButton("Salir");
		btnVolver.setFont(new Font("Yu Gothic", Font.PLAIN, 24));
		btnVolver.setBounds(33, 652, 200, 50);
		fondo.add(btnVolver);
		btnVolver.addActionListener(this);


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
		HallOfFame f= new HallOfFame();
	}



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
class FondoH extends JPanel {



	public void paintComponent (Graphics g){
		Dimension tamaño= getSize();
		ImageIcon imagenFondo= new ImageIcon (new ImageIcon(getClass().getResource("/imagenes/fondo2.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);

	}

}



