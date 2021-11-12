package study.racingcar;

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
