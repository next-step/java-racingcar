package racingcar;

import java.util.List;

public class RacingCar {

	public static void run() {
		List<String> carNames = InputView.totalCarNames();
		int tryCount = InputView.totalTryCount();

		ResultView.printResultHeader();
		RacingResults racingResults = race(carNames, tryCount);
		ResultView.printWinner(racingResults);
	}

	public static RacingResults race(List<String> carNames, int tryCount) {
		Cars cars = new Cars(carNames, new RandomNumberGenerator());
		RacingResults racingResults = cars.racingResults();
		for (int i = 0; i < tryCount; i++) {
			cars.move();
			racingResults = cars.racingResults();
			ResultView.printMoveResult(racingResults);
		}
		return racingResults;
	}
}
