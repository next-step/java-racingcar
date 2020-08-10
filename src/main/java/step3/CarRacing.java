package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

	public static void main(String[] args) {
		int carCount = InputView.requestHowManyCar();
		int times = InputView.requestHowManyTimes();

		List<Car> cars = getNewCars(carCount);
		for (int i = 0; i < times; i++) {
			Round.play(cars);
		}

		ResultView.printResult();
	}

	public static List<Car> getNewCars(int carCount) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car());
		}
		return cars;
	}

}
