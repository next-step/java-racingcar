package racingcar.view;

import racingcar.model.RacingGame;

public class ResultView {
	public static void print(RacingGame racingGame) {
		System.out.println(racingGame.getCurrentGameStatus());
	}

	public static void printTitleAndWaitingCars(RacingGame racingGame) {
		System.out.println("\n실행 결과");
		print(racingGame);
	}
}
