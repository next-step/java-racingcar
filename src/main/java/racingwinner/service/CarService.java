package racingwinner.service;

import racingwinner.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

	private final List<Car> cars = new ArrayList<>();
	public CarService(String[] carNames) {
		for (String carName : carNames) {
			this.cars.add(new Car(carName.trim()));
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
