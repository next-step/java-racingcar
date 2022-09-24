package calculator.exception;

public class NotANumberException extends NumberException {

	public NotANumberException() {
		super("숫자가 아닌 문자가 있습니다");
	}
}
