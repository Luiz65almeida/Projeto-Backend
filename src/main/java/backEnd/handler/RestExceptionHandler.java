package backEnd.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import backEnd.model.error.ErrorMesagem;
import backEnd.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
	
	public ResponseEntity<?> handleResourceNotFoundExeption (ResourceNotFoundException ex){
		
		ErrorMesagem error = new ErrorMesagem("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
	}
		
	 


}