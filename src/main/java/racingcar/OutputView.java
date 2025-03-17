package racingcar;

public class OutputView {
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String CAR_DISTANCE_SYMBOL = "-";

	private OutputView() {
		throw new UnsupportedOperationException("유틸 클래스의 인스턴스를 생성할 수 없습니다.");
	}

	public static void printResultMessage() {
		System.out.println();
		System.out.println(RESULT_MESSAGE);
	}

	public static void printCarDistance(int distance) {
		System.out.println(CAR_DISTANCE_SYMBOL.repeat(distance));
	}

	public static void printEndOneRound() {
		System.out.println();
	}

}
