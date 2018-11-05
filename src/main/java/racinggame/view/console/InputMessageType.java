package racinggame.view.console;

/**
 * Created by hspark on 03/11/2018.
 */
public enum InputMessageType {
	CAR_AMOUNT("자동차 대수는 몇 대 인가요?"),
	TRY_COUNT("시도할 회수는 몇 회 인가요?"),
	CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

	private String message;

	InputMessageType(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
