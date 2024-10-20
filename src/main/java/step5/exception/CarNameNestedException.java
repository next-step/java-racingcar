package step5.exception;

public class CarNameNestedException extends RuntimeException {
	public static final String message = "중복된 자동차 이름을 제거해주세요.";

	@Override
	public String getMessage() {
		return message;
	}
}
