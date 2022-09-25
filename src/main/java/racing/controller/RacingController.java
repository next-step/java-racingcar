package racing.controller;

import racing.model.Car;
import racing.model.Racing;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class RacingController {

	public void run() {
		List<Car> cars = InputView.generateCars();
		int times = InputView.inputTimes();
		Racing racing = new Racing(cars);

		for (int i = 0; i < times; i++) {
			racing.race();
			OutputView.printCarsPosition(cars);
		}
	}
}
