package dom;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.Persona;

public abstract class PersonaWriter {
	public static void escribir(Persona p, String rutaXml) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();

		Element persona = doc.createElement("persona"); // id
		persona.setAttribute("id", Integer.toString(p.getId()));
			
		Element elemento = doc.createElement("nombre"); // nombre
		elemento.setTextContent(p.getNombre());
		persona.appendChild(elemento);
		
		elemento = doc.createElement("apellido"); // apellido
		elemento.setTextContent(p.getApellido());
		persona.appendChild(elemento);

		elemento = doc.createElement("fechaNacimiento"); // fechaNacimiento
		elemento.setTextContent(new SimpleDateFormat("yyyy-MM-dd").format(p.getFechaNacimiento()));
		persona.appendChild(elemento);

		elemento = doc.createElement("altura"); // altura
		elemento.setTextContent(Integer.toString(p.getAltura()));
		persona.appendChild(elemento);

		doc.appendChild(persona); // Añadiendo la persona al documento

		// Save the Created XML on Local Disc using Transformation APIs as
		// Discussed
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer();

		// below 2 line are only for pretty look rendering of XML
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(
				"{http://xml.apache.org/xslt}indent-amount", "4");

		Source s = new DOMSource(doc);
		Result res = new StreamResult(new FileOutputStream(rutaXml));
		transformer.transform(s, res);
	}
}
