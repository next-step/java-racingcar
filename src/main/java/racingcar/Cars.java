package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(int carAmount) {
		List<Car> tempCars = new ArrayList<>();
		for (int i = 0; i < carAmount; i++) {
			tempCars.add(new Car());
		}
		this.cars = tempCars;
	}

	public void moveCars() {
		for (Car car : cars) {
			car.go();
		}
	}
}
