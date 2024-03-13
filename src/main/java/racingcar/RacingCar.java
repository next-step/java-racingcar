package racingcar;

import static racingcar.ResultView.result;

public class RacingCar {


	public static void main(String[] args) {
		InputDto countAndCarNames = InputView.getCountAndCarNames();

		int count = countAndCarNames.getCount();
		String[] carNames = countAndCarNames.getCarNames();

		result(carNames, count);
	}
}
