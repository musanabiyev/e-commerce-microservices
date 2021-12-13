package company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountExistException extends RuntimeException {
    public AccountExistException(String message) {
        super(message);
    }
}
