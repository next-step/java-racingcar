package car;

import java.util.List;

import car.ui.InputView;
import car.ui.ResultView;

public class CarMain {

	public static void main(String[] args) {
		InputView.input();

		List<Car> cars = Car.cars();
		for (int i = 0; i < InputView.carCount; i++) {
			Car.addCar(cars);
		}

		ResultView.initPrint();
		for (int i = 0; i < InputView.tryCount; i++) {
			Car.moveCars(cars);
			ResultView.printCars(cars);
		}
	}
}
