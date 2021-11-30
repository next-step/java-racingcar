package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import study.racingcar.domain.strategy.MoveStrategy;

public class Cars {
	private final List<Car> cars;

	public <T> Cars(List<T> carNames) {
		this.cars = new ArrayList<>();
		for (T carName : carNames) {
			createCars(carName);
		}
	}

	private <T> void createCars(T carName) {
		if (carName instanceof Car) {
			this.cars.add((Car)carName);
		}

		if (carName instanceof Name) {
			this.cars.add(new Car((Name)carName));
		}
	}

	public Cars goRace(MoveStrategy strategy) {
		for (Car car : this.cars) {
			car.go(strategy);
		}
		return this;
	}

	public List<Car> status() {
		return cars;
	}

	public int maxPosition() {
		return cars.stream()
			.mapToInt(Car::carPosition)
			.max()
			.orElseThrow(NoSuchElementException::new);
	}

	public List<Name> findWinner() {
		List<Name> winnerNames = new ArrayList<>();
		int maxPosition = maxPosition();
		for (Car car : cars) {
			compareMaxPosition(maxPosition, winnerNames, car);
		}
		return winnerNames;
	}

	private void compareMaxPosition(int maxPosition, List<Name> winnerNames, Car car) {
		if (car.isMaxPosition(maxPosition)) {
			winnerNames.add(car.carName());
		}
	}

}
