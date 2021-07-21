package racing.service;

import racing.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

	private final List<Car> cars = new ArrayList<>();
	private final int repeatCount;
	public CarService(int carCount, int repeatCount) {
		for (int i = 0; i < carCount; i++) {
			this.cars.add(new Car());
		}
		this.repeatCount = repeatCount;
	}

	public void moveCars() {
		for (int i = 0; i < repeatCount; i++) {
			accelerate();
		}
	}

	private void accelerate() {
		for (Car car : cars) {
			car.moveForward();
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public int getRepeatCount() {
		return repeatCount;
	}

}
