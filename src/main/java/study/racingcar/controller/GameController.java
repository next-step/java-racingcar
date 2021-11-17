package study.racingcar.controller;

import study.racingcar.domain.RacingGame;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class GameController {

	private GameController() {
		throw new AssertionError();
	}

	public static void start() {

		RacingGame status = readyToGame();
		printStart();
		status.playGame();

	}

	private static RacingGame readyToGame() {
		int carCount = InputView.inputCarCountByUser();
		int gameRounds = InputView.inputGameRoundByUser();
		return new RacingGame(carCount, gameRounds);
	}


	private static void printStart() {
		ResultView.printStart();
	}

}
