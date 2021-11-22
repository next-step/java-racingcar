package study.racingcar.controller;

import java.util.List;

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
		List<String> names = InputView.inputCarNamesByUser();
		int gameRounds = InputView.inputGameRoundByUser();
		return new RacingGame(names, gameRounds, strategy);
	}


	private static void printStart() {
		ResultView.printStart();
	}

}
