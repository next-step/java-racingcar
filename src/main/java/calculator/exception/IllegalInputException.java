package calculator.exception;

public class IllegalInputException extends RuntimeException {

	public IllegalInputException() {
		super();
	}

	public IllegalInputException(Throwable throwable) {
		super(throwable);
	}

	public IllegalInputException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public IllegalInputException(String message) {
		super(message);
	}

}
