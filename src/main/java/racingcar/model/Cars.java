package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import racingcar.rule.MoveRule;
import racingcar.util.NumberUtils;

public class Cars {
	private final List<Car> cars;

	Cars(int numberOfCars) {
		validate(numberOfCars);

		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(Car.create());
		}
		this.cars = cars;
	}

	Cars(List<Car> cars) {
		this.cars = Collections.unmodifiableList(cars);
	}

	public static Cars create(int numberOfCars) {
		return new Cars(numberOfCars);
	}

	public static Cars create(List<Car> cars) {
		return new Cars(cars);
	}

	private static void validate(int numberOfCars) {
		if (NumberUtils.isNotPositiveNumber(numberOfCars)) {
			throw new IllegalArgumentException("numberOfCars must be positive number");
		}
	}

	public void move(MoveRule moveRule) {
		cars.forEach(car -> car.move(moveRule));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Cars cars1 = (Cars)o;

		return Objects.equals(cars, cars1.cars);
	}

	@Override
	public int hashCode() {
		return cars != null ? cars.hashCode() : 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Car car : cars) {
			builder.append(car);
			builder.append("\n");
		}
		return builder.toString();
	}
}
