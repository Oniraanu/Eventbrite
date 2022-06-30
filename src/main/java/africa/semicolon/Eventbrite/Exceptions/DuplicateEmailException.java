package africa.semicolon.Eventbrite.Exceptions;

public class DuplicateEmailException extends RuntimeException{

    public DuplicateEmailException(String message) {
        super(message);
    }
}
