package carRacing;

import java.util.ArrayList;

import carRacing.domain.Car;
import carRacing.domain.CarRacing;
import carRacing.domain.Location;
import carRacing.domain.Name;
import carRacing.ui.InputView;

public class CarRacingMain {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		String[] carNames = inputView.inputCarNames();

		CarRacing carRacing = new CarRacing(new ArrayList<>());

		for (String carName : carNames) {
			carRacing.addCar(new Car(new Name(carName), new Location(0)));
		}

		int tryCount = inputView.inputTryCount();
		while (tryCount-- > 0) {
			carRacing.moveCars();
		}
	}
}
