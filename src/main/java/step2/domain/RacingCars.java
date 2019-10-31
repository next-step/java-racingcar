package step2.domain;

import step2.domain.rules.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

class RacingCars {

	private static final int CAR_INITIAL_STEP = 0;

	private final List<Car> cars;

	RacingCars(String[] carNames) {
		this.cars = prepareCars(carNames);
	}

	RacingCars(List<Car> cars) {
		this.cars = cars;
	}

	private List<Car> prepareCars(String[] carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName, CAR_INITIAL_STEP));
		}
		return cars;
	}

	void moveAllCars(NumberGenerator numberGenerator) {
		for (Car car : cars) {
			car.move(numberGenerator.generate());
		}
	}

	List<Car> getCars() {
		return cars;
	}

	List<String> findWinnerNames() {
		int maxStep = cars.stream()
				.mapToInt(Car::getStep)
				.max()
				.orElse(CAR_INITIAL_STEP);
		if (maxStep == CAR_INITIAL_STEP) {
			return Collections.emptyList();
		}

		return cars.stream()
				.filter(car -> car.hasSameStep(maxStep))
				.map(Car::getName)
				.collect(toList());
	}

}
