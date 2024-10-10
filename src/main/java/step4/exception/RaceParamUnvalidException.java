package step4.exception;

public class RaceParamUnvalidException extends RuntimeException {
	private static final String message = "올바른 값을 입력해주세요. 자동차 이름은 빈값이면 안되고, 시도할 횟수는 양수여야 합니다.";

	@Override
	public String getMessage() {
		return message;
	}
}
