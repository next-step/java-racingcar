package step2.domain;

import step2.util.RandomGenerator;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

class RacingCars {

	private final List<Car> cars;

	RacingCars(List<Car> cars) {
		this.cars = cars;
	}

	void moveAllCars(RandomGenerator randomGenerator) {
		for (Car car : cars) {
			car.moveIfLucky(randomGenerator.getRandomNumber());
		}
	}

	List<Car> getCars() {
		return cars;
	}

	List<String> findWinnerNames() {
		int maxStep = cars.stream().mapToInt(Car::getStep).max().orElse(0);
		if (maxStep == 0) {
			return Collections.emptyList();
		}
		return cars.stream()
				.filter(car -> car.getStep() == maxStep)
				.map(Car::getName)
				.collect(toList());
	}

}
