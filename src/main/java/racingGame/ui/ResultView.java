package racingGame.ui;

import java.util.List;
import java.util.Map;

public class ResultView {
	private static final String RESULT_MSG = "실행 결과";
	private static final String WINNER_MSG = "가 최종 우승했습니다.";

	public void printResultStart() {
		System.out.println(RESULT_MSG);
	}

	public void printResult(Map<String, Integer> carPositions) {
		carPositions.forEach((racer, distance) -> {
			System.out.print(racer);
			System.out.print(" : ");
			System.out.println(getCarMarkerString(distance));
		});
	}

	private String getCarMarkerString(int car) {
		StringBuilder carMarker = new StringBuilder();
		for (int j = 0; j < car; j++) {
			carMarker.append("-");
		}
		return carMarker.toString();
	}

	public void printWinner(List<String> winners) {
		System.out.println(String.join(", ", winners) + WINNER_MSG);
	}
}
