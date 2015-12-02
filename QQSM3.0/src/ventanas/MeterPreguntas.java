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

public class MeterPreguntas extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JTextField txpregunta;
	private JTextField txres1;
	private JTextField txres2;
	private JTextField txres3;
	private JTextField textField;


	public MeterPreguntas(){


		FondoPreguntas fondo = new FondoPreguntas();
		getContentPane().add(fondo, BorderLayout.CENTER);

		fondo.setLayout(null);
		
		JLabel lblIntroducirPreguntas = new JLabel("INTRODUCIR PREGUNTAS");
		lblIntroducirPreguntas.setForeground(Color.WHITE);
		lblIntroducirPreguntas.setFont(new Font("Segoe Script", Font.BOLD, 45));
		lblIntroducirPreguntas.setBounds(261, 35, 682, 57);
		fondo.add(lblIntroducirPreguntas);
		
		txpregunta = new JTextField();
		txpregunta.setBounds(286, 199, 754, 39);
		fondo.add(txpregunta);
		txpregunta.setColumns(10);
		
		JLabel lblPregunta = new JLabel("PREGUNTA");
		lblPregunta.setForeground(Color.WHITE);
		lblPregunta.setFont(new Font("Segoe Script", Font.PLAIN, 35));
		lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPregunta.setBounds(10, 200, 241, 48);
		fondo.add(lblPregunta);
		
		JLabel lblres1 = new JLabel("RES1");
		lblres1.setFont(new Font("Segoe Script", Font.PLAIN, 35));
		lblres1.setHorizontalAlignment(SwingConstants.CENTER);
		lblres1.setForeground(Color.WHITE);
		lblres1.setBounds(23, 329, 207, 49);
		fondo.add(lblres1);
		
		txres1 = new JTextField();
		txres1.setBounds(286, 329, 299, 39);
		fondo.add(txres1);
		txres1.setColumns(10);
		
		JLabel lblres2 = new JLabel("RES2");
		lblres2.setBackground(Color.WHITE);
		lblres2.setHorizontalAlignment(SwingConstants.CENTER);
		lblres2.setForeground(Color.WHITE);
		lblres2.setFont(new Font("Segoe Script", Font.PLAIN, 35));
		lblres2.setBounds(653, 329, 207, 49);
		fondo.add(lblres2);
		
		txres2 = new JTextField();
		txres2.setColumns(10);
		txres2.setBounds(865, 329, 299, 39);
		fondo.add(txres2);
		
		JLabel lblres3 = new JLabel("RES3");
		lblres3.setHorizontalAlignment(SwingConstants.CENTER);
		lblres3.setForeground(Color.WHITE);
		lblres3.setFont(new Font("Segoe Script", Font.PLAIN, 35));
		lblres3.setBounds(23, 425, 207, 49);
		fondo.add(lblres3);
		
		txres3 = new JTextField();
		txres3.setColumns(10);
		txres3.setBounds(286, 425, 299, 39);
		fondo.add(txres3);
		
		JLabel lblres4 = new JLabel("RES4");
		lblres4.setHorizontalAlignment(SwingConstants.CENTER);
		lblres4.setForeground(Color.WHITE);
		lblres4.setFont(new Font("Segoe Script", Font.PLAIN, 35));
		lblres4.setBackground(Color.WHITE);
		lblres4.setBounds(653, 425, 207, 49);
		fondo.add(lblres4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(865, 425, 299, 35);
		fondo.add(textField);
		
		JButton btnAadirALa = new JButton("A\u00D1ADIR A LA BD");
		btnAadirALa.setFont(new Font("Segoe Script", Font.PLAIN, 35));
		btnAadirALa.setBounds(470, 669, 371, 71);
		fondo.add(btnAadirALa);
		
		JComboBox cbresc = new JComboBox();
		cbresc.setModel(new DefaultComboBoxModel(new String[] {"- Seleccione la respuesta correcta -", "1", "2", "3", "4"}));
		cbresc.setSelectedIndex(1);
		cbresc.setMaximumRowCount(4);
		cbresc.setBounds(535, 500, 228, 49);
		fondo.add(cbresc);
		
		JLabel lblresc = new JLabel("PosRespC");
		lblresc.setHorizontalAlignment(SwingConstants.CENTER);
		lblresc.setForeground(Color.WHITE);
		lblresc.setFont(new Font("Segoe Script", Font.PLAIN, 35));
		lblresc.setBackground(Color.WHITE);
		lblresc.setBounds(297, 500, 207, 49);
		fondo.add(lblresc);
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
	MeterPreguntas f= new MeterPreguntas();
	}
}

/**
 * @author Asier
 *clase para ponerle un fondo a la ventana
 */
class FondoPreguntas extends JPanel {



	public void paintComponent (Graphics g){
		Dimension tamaño= getSize();
		ImageIcon imagenFondo= new ImageIcon (new ImageIcon(getClass().getResource("/imagenes/fondo2.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
}



