package ventanas;

import java.time.temporal.JulianFields;



import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;

import clases.Jugador;


public class ventanaMostrarUsuarios extends JFrame {
		
	JScrollPane scrollPaneListaJugadores;
	JList JList;
	private DefaultListModel<Jugador>modeloLista;
	
	
	public ventanaMostrarUsuarios(){
		getContentPane().setLayout(null);
		
		scrollPaneListaJugadores = new JScrollPane();
		scrollPaneListaJugadores.setBounds(59, 315, 231, -271);
		getContentPane().add(scrollPaneListaJugadores);
		
		JList = new JList();
		JList.setBounds(69, 55, 221, 258);
		getContentPane().add(JList);
		
	}
	
	public void cargarUsuarios(){
		
	}
}
