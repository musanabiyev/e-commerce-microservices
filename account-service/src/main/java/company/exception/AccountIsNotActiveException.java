package company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AccountIsNotActiveException extends RuntimeException {

    private static final String message = "The User wanted update is not active!";

    public AccountIsNotActiveException() {
        super(message);
    }

    public AccountIsNotActiveException(String message) {
        super(message);
    }
}
