package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import step3.utils.NumberGenerator;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = Collections.unmodifiableList(cars);
	}

	public Cars(Names names) {
		this(createCars(names));
	}

	static List<Car> createCars(Names names) {
		return names.getNameList()
			.stream()
			.map(Car::new)
			.collect(Collectors.toList());
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
			.filter(car -> car.getPosition().isMaxPosition(maxPosition))
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
