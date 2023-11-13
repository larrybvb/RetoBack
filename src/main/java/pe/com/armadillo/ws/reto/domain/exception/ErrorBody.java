package pe.com.armadillo.ws.reto.domain.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorBody {

    private String code;
    private String message;

}
