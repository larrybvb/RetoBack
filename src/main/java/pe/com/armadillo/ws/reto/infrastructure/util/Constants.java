package pe.com.armadillo.ws.reto.infrastructure.util;

public class Constants {
	
	/* SWAGGER */
	public static final String SWAGGER_BASE_PACKAGE = "pe.com.armadillo.ws.reto";
	public static final String SWAGGER_TITLE = "Web Service Esigna - Bono";
	public static final String SWAGGER_DESCRIPTION = "Documentation of: endpoint inputs and outputs";
	public static final String SWAGGER_VERSION = "1.0";
	
	/* INDICADORES */
	public static final String ESPACIO = " ";
	public static final String PUNTO = ".";
	public static final int CANTIDAD_CARACTERES_CUSPP = 16;
	
	public static final String REGEX_ALFANUMERICO = "([A-Za-zñÑ]+[0-9]|[0-9]+[A-Za-zñÑ]|[0-9])[A-Za-z0-9ñÑ]*";
	
	public static final String SOLICITUD_BONO="SOLICITUD-BONO";
	
	public static final String STRING_VACIO = "";
	public static final String ESTADO_PRE_INGRESADO = "PRE";
	public static final String ESTADO_INGRESADO = "ING";
	public static final String ESTADO_ERROR = "ERR";

	public static final int INDICE_CERO = 0;
	public static final int INDICE_38 = 38;
	public static final int INDICE_54 = 54;
		
	public static final String DATAPOWER_CODIGO_EXITO = "0";
	
	public static final String FORMATO_FECHA_BBDD = "yyyyMMdd";
	public static final String FORMATO_HORA_BBDD = "HHmmss";
	public static final String FORMATO_HORA_SOAP = "HHmm";

	public static final String ELEMENTO_SOAP_USER = "User";
	public static final String ELEMENTO_SOAP_PASS = "Pass";
	public static final String ELEMENTO_SOAP_FECHA = "Fecha";
	public static final String ELEMENTO_SOAP_METODO = "Metodo";
	public static final String ELEMENTO_SOAP_DATOS = "Datos";
	public static final String ELEMENTO_SOAP_ID_EXPEDIENTE = "IdExpediente";
	public static final String ELEMENTO_SOAP_TAREA_ESTADO = "tareaestadoas";
	public static final String ELEMENTO_SOAP_DATOS_ADICIONALES = "DatosAdicionales";
	
	// Comandos
	public static final String COMANDO_GRUPO = "Bono";
	public static final String COMANDO_REGISTRAR_BONO = "Registrar/Bono";	
	public static final String BONO_REGISTRADO = "Bono/Registrado";
	public static final String BONO_RECEPCIONADO = "Bono/Recepcionado";
	public static final String BONO_MIGRADO = "Bono/Migrado";
	public static final String BONO_NO_PROCESADO = "Bono/NoProcesado";
	public static final String BONO_ACTUALIZADO = "Bono/Actualizado";

	public static final String URL_REQUEST = "/xml/RequestPlataformaIndenovaWS.xml";
	public static final String URL_METODO = "/xml/MetodoEsquemaFinalizarTareaExpedient.xml";
	
	public static final String APM_LISTENER = "listener";

}
