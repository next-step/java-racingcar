package carrase;

import java.util.List;
import java.util.Map;

public class ResultView {
	public static final String INTRO_MESSAGE_FOR_GAME_RESULT = "실행 결과";
	public static final String INTRO_MESSAGE_FOR_WINNER = "가 최종 우승했습니다.";

	private void printCarMileage(int distance) {
		for(int i = 0; i < distance; i ++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void drawMessageOfGameResult() {
		System.out.println(INTRO_MESSAGE_FOR_GAME_RESULT);
	}

	public void drawTotalResult(Map<String, Integer> gameResult) {
		gameResult.forEach((name, mileage) -> {
			System.out.print(name + " : ");
			printCarMileage(mileage);
		});
		System.out.println();
	}

	public void drawWinner(List<String> carGameWinner) {
		System.out.print(carGameWinner.get(0));
		carGameWinner.remove(0);
		carGameWinner.forEach((winner) -> System.out.print(", " + winner));
		System.out.println(INTRO_MESSAGE_FOR_WINNER);
	}
}
