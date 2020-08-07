package simpleracing.exception;

public class CarRacingException extends RuntimeException {
	public CarRacingException() {
		super();
	}

	public CarRacingException(Throwable throwable) {
		super(throwable);
	}

	public CarRacingException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public CarRacingException(String message) {
		super(message);
	}
}
