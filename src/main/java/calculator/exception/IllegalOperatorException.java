package calculator.exception;

public class IllegalOperatorException extends RuntimeException {
	public IllegalOperatorException() {
		super();
	}

	public IllegalOperatorException(Throwable throwable) {
		super(throwable);
	}

	public IllegalOperatorException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public IllegalOperatorException(String message) {
		super(message);
	}
}
