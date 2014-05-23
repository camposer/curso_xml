package ejercicio6;

import model.Persona;
import ejercicio6.PersonaBinder;

public class Ejercicio6 {
	public static void main(String[] args) throws Exception {
		Persona persona = PersonaBinder.leer("xml/persona.xml");
		System.out.println(persona);
	}
}
