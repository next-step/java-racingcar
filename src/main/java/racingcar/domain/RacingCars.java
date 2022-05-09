package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
	private final List<Car> cars;

	public RacingCars(List<Car> cars) {
		this.cars = cars;
	}

	public static RacingCars of(CarNames carNames) {
		return new RacingCars(carNames.values()
			.stream()
			.map(Car::new)
			.collect(Collectors.toList()));
	}

	public void play(EngineStrategy engineStrategy) {
		cars.forEach(
			car -> car.run(engineStrategy.generate()));
	}

	public boolean isSameSize(int size) {
		return cars.size() == size;
	}

	public Winners rankWinners() {
		return new Winners(cars);
	}

	public List<String> results() {
		return cars.stream()
			.map(Car::toString)
			.collect(Collectors.toList());
	}
}
