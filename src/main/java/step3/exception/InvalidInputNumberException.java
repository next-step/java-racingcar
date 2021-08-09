package step3.exception;

public class InvalidInputNumberException extends RuntimeException {
	private String message;

	public InvalidInputNumberException(String message) {
		super(message);
	}
}
