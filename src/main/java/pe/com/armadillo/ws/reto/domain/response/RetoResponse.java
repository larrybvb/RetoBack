package pe.com.armadillo.ws.reto.domain.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RetoResponse {
	
	private String id;
	private String mensaje;
	
}
