package racingcar.view;

import java.util.List;

public class OutputView {
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String CAR_DISTANCE_SYMBOL = "-";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

	private OutputView() {
		throw new UnsupportedOperationException("유틸 클래스의 인스턴스를 생성할 수 없습니다.");
	}

	public static void printResultMessage() {
		System.out.println();
		System.out.println(RESULT_MESSAGE);
	}

	public static void printCarDistance(String name, int distance) {
		System.out.println(name + " : " + CAR_DISTANCE_SYMBOL.repeat(distance));
	}

	public static void printEndOneRound() {
		System.out.println();
	}

	public static void printWinner(List<String> winners) {
		System.out.println(String.join(", ", winners) + WINNER_MESSAGE);
	}

}
