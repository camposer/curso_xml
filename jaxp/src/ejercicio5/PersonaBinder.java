package ejercicio5;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Persona;

public abstract class PersonaBinder {
	public static Persona leer(String rutaXml) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		PersonaBinderHandler personaBinderHandler = new PersonaBinderHandler();
		saxParser.parse(rutaXml, personaBinderHandler);
		
		return personaBinderHandler.getPersona(); 
	}
	
	private static class PersonaBinderHandler extends DefaultHandler {
		private Persona persona;
		private String elemento;
		
		public PersonaBinderHandler() {
			this.persona = new Persona();
		}
		
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			
			elemento = qName;
			
			if (elemento.equals("persona"))
				persona.setId(Integer.parseInt(attributes.getValue("id")));
		}
		
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			
			String valor = new String(ch, start, length);
			
			if (!valor.trim().equals("")) {
				if (elemento.equals("nombre")) 
					persona.setNombre(valor);
				else if (elemento.equals("apellido")) 
					persona.setApellido(valor);
				else if (elemento.equals("fechaNacimiento"))
					try {
						persona.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(valor));
					} catch (ParseException e) { }
				else if (elemento.equals("altura"))
					persona.setAltura(Integer.parseInt(valor));
			}
			
		}
		
		public Persona getPersona() {
			return persona;
		}
	}
}
