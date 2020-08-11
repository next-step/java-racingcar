package step4;

import java.util.List;

public class ResultView {
	private static final String MOVE_MARK = "-";
	private static StringBuilder score = new StringBuilder();

	public static void printResult() {
		System.out.println(score);
	}

	public static void printWinner(List<Car> winners) {
		StringBuilder winnerName = new StringBuilder();
		for (Car winner : winners) {
			winnerName.append(winner.getName()).append(", ");
		}
		winnerName.deleteCharAt(winnerName.length() - 2);
		System.out.println(winnerName + "가 최종 우승했습니다.");
	}

	public static void saveRoundScore(Car car) {
		score.append(car.getName()).append(" : ");
		for (int i = 0; i < car.getRecord(); i++) {
			score.append(MOVE_MARK);
		}
		score.append(System.lineSeparator());
	}

	public static void nextRound() {
		score.append(System.lineSeparator());
	}

}
