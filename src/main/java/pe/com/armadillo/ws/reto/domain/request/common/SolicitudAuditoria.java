package pe.com.armadillo.ws.reto.domain.request.common;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SolicitudAuditoria {

	@Size(min = 8, max = 8 , message = "Longitud Incorrecta")
	@NotNull
	private String fechaRegistro;
	
	@NotNull
	private String horaRegistro;
		
	@NotNull
	private String usuarioRegistro;
	
	@NotNull
	private String aplicacionOrigen;
		
}
