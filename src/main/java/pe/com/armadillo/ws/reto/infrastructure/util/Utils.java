package pe.com.armadillo.ws.reto.infrastructure.util;

import static pe.com.armadillo.ws.reto.infrastructure.util.Constants.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Utils {

	public static String getFechaActualConFormatoBd() {
		SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA_BBDD);
		Date date = new Date();
		return formateador.format(date);
	}

	public static String getHoraActualConFormatoBd() {
		SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_HORA_BBDD);
		Date date = new Date();
		return formateador.format(date);
	}
	
	public static String getHoraActualConFormatoSoap() {
		SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_HORA_SOAP);
		Date date = new Date();
		return formateador.format(date);
	}
	
	public static String concatenarQueryDataPower(String schema, String procedure) {
		return schema.concat(PUNTO).concat(procedure);
	}

	public static String concatenarTokenDataPower(String tokenType, String tokenValue) {
		return tokenType.concat(ESPACIO).concat(tokenValue);
	}

	public static String obtenerMensajeSolicitud(String idExpediente) {
		return "Su solicitud de Cliente ".concat(idExpediente).concat(" está siendo procesada.");
	}
	
	public static String concatenarFechaSoap(String fecha, String hora) {
		return fecha.concat(hora);
	}
	
	public static String convertirXmlAString(DOMSource domSource) {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		StringWriter writer = new StringWriter();
		
		try {
			transformer = tf.newTransformer();
			transformer.transform(domSource, new StreamResult(writer));
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
		return writer.getBuffer().toString();
	}

	public static String convertirXmlABase64(String xml) {
		return new String(Base64.encodeBase64(xml.getBytes()));
	}
	
	public static Document crearDocumentXml(String url) {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			InputStream file =  Utils.class.getResourceAsStream(url);
			return docBuilder.parse(file);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}		
	}
}
