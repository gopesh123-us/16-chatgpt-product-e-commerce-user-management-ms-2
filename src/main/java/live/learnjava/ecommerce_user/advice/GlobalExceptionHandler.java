package live.learnjava.ecommerce_user.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import live.learnjava.ecommerce_user.exception.ResourceExistsException;
import live.learnjava.ecommerce_user.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
		log.error("Internal Server Error: {}", ex.getMessage());
		ErrorResponse errorResponse = ErrorResponse.builder(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage())
				.build();
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException rnfex) {
		log.error("Resource not found: {}", rnfex.getMessage());
		ErrorResponse errorResponse = ErrorResponse.builder(rnfex, HttpStatus.NOT_FOUND, rnfex.getMessage()).build();
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceExistsException.class)
	public ResponseEntity<ErrorResponse> handleResourceExistsException(ResourceExistsException rex) {
		log.error("Resource already exists: {}", rex.getMessage());
		ErrorResponse errorResponse = ErrorResponse.builder(rex, HttpStatus.CONFLICT, rex.getMessage()).build();
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.CONFLICT);
	}
}
