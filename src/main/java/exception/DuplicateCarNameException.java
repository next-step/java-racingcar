package exception;

public class DuplicateCarNameException extends RuntimeException {
	public DuplicateCarNameException(String message) {
		super(message);
	}
}
