package calculator.exception;

public enum ErrorMessage {
	POSITIVE_CAN_NOT_BE_NEGATIVE("양수 객체는 음수일 수 없습니다.");

	private final String errorMessage;

	ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}
}

