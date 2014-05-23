package ejercicio4;

import java.text.SimpleDateFormat;

import model.Persona;

public class Ejercicio4 {
	public static void main(String[] args) throws Exception {
		Persona persona = new Persona(
				1, 
				"Juan", 
				"Pérez", 
				new SimpleDateFormat("yyyy-MM-dd").parse("1980-01-03"),
				180);
		
		PersonaWriter.escribir(persona, "xml/persona.xml"); // Escribe el documento XML
		System.out.println("Archivo XML escrito");
	}
}
