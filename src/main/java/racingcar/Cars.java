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

	public void moveCars(MovingStrategy movingStrategy) {
		for (Car car : cars) {
			car.go(movingStrategy);
		}
	}

	public List<Integer> getCarsLocation() {
		return cars.stream()
			.map(Car::getLocation)
			.toList();
	}
}
