package ejercicio7;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
	private static final String PATRON = "dd/MM/yyyy";

	@Override
	public Date unmarshal(String v) throws Exception {
		return new SimpleDateFormat(PATRON).parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		return new SimpleDateFormat(PATRON).format(v);
	}
	
}
