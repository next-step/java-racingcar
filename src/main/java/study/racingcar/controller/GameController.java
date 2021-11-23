package study.racingcar.controller;

import java.util.List;

import study.racingcar.domain.MoveStrategy;
import study.racingcar.domain.RacingGame;
import study.racingcar.domain.RandomNumberStrategy;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class GameController {

	private static final MoveStrategy strategy = new RandomNumberStrategy();

	private GameController() {
		throw new AssertionError();
	}

	public static void start() {
		RacingGame status = readyToGame();
		printStart();
		status.playGame();
	}

	private static RacingGame readyToGame() {
		List<String> names = InputView.inputCarNamesByUser();
		int gameRounds = InputView.inputGameRoundByUser();
		return new RacingGame(names, gameRounds, strategy);
	}


	private static void printStart() {
		ResultView.printStart();
	}

}
