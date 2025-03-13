package racingcar;

public class OutputView {
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String CAR_MOVEMENT_SYMBOL = "-";

	public void printOutputMessage() {
		System.out.println(RESULT_MESSAGE);
	}

	public void printCarMovement(int distance) {
		System.out.println(CAR_MOVEMENT_SYMBOL.repeat(distance));
	}

}
