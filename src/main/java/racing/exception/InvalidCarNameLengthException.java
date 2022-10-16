package racing.exception;

import java.text.MessageFormat;

public class InvalidCarNameLengthException extends RuntimeException {

	public InvalidCarNameLengthException(ErrorMessage errorMessage, String arg) {
		super(MessageFormat.format(errorMessage.getErrorMessage(), arg));
	}
}
