package car;

import car.ui.InputView;
import car.ui.ResultView;

public class CarMain {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		inputView.input();

		Car car = new Car();
		for (int i = 0; i < inputView.carCount; i++) {
			car.addCar();
		}

		ResultView.initPrint();
		for (int i = 0; i < inputView.tryCount; i++) {
			car.moveCars();
			ResultView.printCars(car.getCars());
		}
	}
}
