package racingcar;

import static racingcar.InputView.*;
import static racingcar.ResultView.result;

public class RacingCar {
	public static void main(String[] args) {
		String[] carNames = inputCarNames();
		int count = inputCount();

		result(carNames, count);
	}
}
