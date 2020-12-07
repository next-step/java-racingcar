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
		for (int i = 0; i < tryCount; i++) {
			cars.move();
			ResultView.printMoveResult(cars.getMoveResult());
		}
	}

	private static List<String> parseNames(String carNames) {
		return Arrays.asList(carNames.split(NAME_SEPARATOR));
	}
}
