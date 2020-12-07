package racingcar;

public class ResultView {
	private static final String RESULT_HEADER = "실행결과";
	private static final String MOVE_SYMBOL = "-";
	private static final String SEPARATOR_NAME_AND_RESULT = " : ";
	private static final String SEPARATOR_WINNERS_NAME = ", ";
	private static final String ANNOUNCEMENT_WINNER = "가 최종 우승했습니다.";

	public static void printResultHeader() {
		System.out.println(RESULT_HEADER);
	}

	public static void printMoveResult(RacingResults results) {
		for (RacingResult result : results.getResults()) {
			printMove(result);
		}
		System.out.println();
	}

	public static void printWinner(RacingResults results) {
		String winners = String.join(SEPARATOR_WINNERS_NAME, results.winners());
		System.out.println(winners + ANNOUNCEMENT_WINNER);
	}

	private static void printMove(RacingResult result) {
		System.out.print(result.getName());
		System.out.print(SEPARATOR_NAME_AND_RESULT);
		for (int i = 0; i < result.getMoveCount(); i++) {
			System.out.print(MOVE_SYMBOL);
		}
		System.out.println();
	}
}
