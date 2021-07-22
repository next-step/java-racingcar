package ragingwinner.service;

import ragingwinner.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

	private final List<Car> cars = new ArrayList<>();
	public CarService(int carCount) {
		for (int i = 0; i < carCount; i++) {
			this.cars.add(new Car());
		}
	}

	public List<Car> moveCars() {
		for (Car car : cars) {
			car.moveForward();
		}
		return cars;
	}

	public List<Car> getCars() {
		return cars;
	}

}
