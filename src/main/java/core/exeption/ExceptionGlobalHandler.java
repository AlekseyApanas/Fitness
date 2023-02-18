package core.exeption;

import core.dto.SaveUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionGlobalHandler {
    @ExceptionHandler
    public ResponseEntity<SaveUserDTO> handlerNPI(NullPointerException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new SaveUserDTO());
    }

    @ExceptionHandler(value = {NullPointerException.class, ArrayIndexOutOfBoundsException.class})
    public ResponseEntity<SaveUserDTO> handlerNPISecond() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new SaveUserDTO());
    }
    @ExceptionHandler
    public ResponseEntity<SaveUserDTO> handlerNPIThird(Throwable e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new SaveUserDTO());
    }
}
