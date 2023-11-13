package pe.com.armadillo.ws.reto.infrastructure.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.armadillo.ws.reto.business.port.ClienteBusiness;
import pe.com.armadillo.ws.reto.domain.request.ClienteRequest;
import pe.com.armadillo.ws.reto.domain.response.RetoResponse;
import pe.com.armadillo.ws.reto.domain.response.ClienteResponse;
import pe.com.armadillo.ws.reto.domain.response.BodyResponse;
import pe.com.armadillo.ws.reto.infrastructure.util.RetoUtils;

@SuppressWarnings("unchecked")
@RestController
@RequestMapping(path = "/api/clientes")
@Api(value = "api para operaciones sobre Clientes", tags = "Cliente")
@Validated
public class ClienteController {

	@Autowired
	private ClienteBusiness clienteBusiness;
	
	@GetMapping("/{codigoUnico}")
	@ApiOperation(value = "Operacion: Obtener Cliente, recibe codigoUnico en URI") 
	public ResponseEntity<BodyResponse<ClienteResponse>> obtenerCliente(@PathVariable (value = "codigoUnico") Long codigoUnico) {
		ClienteResponse response = clienteBusiness.obtenerCliente(codigoUnico);
		return new ResponseEntity<>(RetoUtils.responseSuccess(response), HttpStatus.OK);
	}
	
	@GetMapping
	@ApiOperation(value = "Operacion: Obtener Cliente, recibe codigoUnico como parametro") 
	public ResponseEntity<BodyResponse<ClienteResponse>> buscarCliente(@RequestParam(value = "codigoUnico") Long codigoUnico) {
		ClienteResponse response = clienteBusiness.obtenerCliente(codigoUnico);
		return new ResponseEntity<>(RetoUtils.responseSuccess(response), HttpStatus.OK);
	}
	
	@PostMapping
	@ApiOperation(value = "Operacion: Registrar Cliente, recibe ClienteRequest")
	public ResponseEntity<BodyResponse<RetoResponse>> crearCliente(@RequestBody @Valid ClienteRequest clienteRequest) {
		RetoResponse response = clienteBusiness.crearCliente(clienteRequest);
		return new ResponseEntity<>(RetoUtils.responseSuccess(response), HttpStatus.OK);
	}
	
	@PutMapping
	@ApiOperation(value = "Operacion: Actualizar Cliente, recibe ClienteRequest")
	public ResponseEntity<BodyResponse<RetoResponse>> actualizarCliente(@RequestBody @Valid ClienteRequest clienteRequest) {
		RetoResponse response = clienteBusiness.actualizarCliente(clienteRequest);
		return new ResponseEntity<>(RetoUtils.responseSuccess(response), HttpStatus.OK);
	}
	
	

	
	
}
