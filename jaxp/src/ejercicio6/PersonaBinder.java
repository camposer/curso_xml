package ejercicio6;

import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import model.Persona;

public abstract class PersonaBinder {
	
	public static Persona leer(String rutaXml) throws Exception {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(rutaXml));

        return new PersonaBinderHandler(xmlStreamReader).getPersona();
	}

	private static class PersonaBinderHandler {
		private String elemento;
	    private Persona persona = new Persona();
	    private XMLStreamReader xmlStreamReader;
	    
	    public PersonaBinderHandler(XMLStreamReader xmlStreamReader) throws XMLStreamException {
	    	this.xmlStreamReader = xmlStreamReader;
			start();
		}
	    
	    public void start() throws XMLStreamException {
	        while(xmlStreamReader.hasNext()) {
	            int event = xmlStreamReader.next();

	            switch (event) {
	            	case XMLStreamConstants.START_ELEMENT:
	        			startElement();
	            		break;
	            	case XMLStreamConstants.CHARACTERS:
	            		characters();
	            		break;
	            }
	        }
	    }
	    
		private void startElement() {
			elemento = xmlStreamReader.getLocalName();
			
			if (elemento.equals("persona"))
				persona.setId(Integer.parseInt(xmlStreamReader.getAttributeValue(null, "id")));
		}
		
		private void characters() {
			String valor = xmlStreamReader.getText();
			
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
