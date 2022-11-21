package prohvataeva.springbootrest.advice;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import prohvataeva.springbootrest.exception.InvalidCredentials;
import prohvataeva.springbootrest.exception.UnauthorizedUser;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentials(InvalidCredentials e) {
        return new ResponseEntity<>("User name or password is empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUser(UnauthorizedUser e) {
        return new ResponseEntity<>("Unknown user", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> bindExceptionHandler(BindException e) {
        return new ResponseEntity<>(
                e.getAllErrors().stream().map(ex -> ex.unwrap(ConstraintViolationImpl.class))
                        .map(constraintViolation -> "Message for field " + constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage())
                        .collect(Collectors.joining("\n")),
                HttpStatus.BAD_REQUEST);
    }

}
