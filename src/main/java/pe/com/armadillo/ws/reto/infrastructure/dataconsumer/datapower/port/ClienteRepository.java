package pe.com.armadillo.ws.reto.infrastructure.dataconsumer.datapower.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.armadillo.ws.reto.domain.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
