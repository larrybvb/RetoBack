package pe.com.armadillo.ws.reto.domain.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.armadillo.ws.reto.domain.exception.ErrorBody;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BodyResponse<A> {

    private boolean statusResponse;
    private int statusResponseCode;
    private String statusResponseMessage;
    private A statusResponseBody;
    private List<ErrorBody> responseErrors;

}
