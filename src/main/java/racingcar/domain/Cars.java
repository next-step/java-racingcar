package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars;
	private final NumberGenerator numberGenerator;

	public Cars(List<String> carNames, NumberGenerator numberGenerator) {
		this.cars = carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());

		this.numberGenerator = numberGenerator;
	}

	public void move() {
		for (Car car : this.cars) {
			car.tryMove(numberGenerator.createNumber());
		}
	}

	public RacingResults racingResults() {
		List<RacingResult> results = cars.stream()
			.map(Car::racingResult)
			.collect(Collectors.toList());
		return new RacingResults(results);
	}

	public int sizeOfCars() {
		return this.cars.size();
	}
}
