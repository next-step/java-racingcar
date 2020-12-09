package race.domain;

public class IllegalInputNameException extends IllegalArgumentException {
	public static final String ILLEGAL_INPUT_FORMAT_MESSAGE = "자동차 이름은 %d자를 초과할 수 없습니다.";

	@Override
	public String getMessage() {
		return String.format(ILLEGAL_INPUT_FORMAT_MESSAGE, CarName.MAX_INPUT_NAME_LENGTH);
	}
}
