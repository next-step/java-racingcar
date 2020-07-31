package calculator.exception;

public class CalculatorException extends RuntimeException {

	public CalculatorException() {
		super();
	}

	public CalculatorException(Throwable throwable) {
		super(throwable);
	}

	public CalculatorException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public CalculatorException(String message) {
		super(message);
	}

}
