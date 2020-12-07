package racingcar;

import java.util.List;

public class ResultView {
	private static final String RESULT_HEADER = "실행결과";
	private static final String MOVE_SYMBOL = "-";

	public static void printResultHeader() {
		System.out.println(RESULT_HEADER);
	}

	public static void printMoveResult(List<Integer> moveResult) {
		for (Integer result : moveResult) {
			printMove(result);
		}
		System.out.println();
	}

	public static void printMove(int moveCount) {
		for (int i = 0; i < moveCount; i++) {
			System.out.print(MOVE_SYMBOL);
		}
		System.out.println();
	}
}
