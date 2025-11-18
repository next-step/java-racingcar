package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.RacingGame;

public class OutputView {
	static void printRoundResult(RacingGame racingGame) {
		for (String result : racingGame.play()) {
			System.out.println(result);
		}
	}

	public static void printResults(int count, RacingGame racingGame) {
		System.out.println("실행 결과");

		for (int i = 0; i < count; i++) {
			printRoundResult(racingGame);
			System.out.println();
		}
	}

	public static String getPositionDisplay(Car car) {
		return "-".repeat(car.getPosition());
	}
}
