package racingcar.view;

import racingcar.model.RacingGame;

public class ResultView {
	public static void print(RacingGame racingGame) {
		System.out.println(racingGame);
	}

	public static void printTitleAndWatingCars(RacingGame racingGame) {
		System.out.println("\n실행 결과");
		print(racingGame);
	}
}
