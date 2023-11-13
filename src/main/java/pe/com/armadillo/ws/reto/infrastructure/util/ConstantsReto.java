package pe.com.armadillo.ws.reto.infrastructure.util;

public class ConstantsReto {
	
	private ConstantsReto() {
		throw new IllegalStateException("ConstantsSura class");
	}

	// Errores Generales
    public static final int CODE_OK = 1200;
    public static final String MSG_OK = "Success";
 
    public static final int CODIGO_ERROR = 1500;
    public static final String MENSAJE_ERROR = "Error Generico";
 
    public static final int CODIGO_ERROR_COMUNICACION_SERVICIOS = 1501;
    public static final String MENSAJE_ERROR_COMUNICACION_SERVICIOS = "Error Conexión Servicios";
    
	public static final int CODIGO_ERROR_DATAPOWER = 1502;
	public static final String MENSAJE_ERROR_DATAPOWER = "Error DataPower message: ";
	
	public static final int CODIGO_ERROR_NULLPOINTER = 1503;
	public static final String MENSAJE_ERROR_NULLPOINTER = "Algún parámetro es nulo: ";
 
    public static final int CODIGO_CAMPO_MAL_FORMADO = 1400;
    public static final String MENSAJE_CAMPO_MAL_FORMADO = "campos malformados ingresados";
 
    public static final int CODIGO_BODY_NO_VALIDO = 1401;
    public static final String MENSAJE_BODY_NO_VALIDO = "El Body enviado no es valido";
 
    public static final int CODIGO_PARAMETRO_TIPO_NO_VALIDO = 1402;
    public static final String MENSAJE_PARAMETRO_TIPO_NO_VALIDO = " debe ser de tipo ";
 
    public static final int CODIGO_PARAMETRO_OBLIGATORIO = 1403;
    public static final String MENSAJE_PARAMETRO_OBLIGATORIO = " debe ser obligatorio ";
 
    // Errores Intermedios
    public static final int CODIGO_S3_ERROR_LECTURA = 1404;
    public static final String MENSAJE_S3_ERROR_LECTURA = "Error de lectura de archivo en S3";
 
    public static final int CODIGO_PDF_ERROR_GENERACION = 1405;
    public static final String MENSAJE_PDF_ERROR_GENERACION = "Error de generación de pdf";
 
    public static final int CODIGO_AWS_SECRETS_ERROR_LECTURA = 1406;
    public static final String MENSAJE_AWS_SECRETS_ERROR_LECTURA = "Error de lectura de Secretos en AWS";
 
    public static final int CODIGO_SECRETO_ERROR_DESENCRIPTAR = 1407;
    public static final String MENSAJE_SECRETO_ERROR_DESENCRIPTAR = "Error desencriptar secretos";
 
    public static final int CODIGO_CUSPP_NO_VALIDO = 1408;
    public static final String MENSAJE_CUSPP_NO_VALIDO = "El cuspp ingresado no tiene el formato correcto";
 
    public static final int CODIGO_CANTIDAD_CARACTERES_CUSPP = 1409;
    public static final String MENSAJE_CANTIDAD_CARACTERES_CUSPP = "El cussp debe tener máximo 16 caracteres";
 
    public static final int CODIGO_AFILIADO_NO_OBTENIDO = 1410;
    public static final String MENSAJE_AFILIADO_NO_OBTENIDO = "No se encontraron datos del Afiliado";
 
    public static final int CODIGO_RENTABILIDAD_NO_OBTENIDO = 1411;
    public static final String MENSAJE_RENTABILIDAD_NO_OBTENIDO = "No se encontraron datos en web service Rentabilidad";
 
    
    public static final int CODIGO_SOLICITUD_NO_OBTENIDO = 6030;
    public static final String MENSAJE_SOLICITUD_NO_OBTENIDO = "No se encontraron datos de la solicitud";
    
    public static final int CODIGO_CORRELATIVO_NO_OBTENIDO = 6031;
    public static final String MENSAJE_CORRELATIVO_NO_OBTENIDO = "No se encontro el codigo interno para realizar su consulta";
    
    public static final int CODIGO_ERROR_SOLICITUD_NO_REGISTRADA = 6032;
	public static final String MENSAJE_ERROR_SOLICITUD_NO_REGISTRADA = "La solicitud no se registró... Error al enviar el comando: ";
	
	public static final int CODIGO_SOLICITUD_EXISTE = 6033;
    public static final String MENSAJE_SOLICITUD_EXISTE = "No se puede registrar... Ya existe solicitud con el idExpediente: ";
    
    public static final int CODIGO_CLIENTE_NO_OBTENIDO = 6034;
    public static final String MENSAJE_CLIENTE_NO_OBTENIDO = "No se encontró cliente con el código indicado";
    
    
}
