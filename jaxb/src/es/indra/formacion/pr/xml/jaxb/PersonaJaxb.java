package es.indra.formacion.pr.xml.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.indra.formacion.pr.xml.jaxb.model.Coches;

public class PersonaJaxb {
	public static void main(String[] args) {

		try {
			// Unmarshalling
			File file = new File("xml/coches.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Coches.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Coches coches = (Coches) jaxbUnmarshaller.unmarshal(file);
			System.out.println(coches);

			// Marshalling
			file = new File("xml/coches-1.xml");

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(coches, file);
			System.out.println("Archivo generado: " + file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
