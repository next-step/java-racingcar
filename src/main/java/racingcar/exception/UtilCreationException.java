package racingcar.exception;

public class UtilCreationException extends RuntimeException {
	private static final long serialVersionUID = -5133033660004772925L;

	public UtilCreationException() {
		super("Utility classes cannot be instantiated.");
	}
}
