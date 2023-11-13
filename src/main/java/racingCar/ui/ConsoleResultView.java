package racingCar.ui;

import racingCar.car.Car;
import racingCar.car.Cars;

import java.util.List;

public class ConsoleResultView implements ResultView {
	@Override
	public void printPrefix() {
		System.out.println();
		System.out.println(ResultView.RESULT_PREFIX);
	}

	@Override
	public void printDistance(Cars cars) {
		List<Car> carList = cars.carList();
		for (Car car : carList) {
			System.out.println("-".repeat(car.distance));
		}
		System.out.println();
	}
}
