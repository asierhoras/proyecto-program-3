package clases;

// Prueba cambio

// Prueba cambio Cristian

public class Jugador {
	private int id_user;
	private String nombre;
	private String usuario;
	private String contrase�a;
	private int punt_max;
	private int n_par_j;
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public int getPunt_max() {
		return punt_max;
	}
	public void setPunt_max(int punt_max) {
		this.punt_max = punt_max;
	}
	public int getN_par_j() {
		return n_par_j;
	}
	public void setN_par_j(int n_par_j) {
		this.n_par_j = n_par_j;
	}
	public Jugador(int id_user, String nombre, String usuario,
			String contrase�a, int punt_max, int n_par_j) {
		super();
		this.id_user = id_user;
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.punt_max = punt_max;
		this.n_par_j = n_par_j;
	}
	public Jugador(String nombre, String usuario, String contrase�a) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}
	public Jugador(String usuario, String contrase�a) {
		super();
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}
	public Jugador() {
		super();
	}
	
	
	
	

}
