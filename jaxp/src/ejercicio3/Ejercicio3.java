package ejercicio3;

import java.util.List;

import model.Ordenador;

public class Ejercicio3 {
	public static void main(String[] args) throws Exception {
		List<Ordenador> ordenadores = OrdenadoresBinder.leer("xml/ordenadores.xml");
		System.out.println(ordenadores);
	}
}
