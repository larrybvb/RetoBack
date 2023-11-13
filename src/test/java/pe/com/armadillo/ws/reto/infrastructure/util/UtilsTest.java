package pe.com.armadillo.ws.reto.infrastructure.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class UtilsTest {
	@InjectMocks
	Utils utils;
	
	@Test
	void getFechaActualConFormatoBdTest() {
		assertNotNull(Utils.getFechaActualConFormatoBd());
	}

	@Test
	void getHoraActualConFormatoBdTest() {
		assertNotNull(Utils.getHoraActualConFormatoBd());
	}

	@Test
	void concatenarQueryDataPowerTest() {
		assertNotNull(Utils.concatenarQueryDataPower("", ""));
	}

	@Test
	void obtenerMensajeSolicitudTest() {
		assertNotNull(Utils.obtenerMensajeSolicitud(""));
	}
	
	@Test
	void concatenarTokenDataPowerTest() {
		assertNotNull(Utils.concatenarTokenDataPower("", ""));
	}
}
