package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingCar {
	private static final String NAME_SEPARATOR = ",";
	public static void run() {
		String carNames = InputView.totalCarNames();
		int tryCount = InputView.totalTryCount();

		ResultView.printResultHeader();

		List<String> carNameList = parseNames(carNames);
		Cars cars = new Cars(carNameList, new RandomNumberGenerator());
		RacingResults racingResults = cars.racingResults();
		for (int i = 0; i < tryCount; i++) {
			cars.move();
			racingResults = cars.racingResults();
			ResultView.printMoveResult(racingResults);
		}
		ResultView.printWinner(racingResults);
	}

	private static List<String> parseNames(String carNames) {
		return Arrays.asList(carNames.split(NAME_SEPARATOR));
	}
}
