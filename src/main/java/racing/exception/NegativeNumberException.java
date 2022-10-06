package racing.exception;

import java.text.MessageFormat;

public class NegativeNumberException extends RuntimeException {

	public NegativeNumberException(ErrorMessage errorMessage, int arg) {
		super(MessageFormat.format(errorMessage.getErrorMessage(), arg));
	}
}
