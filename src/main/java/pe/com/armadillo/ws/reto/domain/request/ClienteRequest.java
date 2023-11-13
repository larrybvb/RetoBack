package pe.com.armadillo.ws.reto.domain.request;

import javax.validation.Valid;

import lombok.Data;
import pe.com.armadillo.ws.reto.domain.request.body.Payload;

@Data
public class ClienteRequest {

	
	@Valid
	private Payload payload;
	
}
