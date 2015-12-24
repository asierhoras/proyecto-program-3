package clases;

import java.util.Date;

// Prueba cambio

// Prueba cambio Cristian

public class Jugador {
	
	private String nombre;
	private String usuario;
	private String contraseña;
	private int punt_max;
	private int n_par_j;
	private String fReg;
	
	public String getfReg() {
		return fReg;
	}
	public void setfReg(String fReg) {
		this.fReg = fReg;
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
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
	
	public Jugador(String nombre, String usuario,
			String contraseña, int punt_max, int n_par_j, String fReg) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.punt_max = punt_max;
		this.n_par_j = n_par_j;
		this.fReg = fReg;
	}
	
	public Jugador(String nombre, String usuario,
			String contraseña, int punt_max, int n_par_j) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.punt_max = punt_max;
		this.n_par_j = n_par_j;
	}
	public Jugador(String nombre, String usuario, String contraseña) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	public Jugador(String usuario, String contraseña) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	public Jugador() {
		super();
	}
	
	
	
	

}
