package pe.com.armadillo.ws.reto.domain.request.body;


import lombok.Data;

@Data
public class Cliente {
	
	private Long codigoUnico;
	private String nombres;
	private String apellidos;
	private String tipoDocumento;
	private String numeroDocumento;
	    
}
