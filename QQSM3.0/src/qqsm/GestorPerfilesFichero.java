package qqsm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import menu.Perfil;
import preguntas.PreguntaImagen;
import preguntas.PreguntaTexto;

//En esta clase se encuentran todas las preguntas.
//Esta clase se ejecutarla primera vez que inicializemos el programa y creara 3 archivos con todas las preguntas del programa.
//Cada archivo será para una dificultad concreta

public class GestorPerfilesFichero  {

	public static void main(String[] args) {

		EscribirPerfiles();


	}

	/**Método que crea el fichero perfiles.dat y le introduce en el dos objetos de tipo perfil con sus respectivos parametros
	 * 
	 */
	protected static void EscribirPerfiles() {
		try {
			FileOutputStream fos = new FileOutputStream("perfiles.dat");
			ObjectOutputStream oss = new ObjectOutputStream(fos);

			oss.writeObject(new Perfil("Asier","Asier"));
			oss.writeObject(new Perfil("admin","administrador"));		
			oss.writeObject(null);
			oss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param nick
	 * @param password
	 * @return null si no existe el objeto perfil con los parametros introducidos ya en el perfiles.dat y el Perfil en si con los datos introducidos si ya existe
	 */
	public static Perfil buscarPerfilEnFichero(String nick, String password) {
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("perfiles.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Perfil p = (Perfil) ois.readObject();
			Perfil e= new Perfil(nick,password);


			while(p!= null){
				if (p.getPassword().equals(e.getPassword())){
					if (p.getUsername().equals(e.getUsername())){
					//	p = (Perfil) ois.readObject();
						return p;
					}
				}
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e){
			System.out.println("ERROR");
		}
		return null;
	}


/**
 * @param nick
 * @param password
 * Si el perfil introducido no existe en el fichero este método creará una instancia de Perfil con sus parametros y lo introducirá en el fichero
 */
public static void escribirPerfilEnFichero(String nick, String password) {
	// TODO Auto-generated method stub
	try {
		FileOutputStream fos = new FileOutputStream("perfiles.dat");
		ObjectOutputStream oss = new ObjectOutputStream(fos);
		oss.writeObject(new Perfil(nick,password));
		oss.writeObject(null);
		oss.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}


}
