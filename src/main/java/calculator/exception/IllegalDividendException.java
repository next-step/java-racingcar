package calculator.exception;

public class IllegalDividendException extends RuntimeException {
	public IllegalDividendException() {
		super();
	}

	public IllegalDividendException(Throwable throwable) {
		super(throwable);
	}

	public IllegalDividendException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public IllegalDividendException(String message) {
		super(message);
	}
}
