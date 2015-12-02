package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame{

	private static final long serialVersionUID = 1L;


	public Menu (){

		FondoM fondoM = new FondoM();
		getContentPane().add(fondoM, BorderLayout.CENTER);
		fondoM.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("INICIAR PARTIDA");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PreguntasVentana pv = new PreguntasVentana();
				pv.setVisible(true);
			}
		});
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setBounds(444, 215, 338, 105);
		fondoM.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PERFIL");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PerfilVentana pv = new PerfilVentana();
				pv.setVisible(true);
				cerrarVentana();
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 36));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(444, 388, 327, 87);
		fondoM.add(lblNewLabel_1);

		JLabel lblSalir = new JLabel("SALIR");
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setFont(new Font("Stencil", Font.PLAIN, 36));
		lblSalir.setForeground(new Color(255, 255, 255));
		lblSalir.setBounds(426, 540, 378, 87);
		fondoM.add(lblSalir);


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

	public void cerrarVentana(){
		this.dispose();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu f= new Menu();

	}
}

//Fondo menu
class FondoM extends JPanel {



	public void paintComponent (Graphics g){
		Dimension tamaño= getSize();
		ImageIcon imagenFondo= new ImageIcon (new ImageIcon(getClass().getResource("/imagenes/menu.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);

	}

}
