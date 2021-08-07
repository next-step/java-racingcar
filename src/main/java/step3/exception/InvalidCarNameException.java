package step3.exception;

public class InvalidCarNameException extends RuntimeException {
	public InvalidCarNameException(String message) {
		super(message);
	}
}
