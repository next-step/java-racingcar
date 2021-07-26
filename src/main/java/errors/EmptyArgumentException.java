package errors;

public class EmptyArgumentException extends Throwable {

    private String message;

    public EmptyArgumentException(String message) {
        this.message = message;
    }
}
