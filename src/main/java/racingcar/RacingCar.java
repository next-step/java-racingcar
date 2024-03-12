package racingcar;

import java.util.Scanner;

import static racingcar.InputView.*;
import static racingcar.ResultView.result;

public class RacingCar {
	private static final Scanner INPUT_VALUE = new Scanner(System.in);

	public static void main(String[] args) {
		inputCarNamesQuestion();
		String[] carNames = inputCarNames(INPUT_VALUE.nextLine());
		inputCountQuestion();
		int count = inputCount(INPUT_VALUE.nextInt());

		result(carNames, count);
	}
}
