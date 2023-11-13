package pe.com.armadillo.ws.reto.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RetoException extends RuntimeException {

	private static final long serialVersionUID = -613588764832839729L;
    private int code;
    private String message;
    private Object success;

}
