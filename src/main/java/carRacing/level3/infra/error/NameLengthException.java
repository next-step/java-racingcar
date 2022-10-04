package carRacing.level3.infra.error;

public class NameLengthException extends RuntimeException {

	NameLengthException() {

	}

	public NameLengthException(String message) {
		super(message);
	}
}

