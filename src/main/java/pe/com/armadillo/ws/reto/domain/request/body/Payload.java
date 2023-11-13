package pe.com.armadillo.ws.reto.domain.request.body;



import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;
import pe.com.armadillo.ws.reto.domain.request.common.SolicitudAuditoria;

@Data
public class Payload {
	

	@NotNull(message = "Información de 'cliente' obligatoria")
	@Valid
	private Cliente cliente;

	@Valid
	@NotNull(message = "Información de 'auditoria' obligatoria")
	private SolicitudAuditoria solicitudAuditoria;
	
}
