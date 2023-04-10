package car;

import java.util.List;

import car.ui.InputView;
import car.ui.ResultView;

public class CarMain {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		inputView.input();

		CarFactory carFactory = new CarFactory();
		List<Car> cars = carFactory.createCars();
		for (int i = 0; i < inputView.carCount; i++) {
			carFactory.addCar(cars);
		}

		ResultView.initPrint();
		for (int i = 0; i < inputView.tryCount; i++) {
			carFactory.moveCars(cars);
			ResultView.printCarsLocation(cars);
		}
	}
}
