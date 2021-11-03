package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import racingcar.util.NumberUtils;

public class Cars {
	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars create(int numberOfCars) {
		validate(numberOfCars);

		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(Car.create());
		}
		return create(cars);
	}

	public static Cars create(List<Car> cars) {
		return new Cars(cars);
	}

	private static void validate(int numberOfCars) {
		if (NumberUtils.isNotPositiveNumber(numberOfCars)) {
			throw new IllegalArgumentException("numberOfCars must be positive number");
		}
	}
}
