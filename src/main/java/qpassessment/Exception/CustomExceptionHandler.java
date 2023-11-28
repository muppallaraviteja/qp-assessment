package qpassessment.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails details = new ErrorDetails(request.getDescription(false), ex.getMessage(), LocalDate.now());
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllCustomException(Exception ex, WebRequest request) throws Exception {;
        ErrorDetails details = new ErrorDetails(request.getDescription(false), ex.getMessage(), LocalDate.now());
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String s = ex.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(" "));
        ErrorDetails details = new ErrorDetails(request.getDescription(false),s, LocalDate.now());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
}