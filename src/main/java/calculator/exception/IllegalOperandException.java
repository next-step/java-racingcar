package calculator.exception;

public class IllegalOperandException extends RuntimeException {

	public IllegalOperandException() {
		super();
	}

	public IllegalOperandException(Throwable throwable) {
		super(throwable);
	}

	public IllegalOperandException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public IllegalOperandException(String message) {
		super(message);
	}
}
