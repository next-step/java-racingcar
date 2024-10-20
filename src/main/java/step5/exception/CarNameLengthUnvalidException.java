package step5.exception;

public class CarNameLengthUnvalidException extends RuntimeException {
	public static final String message = "자동차 이름은 1~5 글자 사이로 작성해주세요.";

	@Override
	public String getMessage() {
		return message;
	}
}
