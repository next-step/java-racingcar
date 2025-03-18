package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(String namesInput) {
		String[] names = namesInput.split(",");

		List<Car> tempCars = new ArrayList<>();
		for (String name : names) {
			tempCars.add(new Car(name.trim()));
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
