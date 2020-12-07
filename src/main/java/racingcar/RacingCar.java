package racingcar;

public class RacingCar {
	public static void run() {
		int carCount = InputView.totalCarCount();
		int tryCount = InputView.totalTryCount();

		ResultView.printResultHeader();

		Cars cars = new Cars(carCount, new RandomNumberGenerator());
		for (int i = 0; i < tryCount; i++) {
			cars.move();
			ResultView.printMoveResult(cars.getMoveResult());
		}
	}
}
