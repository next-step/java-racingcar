package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.utils.NumberGenerator;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = Collections.unmodifiableList(cars);
	}

	public void goOrStop(NumberGenerator numberGenerator) {
		cars.forEach(car -> car.goOrStop(numberGenerator.generate()));
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public List<Car> findWinners() {
		int maxPosition = findMaxPosition();
		List<Car> winners = cars.stream()
			.filter(car -> car.isMaxPosition(maxPosition))
			.collect(Collectors.toList());

		return Collections.unmodifiableList(winners);
	}

	private int findMaxPosition() {
		return cars.stream()
			.map(Car::getPosition)
			.mapToInt(Position::getPosition)
			.max()
			.orElse(0);
	}
}
