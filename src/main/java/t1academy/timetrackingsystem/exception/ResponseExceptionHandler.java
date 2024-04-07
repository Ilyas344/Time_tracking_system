package t1academy.timetrackingsystem.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "t1academy.timetrackingsystem")
public class ResponseExceptionHandler {
    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<?> handleInternalServerError(InternalServerException ex) {
        return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(ex.getMessage());
    }

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<?> handleResponseException(ResponseException ex) {
        return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(ex.getMessage());
    }
}
