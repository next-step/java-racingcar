package step3;

public class ResultView {
	private static final String MOVE_MARK = "-";
	private static StringBuilder score = new StringBuilder();

	public static void printResult() {
		System.out.println(score);
	}

	public static void saveRoundScore(Car car) {
		for (int i = 0; i < car.getRecord(); i++) {
			score.append(MOVE_MARK);
		}
		score.append(System.lineSeparator());
	}

	public static void setNextRound() {
		score.append(System.lineSeparator());
	}

}
