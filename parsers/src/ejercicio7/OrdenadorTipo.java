package ejercicio7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum OrdenadorTipo {
	@XmlEnumValue(value="PORTATIL")
	LAPTOP,
	@XmlEnumValue(value="ESTACION_TRABAJO")
	WORKSTATION, 
	@XmlEnumValue(value="SERVIDOR")
	SERVER;
}
