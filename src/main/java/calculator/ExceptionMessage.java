package calculator;

public enum ExceptionMessage {

	INVALID_OPERATOR("유효한 연산자가 아닙니다. 연산자는 '+', '-', '*', '/' 중 하나여야 합니다."),
	INVALID_INPUT_TEXT("입력하신 수식이 유효하지 않습니다."),
	DIVIDE_BY_ZERO("0으로 나눌 수 없습니다.");

	private final String text;

	ExceptionMessage(String text) {
		this.text = text;
	}

	public String text() {
		return text;
	}

}
