package racingcar;

public class InputView {
	private static final String CAR_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
	private static final String ROUND_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";

	private InputView() {
		throw new UnsupportedOperationException("유틸 클래스의 인스턴스를 생성할 수 없습니다.");
	}

	public static void printCarInputMessage() {
		System.out.println(CAR_INPUT_MESSAGE);
	}

	public static void printRoundInputMessage() {
		System.out.println(ROUND_INPUT_MESSAGE);
	}

}
