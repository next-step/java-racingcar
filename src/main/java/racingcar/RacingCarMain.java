package racingcar;

import java.util.List;
import java.util.Scanner;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarMain {
	public static void main(String[] args) {
		InputView input = new InputView();
		OutputView output = new OutputView();
		String carNames = input.setCarNames();
		int trialNumber = input.setTrialNumber();

		RacingCars racingCars = new RacingCars(carNames);
		for (int i = 0; i < trialNumber; i++) {
			List<Car> cars = racingCars.moveCars();
			output.moveCars(cars);
		}
		String winners = racingCars.getWinners();
		output.printWinners(winners);
	}
}
