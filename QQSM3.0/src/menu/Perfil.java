package menu;

import java.io.Serializable;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import preguntas.Utilidades;

//Esta clase se encarga de que el juego haga un seguimiento del jugador y guarde sus datos a pesar de cerrar el juego.
public class Perfil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Atributos del perfil de usuario
	public String username;

	public String password;


//getters y setters
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


//constructores
	public Perfil(String user,String pass) {
		super();

		this.username = user;
		this.password=pass;
	}

	public Perfil() {
	}

	/**Método que pide los datos del usuario
	 * 
	 */
	public void pedirDatosUsuario(){
		System.out.println("Introduzca un nombre de usuario por favor: ");
		this.username=Utilidades.leerCadena();
		System.out.println("Password: ");
		this.password=Utilidades.leerCadena();
	}


	public String toString() {

		return "Perfil [username=" + username + ", contraseña=" + password + "]";
	}


	/**Main de prueba
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Perfil a = new Perfil();
		a.pedirDatosUsuario();
		System.out.println(a.toString());
	}

}
