package errors;

public class InvalidInputException extends Throwable {

    private String message;

    public InvalidInputException(String message) {
        this.message = message;
    }
}
