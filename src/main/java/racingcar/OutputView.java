package racingcar;

public class OutputView {
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String CAR_DISTANCE_SYMBOL = "-";

	public void printResultMessage() {
		System.out.println();
		System.out.println(RESULT_MESSAGE);
	}

	public void printCarDistance(int distance) {
		System.out.println(CAR_DISTANCE_SYMBOL.repeat(distance));
	}

	public void printEndOneRound() {
		System.out.println();
	}

}
