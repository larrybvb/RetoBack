package pe.com.armadillo.ws.reto.infrastructure.util;

import pe.com.armadillo.ws.reto.domain.entity.Cliente;
import pe.com.armadillo.ws.reto.domain.request.ClienteRequest;
import pe.com.armadillo.ws.reto.domain.response.ClienteResponse;

public class ClienteMappersUtil {
	
	private ClienteMappersUtil() {
		
	}
	
	public static Cliente clienteRequestToCliente(ClienteRequest clienteRequest) {
		return Cliente.builder()
				//.codigoUnico(clienteRequest.getPayload().getCliente().getCodigoUnico())
				.nombres(clienteRequest.getPayload().getCliente().getNombres())
				.apellidos(clienteRequest.getPayload().getCliente().getApellidos())
				.tipoDocumento(clienteRequest.getPayload().getCliente().getTipoDocumento())
				.numeroDocumento(clienteRequest.getPayload().getCliente().getNumeroDocumento())
				.build();
	}
	
	public static ClienteResponse clienteToClienteResponse(Cliente cliente) {
		return ClienteResponse.builder()
				//.codigoUnico(cliente.getCodigoUnico())
				.nombres(cliente.getNombres())
				.apellidos(cliente.getApellidos())
				.tipoDocumento(cliente.getTipoDocumento())
				.numeroDocumento(cliente.getNumeroDocumento())
				.build();
	}
	
	
	public static Cliente clienteRequestToClienteForUpdate(ClienteRequest clienteRequest) {
		return Cliente.builder()
				.codigoUnico(clienteRequest.getPayload().getCliente().getCodigoUnico())
				.nombres(clienteRequest.getPayload().getCliente().getNombres())
				.apellidos(clienteRequest.getPayload().getCliente().getApellidos())
				.tipoDocumento(clienteRequest.getPayload().getCliente().getTipoDocumento())
				.numeroDocumento(clienteRequest.getPayload().getCliente().getNumeroDocumento())
				.build();
	}

}
