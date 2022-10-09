package racing.exception;

public enum ErrorMessage {
	POSITIVE_CAN_NOT_BE_NEGATIVE("양수 객체는 음수일 수 없습니다."),
	INVALID_CAR_NAME_LENGTH("유효하지 않은 차 이름 길이 입니다."),
	NO_SUCH_WINNER("우승자가 없습니다.");

	private final String errorMessage;

	ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}
}
