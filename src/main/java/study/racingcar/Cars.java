package study.racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

	private final List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public void createCar(int carCount) {
		for (int i = 0; i < carCount; i++) {
			this.cars.add(new Car());
		}
	}

	public int carCount() {
		return cars.size();
	}

	public void goRace() {
		for (Car car : this.cars) {
			car.go();
			car.printRace();
		}
	}
}
