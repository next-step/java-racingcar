package calculator.exception;

public abstract class NumberException extends RuntimeException {

	public NumberException(String message) {
		super(message);
	}
}