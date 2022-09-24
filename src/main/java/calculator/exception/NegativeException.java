package calculator.exception;

public class NegativeException extends NumberException {

	public NegativeException() {
		super("음수는 사용할 수 없습니다");
	}
}
