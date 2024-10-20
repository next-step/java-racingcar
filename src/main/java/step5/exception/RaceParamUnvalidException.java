package step5.exception;

public class RaceParamUnvalidException extends RuntimeException {
	public static final String message = "올바른 값을 입력해주세요.";

	@Override
	public String getMessage() {
		return message;
	}
}
