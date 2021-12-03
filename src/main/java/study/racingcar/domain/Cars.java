package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import study.racingcar.domain.strategy.MoveStrategy;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars fromNames(List<Name> names) {
		List<Car> createCars = new ArrayList<>();
		for (Name name : names) {
			createCars.add(new Car(name));
		}
		return new Cars(createCars);
	}

	public static Cars fromCars(List<Car> cars) {
		List<Car> createCars = new ArrayList<>(cars);
		return new Cars(createCars);
	}

	public Cars racingCars(MoveStrategy strategy) {
		for (Car car : this.cars) {
			car.movedCar(strategy);
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
