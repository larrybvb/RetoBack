package pe.com.armadillo.ws.reto;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import feign.FeignException;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import pe.com.armadillo.ws.reto.domain.exception.ErrorBody;
import pe.com.armadillo.ws.reto.domain.exception.RetoException;
import pe.com.armadillo.ws.reto.domain.response.BodyResponse;
import pe.com.armadillo.ws.reto.infrastructure.util.Constants;
import pe.com.armadillo.ws.reto.infrastructure.util.ConstantsReto;

@Slf4j
@ControllerAdvice
public class ExceptionAdviceConfig {
	
	@ExceptionHandler(RetoException.class)
    public final ResponseEntity<Object> clienteBaseException(RetoException ex, WebRequest request) {
		printInConsole(ex);
        List<ErrorBody> errorResponse = new ArrayList<>();
        errorResponse.add( ErrorBody.builder().code(String.valueOf(ex.getCode())).message(ex.getMessage()).build() );
        BodyResponse<Object> exceptionResponse = BodyResponse.builder()
                .statusResponse(Boolean.FALSE)
                .statusResponseCode(Integer.valueOf(ex.getCode()))
                .statusResponseMessage(ex.getMessage())
                .statusResponseBody(null)
                .responseErrors(errorResponse)
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }
	
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllRunExceptions(Exception ex, WebRequest request) {
		printInConsole(ex);
        BodyResponse<Object> exceptionResponse = BodyResponse.builder()
                .statusResponse(Boolean.FALSE)
                .statusResponseCode(ConstantsReto.CODIGO_ERROR)
                .statusResponseMessage(ConstantsReto.MENSAJE_ERROR)
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }
	
	@ExceptionHandler(FeignException.class)
    public final ResponseEntity<Object> handleAllFeignExceptions(FeignException ex, WebRequest request) {
		printInConsole(ex);
		BodyResponse<Object> exceptionResponse = BodyResponse.builder()
                .statusResponse(Boolean.FALSE)
                .statusResponseCode(ConstantsReto.CODIGO_ERROR_COMUNICACION_SERVICIOS)
                .statusResponseMessage(ConstantsReto.MENSAJE_ERROR_COMUNICACION_SERVICIOS.concat(Constants.ESPACIO).concat(ex.getMessage()))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }
	
	@ExceptionHandler(RetryableException.class)
    public final ResponseEntity<Object> retryableException(RetryableException ex, WebRequest request) {
		printInConsole(ex);
		BodyResponse<Object> exceptionResponse = BodyResponse.builder()
                .statusResponse(Boolean.FALSE)
                .statusResponseCode(ConstantsReto.CODIGO_ERROR_COMUNICACION_SERVICIOS)
                .statusResponseMessage(ConstantsReto.MENSAJE_ERROR_COMUNICACION_SERVICIOS.concat(Constants.ESPACIO).concat(ex.getMessage()))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<Object> cocoBaseException(HttpMessageNotReadableException ex, WebRequest request) {
		printInConsole(ex);
		BodyResponse<Object> exceptionResponse = BodyResponse.builder()
                .statusResponse(Boolean.FALSE)
                .statusResponseCode(ConstantsReto.CODIGO_BODY_NO_VALIDO)
                .statusResponseMessage(ConstantsReto.MENSAJE_BODY_NO_VALIDO)
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<Object> cocoBaseException(MethodArgumentTypeMismatchException ex, WebRequest request) {
    	printInConsole(ex);
    	BodyResponse<Object> exceptionResponse = BodyResponse.builder()
                .statusResponse(Boolean.FALSE)
                .statusResponseCode(Integer.valueOf(ConstantsReto.CODIGO_PARAMETRO_TIPO_NO_VALIDO))
                .statusResponseMessage(ex.getName() + ConstantsReto.MENSAJE_PARAMETRO_TIPO_NO_VALIDO + ex.getRequiredType().getName())
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public final ResponseEntity<Object> missingRequestHeaderException(MissingRequestHeaderException ex, WebRequest request) {
    	printInConsole(ex);
    	BodyResponse<Object> exceptionResponse = BodyResponse.builder()
                .statusResponse(Boolean.FALSE)
                .statusResponseCode(ConstantsReto.CODIGO_PARAMETRO_OBLIGATORIO)
                .statusResponseMessage(ex.getHeaderName() + ConstantsReto.MENSAJE_PARAMETRO_OBLIGATORIO)
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<Object> argumentosNoValidos(MethodArgumentNotValidException ex, WebRequest request) {
    	printInConsole(ex);
        List<ErrorBody> errorList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName;
            try {
                fieldName = ((FieldError) error).getField();
            } catch (Exception e) {
                fieldName = "crossFieldsValidation" + error.hashCode();
            }
            String errorMessage = error.getDefaultMessage();
            errorList.add( ErrorBody.builder().code(fieldName).message(errorMessage).build() );
        });
        BodyResponse<Object> exceptionResponse = BodyResponse.builder()
                .statusResponse(Boolean.FALSE)
                .statusResponseCode(ConstantsReto.CODIGO_CAMPO_MAL_FORMADO)
                .statusResponseMessage(ConstantsReto.MENSAJE_CAMPO_MAL_FORMADO)
                .responseErrors(errorList)
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }
    
    
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> constraintsNoValidos(ConstraintViolationException ex, WebRequest request) {
    	printInConsole(ex);
        List<ErrorBody> errorList = new ArrayList<>();
        ex.getConstraintViolations().forEach(error -> {
        	String queryParamPath = error.getPropertyPath().toString();
            String queryParam = queryParamPath.contains(".") ?
                    queryParamPath.substring(queryParamPath.indexOf(".") + 1) :
                    queryParamPath;
            String errorMessage = error.getMessage();
            errorList.add( ErrorBody.builder().code(queryParam).message(errorMessage).build() );
        });
        BodyResponse<Object> exceptionResponse = BodyResponse.builder()
                .statusResponse(Boolean.FALSE)
                .statusResponseCode(ConstantsReto.CODIGO_CAMPO_MAL_FORMADO)
                .statusResponseMessage(ConstantsReto.MENSAJE_CAMPO_MAL_FORMADO)
                .responseErrors(errorList)
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public final ResponseEntity<Object> argumentosNoValidos(MissingServletRequestParameterException ex, WebRequest request) {
    	printInConsole(ex);
        List<ErrorBody> errorList = new ArrayList<>();
        errorList.add( ErrorBody.builder()
                .code(ex.getParameterName())
                .message(ex.getParameterName() + " is obligatory")
                .build() );
        BodyResponse<Object> exceptionResponse = BodyResponse.builder()
                .statusResponse(Boolean.FALSE)
                .statusResponseCode(ConstantsReto.CODIGO_CAMPO_MAL_FORMADO)
                .statusResponseMessage(ConstantsReto.MENSAJE_CAMPO_MAL_FORMADO)
                .responseErrors(errorList)
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
    }
    
	private void printInConsole(Exception ex){
        log.error("EXCEPTION message: {}",ex.getMessage());
        log.error("EXCEPTION class: {}",ex.getClass());
        log.error("EXCEPTION localized message: {}",ex.getLocalizedMessage());
        StackTraceElement[] printError = ex.getStackTrace();
        log.error("EXCEPTION FileName: {} - MethodName: {} - LineNumber: {} ",
                printError[0].getFileName(), printError[0].getMethodName(), printError[0].getLineNumber() );
    }

}
