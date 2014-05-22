package ejercicio5;

import model.Persona;

public class Ejercicio5 {
	public static void main(String[] args) throws Exception {
		Persona persona = PersonaBinder.leer("xml/persona.xml");
		System.out.println(persona);
	}
}
