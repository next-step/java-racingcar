package car;

import java.util.List;

import car.ui.InputView;
import car.ui.ResultView;

public class CarMain {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		try {
			inputView.input();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

		CarFactory carFactory = new CarFactory();
		List<Car> cars = carFactory.createCars();
		String[] carNames = inputView.carNames;
		for (String carName : carNames) {
			carFactory.addCar(cars, carName);
		}

		CarRacingStadium carRacingStadium = new CarRacingStadium();
		ResultView.initPrint();
		for (int i = 0; i < inputView.tryCount; i++) {
			carRacingStadium.moveCars(cars);
			ResultView.printCurrentStatus(cars);
		}

		ResultView.printWinners(carRacingStadium.createWinners(cars, carRacingStadium.getBestLocation(cars)));
	}
}
