package step4;

public class ResultView {
	private static final String MOVE_MARK = "-";
	private static final StringBuilder score = new StringBuilder();

	public static void printRacingResult() {
		System.out.println(score);
	}

	public static void saveRoundResult(Cars participants) {
		for (Car car : participants.getRacingCars()) {
			saveCarScore(car) ;
		}
		nextRound();
	}

	public static void printWinner(Cars winners) {
		StringBuilder winnerName = new StringBuilder();
		for (Car winner : winners.getRacingCars()) {
			winnerName.append(winner.getName()).append(", ");
		}
		winnerName.deleteCharAt(winnerName.length() - 2);
		System.out.println(winnerName + "(이)가 최종 우승했습니다.");
	}

	private static void saveCarScore(Car car) {
		score.append(car.getName()).append(" : ");
		for (int i = 0; i < car.getRecord(); i++) {
			score.append(MOVE_MARK);
		}
		score.append(System.lineSeparator());
	}

	private static void nextRound() {
		score.append(System.lineSeparator());
	}

}
