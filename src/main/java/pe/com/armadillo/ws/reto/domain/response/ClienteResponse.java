package pe.com.armadillo.ws.reto.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

	//private Long codigoUnico;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numeroDocumento;
    
}
