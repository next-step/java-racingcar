package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	private Car getMaximumMileageCar() {
		return Collections.max(cars);
	}

	public void move(CarNumberGenerator generator) {
		this.cars.forEach(car -> car.move(new RacingCarMoveStrategy(generator.generate())));
	}

	public List<Car> getWinners() {
		Car oneOfWinner = getMaximumMileageCar();
		return this.cars.stream()
			.filter(car -> car.compareTo(oneOfWinner) == 0)
			.collect(Collectors.toList());
	}

	public List<Car> toList() {
		return this.cars;
	}
}
