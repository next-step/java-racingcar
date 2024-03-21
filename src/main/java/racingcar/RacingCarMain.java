package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarMain {
	public static void main(String[] args) {
		List<Car> carList = new ArrayList<>();
		InputView input = new InputView();
		OutputView output = new OutputView();
		RacingCars racingCars = new RacingCars();

		int carNumber = input.inputCarNumber(carList);
		racingCars.addCarsToList(carList, carNumber);
		int trialNumber = input.inputTrialNumber();
		System.out.println("Result");

		for (int i = 0; i < trialNumber; i++) {
			racingCars.moveCars(carList);
			output.moveCars(carList);
		}
	}
}
