package racing.exception;

import java.util.NoSuchElementException;

public class NoSuchWinnerException extends NoSuchElementException {

	public NoSuchWinnerException(ErrorMessage errorMessage) {
		super(errorMessage.getErrorMessage());
	}
}
