package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Ranking {
	private final List<Car> cars;

	public Ranking(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getWinners() {
		int maxPosition = getMaxPosition();

		return cars.stream()
				.filter(car -> car.getPosition() == maxPosition)
				.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		return cars.stream()
				.mapToInt(Car::getPosition)
				.max()
				.orElseGet(() -> 0);
	}
}
