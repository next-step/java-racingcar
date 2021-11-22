package study.racingcar.controller;

import study.racingcar.domain.MoveStrategy;
import study.racingcar.domain.RacingGame;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class GameController {

	private GameController() {
		throw new AssertionError();
	}

	public static void start(MoveStrategy strategy) {

		RacingGame status = readyToGame(strategy);
		printStart();
		status.playGame();

	}

	private static RacingGame readyToGame(MoveStrategy strategy) {
		int carCount = InputView.inputCarCountByUser();
		int gameRounds = InputView.inputGameRoundByUser();
		return new RacingGame(carCount, gameRounds, strategy);
	}


	private static void printStart() {
		ResultView.printStart();
	}

}
