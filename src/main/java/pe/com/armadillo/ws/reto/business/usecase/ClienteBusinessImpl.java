package pe.com.armadillo.ws.reto.business.usecase;



import static pe.com.armadillo.ws.reto.infrastructure.util.ConstantsReto.CODIGO_CLIENTE_NO_OBTENIDO;
import static pe.com.armadillo.ws.reto.infrastructure.util.ConstantsReto.MENSAJE_CLIENTE_NO_OBTENIDO;

import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.armadillo.ws.reto.business.port.ClienteBusiness;
import pe.com.armadillo.ws.reto.domain.entity.Cliente;
import pe.com.armadillo.ws.reto.domain.request.ClienteRequest;
import pe.com.armadillo.ws.reto.domain.response.ClienteResponse;
import pe.com.armadillo.ws.reto.domain.response.RetoResponse;
import pe.com.armadillo.ws.reto.infrastructure.dataconsumer.datapower.port.ClienteRepository;
import pe.com.armadillo.ws.reto.infrastructure.util.ClienteMappersUtil;
import pe.com.armadillo.ws.reto.infrastructure.util.RetoUtils;

@Service
public class ClienteBusinessImpl implements ClienteBusiness{
	
	@Autowired
    private ClienteRepository clienteRepository;

	@Override
	public ClienteResponse obtenerCliente(Long codigoUnico) {
		Optional<Cliente> cliente = clienteRepository.findById(codigoUnico);
		if(ObjectUtils.isEmpty(cliente.get())) {
			RetoUtils.generateSuraException(
					CODIGO_CLIENTE_NO_OBTENIDO, 
					MENSAJE_CLIENTE_NO_OBTENIDO, 
					null);
		}
		return ClienteMappersUtil.clienteToClienteResponse(cliente.get()) ;
	}

	@Override
	public RetoResponse crearCliente(ClienteRequest clienteRequest) {
		Cliente cliente = clienteRepository.save(ClienteMappersUtil.clienteRequestToCliente(clienteRequest));
		 return RetoResponse.builder()
		 .id(cliente.getCodigoUnico().toString())
		 .mensaje("persona creada con codigo único: "+cliente.getCodigoUnico().toString())
		 .build();
	}

	@Override
	public RetoResponse actualizarCliente(ClienteRequest clienteRequest) {
		
		Cliente cliente = clienteRepository.save(ClienteMappersUtil.clienteRequestToClienteForUpdate(clienteRequest));
		 return RetoResponse.builder()
		 .id(cliente.getCodigoUnico().toString())
		 .mensaje("persona actualizada con codigo único: "+cliente.getCodigoUnico().toString())
		 .build();
	}

}
