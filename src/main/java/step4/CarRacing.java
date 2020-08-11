package step4;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

	public static void main(String[] args) {
		String[] carsName = InputView.requestCarsName();
		int times = InputView.requestHowManyTimes();

		List<Car> cars = getNewCars(carsName);
		for (int i = 0; i < times; i++) {
			Round.play(cars);
		}

		ResultView.printResult();
	}

	public static List<Car> getNewCars(String[] carsName) {
		List<Car> cars = new ArrayList<>();
		for (String name : carsName) {
			cars.add(new Car(name));
		}
		return cars;
	}

}
