package dev.java10x.eventclean.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AppHandlerException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("Error: ", e.getMessage());
        response.put("Message", "The request event was not, check the identifier and try again");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateDataException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateDataException(DuplicateDataException e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("Error: ", e.getMessage());
        response.put("Message", "Please, insert a valid hashId for your event and try again");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
