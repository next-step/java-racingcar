package racingcar;

import static racingcar.InputView.inputCarNumber;
import static racingcar.InputView.inputCount;
import static racingcar.ResultView.result;

public class RacingCar {
	public static void main(String[] args) {
		int carNumber = inputCarNumber().nextInt();
		int count = inputCount().nextInt();

		result(carNumber, count);
	}
}
