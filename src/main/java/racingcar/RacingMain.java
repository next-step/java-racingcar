package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingMain {
	public static void main(String[] args) {
		List<Car> carList = new ArrayList<>();
		InputView input = new InputView();
		OutputView output = new OutputView();

		input.inputCarNumber(carList);
		int trialNumber = input.inputTrialNumber();
		System.out.println("Result");

		for (int i = 0; i < trialNumber; i++) {
			input.moveCars(carList);
			output.moveCars(carList);
		}
	}
}
