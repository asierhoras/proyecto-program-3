package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import clases.Jugador;
import preguntas.Pregunta;
import preguntas.PreguntaImagen;

/**
 * @author cristian
 * Clase con la que se genera la conexion con la base de datos y la desconexion.
 */

public class accesobd {
	
	private Connection connection;
	private Statement stmt;
	
	public accesobd()
	{
		
	}
	
	public void conectar()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:BDQQSM.db");
			crearSentencia();
		}catch(Exception e)
		{
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}
	
	public void desconectar()
	{
		try {
			cerrarSentencia();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void crearSentencia()
	{
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void cerrarSentencia()
	{
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void insertarJugador(String n, String u, String c){
		String s = "INSERT INTO jugador (nombre, usuario, contrase�a, punt_max,n_par_j) VALUES ('"+n+"','"+u+"','"+c+"',0,0 )";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void eliminarJugador(String n, String u, String c){
		String s = "DELETE FROM Matricula WHERE nombre='"+n+"' AND usuario='"+u+"' AND contrase�a='"+c+"'";
		try{
			stmt.executeUpdate(s);
		}catch(SQLException e){
			System.out.println("no se ha podido eliminar el jugador");
		}
	}
	
	public boolean existeJugador (String u, String cont){
		String s = "SELECT * FROM jugador WHERE usuario='"+u+"' AND contrase�a='"+cont+"'";
		ResultSet rs;
		boolean existe=false;
		
		try {
			rs = stmt.executeQuery(s);
			if(rs.next()) //Si hay datos en rs significa que ese codigo esta en la bd
				existe = true;
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return existe;
	}
	
	public Jugador obtenerJugador(String u,String c){
		Jugador a = null;
		
		String s = "SELECT * FROM jugador WHERE usuario='"+u+"' AND contrase�a='"+c+"'";
		
		try {
			ResultSet rs = stmt.executeQuery(s);
			if(rs.next()){
				a = new Jugador(rs.getString("nombre"), rs.getString("usuario"),rs.getString("contrase�a"), rs.getInt("punt_Max"),rs.getInt("n_par_j"),rs.getString("fReg"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
	public int obteneridJugador(String u,String c){
		int a = 0;
		
		String s = "SELECT id_user FROM jugador WHERE usuario='"+u+"' AND contrase�a='"+c+"'";
		
		try {
			ResultSet rs = stmt.executeQuery(s);
			if(rs.next()){
				a = new Integer( rs.getInt("id_user"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	//ESTE METODO FALTA POR HACER
	public void insertarPartida(String n, String u, String c){
		String s = "INSERT INTO jugador (nombre, usuario, contrase�a, punt_max,n_par_j) VALUES ('"+n+"','"+u+"','"+c+"',0,0 )";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	/*	public LinkedList<Pregunta> obtenerPreguntas(){ //espero que esto funcione, pruebalo que deber�a de mostrar las preguntas que hay en la bd aunque solo he metido una
	LinkedList<Pregunta> lPreguntas = new LinkedList<Pregunta>();
	
	String s = "SELECT * FROM pregunta";
	try {
		ResultSet rs = stmt.executeQuery(s);
		while(rs.next()){
			
			String enunciado = rs.getString("pregunta");
			//lPreguntas.add(new Pregunta(enunciado));
		}
		rs.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}		
	
	return lPreguntas;
}
*/
	
	public void insertarPregunta(String p, String res1, String res2, String res3, String res4, int posresc,String img, int nivel){
		String s = "INSERT INTO pregunta ( pregunta, res1, res2, res3, res4, posRespC, imagen, nivel) VALUES ('"+p+"','"+res1+"','"+res2+"','"+res3+"','"+res4+"',"+posresc+",'"+img+"',"+nivel+" )"; 
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	public Pregunta obtenerPregunta(String p){
		Pregunta a = null;
		
		String s = "SELECT * FROM pregunta WHERE pregunta='"+p+"'";
		
		try {
			ResultSet rs = stmt.executeQuery(s);
			if(rs.next()){
				a = new Pregunta(rs.getString("pregunta"), rs.getString("res1"),rs.getString("res2"), rs.getString("res3"),rs.getString("res4"),rs.getInt("posRespC"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
	public PreguntaImagen obtenerPreguntaImagen(String p){
		PreguntaImagen a = null;
		
		String s = "SELECT * FROM pregunta WHERE pregunta='"+p+"'";
		
		try {
			ResultSet rs = stmt.executeQuery(s);
			if(rs.next()){
				a = new PreguntaImagen(rs.getString("pregunta"), rs.getString("res1"),rs.getString("res2"), rs.getString("res3"),rs.getString("res4"),rs.getInt("posRespC"),rs.getString("imagen"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public boolean existePregunta (String p, int nivel){
		String s = "SELECT * FROM pregunta WHERE pregunta='"+p+"' AND nivel="+nivel;
		ResultSet rs;
		boolean existe=false;
		
		try {
			rs = stmt.executeQuery(s);
			if(rs.next()) //Si hay datos en rs significa que ese codigo esta en la bd
				existe = true;
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}
	
	
	
	public void eliminarPregunta(String p, int nivel){
		String s = "DELETE FROM pregunta WHERE pregunta='"+p+"' AND nivel="+nivel;
		try{
			stmt.executeUpdate(s);
		}catch(SQLException e){
			System.out.println("no se ha podido eliminar la pregunta");
		}
	}
	
	
	public void nuevaPartida(){
		String s = "INSERT INTO partida () VALUES ('"+"','"+"',')"; 
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	/*public boolean existeJugador(String u, String c){ //Lo que se pasa por parametro es el usuario del jugador, no el nombre y la contrase�a
	
	boolean existe=false;
	
	String s = "SELECT * FROM jugador WHERE usuario='"+u+"'";
	String p = "SELECT * FROM jugador WHERE contrase�a='"+c+"'";
	ResultSet rs,pq;
	try {
		rs = stmt.executeQuery(s);
		pq = stmt.executeQuery(p);
		
		if(rs.next() && pq.next()){
			existe=true;
			}
		rs.close();
		pq.close();
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return existe;
}*/
	
	
	/*public void insertarAsignatura(int codigo, String nombre){
		String s = "INSERT INTO Asignatura(codigo,nombre) VALUES ("+codigo+",'"+nombre+"')";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	public LinkedList<Pregunta> obtenerPreguntas(){ //espero que esto funcione, pruebalo que deber�a de mostrar las preguntas que hay en la bd aunque solo he metido una
		LinkedList<Pregunta> lPreguntas = new LinkedList<Pregunta>();
		
		String s = "SELECT * FROM pregunta";
		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				
				String pregunta = rs.getString("pregunta");
				String res1 = rs.getString("res1");
				String res2 = rs.getString("res2");
				String res3 = rs.getString("res3");
				String res4 = rs.getString("res4");
				int posRespC = rs.getInt("posRespC");
				String img =rs.getString("imagen");
				if(img=="src/imagenespreguntas/"){
					lPreguntas.add(new Pregunta(pregunta,res1,res2,res3,res4,posRespC));
				}else{
					lPreguntas.add(new PreguntaImagen(pregunta,res1,res2,res3,res4,posRespC,img));
				}
				
				
				
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return lPreguntas;
	}
	
	/*public void insertarMatricula(String dni, int codigo){
		String s = "INSERT INTO Matricula(dni,codigo) VALUES('"+dni+"',"+codigo+")";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	
	public boolean existeMatricula(String dni, int cod){
		String s = "SELECT * FROM Matricula WHERE dni='"+dni+"' AND codigo="+cod;
		ResultSet rs;
		boolean resul=false;
		try {
			rs = stmt.executeQuery(s);
			if(rs.next())
				resul=true;
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return resul;
	}*/
	

	/*public LinkedList<Jugador> obtenerUsuarios(){//clase jugador no creada, tengo creada una clase con el nombre de perfil en el proyecto, tiene como parametros user y pass. Podriamos incluir ahi los datos que nos falten respecto a la bd o crear otra clase, como prefieras
		LinkedList<Jugador> lUsuarios = new LinkedList<Jugador>();
		
		String s = "SELECT * FROM jugador;";
		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){//Aqui va a dar errores a tutiplen
				//he quitado cosas
				Jugador a = new Jugador();
				lUsuarios.add(a);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lUsuarios;
	}
	*/
/*	public void borrarMatricula(String d, int c){
		String s = "DELETE FROM Matricula WHERE dni='"+d+"' AND codigo="+c;
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Alumno obtenerAlumno(String d){
		Alumno a = null;
		
		String s = "SELECT * FROM Alumno WHERE dni='"+d+"'";
		
		try {
			ResultSet rs = stmt.executeQuery(s);
			if(rs.next()){
				a = new Alumno(rs.getString("dni"), rs.getString("nom"),rs.getString("foto"), rs.getInt("edad"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public LinkedList<String> obtenerRutasFotos(){
		String s = "SELECT foto FROM Alumno";
		LinkedList<String> lFotos = new LinkedList<String>();
		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				lFotos.add(rs.getString("foto"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lFotos;
	}
	
	public LinkedList<Alumno> obtenerAlumnos(){
		String s= "SELECT * FROM Alumno WHERE dni <> '***'";
		LinkedList<Alumno> lAlumnos = new LinkedList<Alumno>();
		
		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				Alumno a  = new Alumno(rs.getString("dni"), rs.getString("nom"),rs.getString("foto"), rs.getInt("edad"));
				lAlumnos.add(a);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lAlumnos;
	}
	
	public boolean existeLibro(String cod){
		boolean existe=false;
		String s = "SELECT * FROM libro WHERE codigo='"+cod+"'";
		try {
			ResultSet rs = stmt.executeQuery(s);
			if(rs.next())
				existe=true;
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return existe;
	}
	
	public void insertarLibro(String cod, String nom, float precio, String ruta){
		
		String s = "INSERT INTO libro(codigo,nombre,precio,ruta) VALUES('"+cod+"','"+nom+"',"+precio+",'"+ruta+"')";
		
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public LinkedList<String> obtenerRutasFotosLibros(){
		String s= "SELECT ruta FROM libro";
		LinkedList<String> lRutasLibros = new LinkedList<String>();
		
		try {
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				lRutasLibros.add(rs.getString("ruta"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lRutasLibros;
		
	}
	
	public Libro obtenerLibro(String ruta){
		String s = "SELECT * FROM libro WHERE ruta='"+ruta+"'";
		ResultSet rs;
		Libro l = null;
		try {
			rs = stmt.executeQuery(s);
			l = new Libro(rs.getString("codigo"),rs.getString("nombre"),rs.getFloat("precio"),rs.getString("ruta"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}
	
	public void insertarCompra(LinkedList<Compra> carrito){
		
		for(int i=0;i<carrito.size();i++){
			Compra c = carrito.get(i);
			String s = "INSERT INTO compra(dni,codigo,unidades,precioTotal) VALUES('" + c.getDni() +"','" + c.getCodigo()+ "',"+ c.getUnidades()+","+ c.getPrecioTotal()+")";
			try {
				stmt.executeUpdate(s);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}*/

	/*public static void main(String[] args) {
		
		accesobd o = new accesobd();
		o.conectar();
		LinkedList<Pregunta> lPreguntas= o.obtenerPreguntas();
		System.out.println(lPreguntas.getFirst().getRes1());
	}
	*/

}
