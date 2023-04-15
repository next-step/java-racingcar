package carRacing;

import java.util.ArrayList;
import java.util.List;

import carRacing.domain.Car;
import carRacing.domain.CarRacing;
import carRacing.domain.Location;
import carRacing.domain.Name;
import carRacing.ui.InputView;
import carRacing.ui.ResultView;

public class CarRacingMain {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		String[] carNames = inputView.inputCarNames();

		List<Car> cars = new ArrayList<>();
		CarRacing carRacing = new CarRacing(cars);

		for (String carName : carNames) {
			carRacing.addCar(new Car(new Name(carName), new Location(0)));
		}

		int tryCount = inputView.inputTryCount();
		ResultView resultView = new ResultView();
		while (tryCount-- > 0) {
			carRacing.moveCars();
			resultView.printStatus(cars);
		}
	}
}
