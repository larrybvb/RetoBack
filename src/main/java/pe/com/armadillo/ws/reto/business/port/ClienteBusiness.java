package pe.com.armadillo.ws.reto.business.port;

import pe.com.armadillo.ws.reto.domain.request.ClienteRequest;
import pe.com.armadillo.ws.reto.domain.response.ClienteResponse;
import pe.com.armadillo.ws.reto.domain.response.RetoResponse;

public interface ClienteBusiness {

	public ClienteResponse obtenerCliente(Long codigoUnico);
	public RetoResponse crearCliente(ClienteRequest clienteRequest);
	public RetoResponse actualizarCliente(ClienteRequest clienteRequest);
}
