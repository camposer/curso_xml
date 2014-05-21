package model;

public class Ordenador {
	private String nombre;
	private String serial;
	
	public Ordenador(String nombre, String serial) {
		super();
		this.nombre = nombre;
		this.serial = serial;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	@Override
	public String toString() {
		return "Ordenador [nombre=" + nombre + ", serial=" + serial + "]";
	}
}
