package study.racingcar.controller;

import study.racingcar.domain.Cars;
import study.racingcar.domain.Game;
import study.racingcar.domain.GameStatus;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class GameController {

	private GameController() {
		throw new AssertionError();
	}

	public static void start() {
		GameStatus status = initGameSetting();
		ResultView.printStart();
		status.startRacing();
	}

	private static GameStatus initGameSetting() {
		Cars cars = initCars();
		Game game = initGame();

		return new GameStatus(cars, game);
	}

	private static Game initGame() {
		int gameCount = InputView.inputGameCountByUser();
		Game game = new Game();
		game.createGameCount(gameCount);
		return game;
	}

	private static Cars initCars() {
		int carCount = InputView.inputCarCountByUser();

		Cars cars = new Cars();
		cars.createCar(carCount);
		return cars;
	}
}
