package pe.com.armadillo.ws.reto.infrastructure.util;

import java.util.ArrayList;

import pe.com.armadillo.ws.reto.domain.exception.RetoException;
import pe.com.armadillo.ws.reto.domain.response.BodyResponse;

public class RetoUtils {

	private RetoUtils() {
	}
	
	@SuppressWarnings("rawtypes")
	public static BodyResponse responseSuccess(Object object) {
        return BodyResponse.builder()
                .statusResponse(Boolean.TRUE)
                .statusResponseCode(ConstantsReto.CODE_OK)
                .statusResponseMessage(ConstantsReto.MSG_OK)
                .statusResponseBody(object)
                .responseErrors(new ArrayList<>())
                .build();
    }
	
	public static void generateSuraException(Integer code, String message, Object object){
            throw new RetoException(code, message, object);
    }
	
}
