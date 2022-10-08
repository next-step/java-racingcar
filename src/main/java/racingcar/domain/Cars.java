package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import racingcar.strategy.MoveStrategy;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = new ArrayList<>(cars);
	}

	public static Cars ofNames(List<String> names) {
		List<Car> cars = names.stream()
			.map(Car::new)
			.collect(Collectors.toList());
		return new Cars(cars);
	}

	public void move(MoveStrategy moveStrategy) {
		for (Car car : cars) {
			car.move(moveStrategy);
		}
	}

	public List<String> findWinnerNames() {
		Car maxCar = getMaxCar();
		return cars.stream()
			.filter(car -> car.compareTo(maxCar) == 0)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private Car getMaxCar() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new NoSuchElementException("우승자를 찾지 못했습니다"));
	}

	public List<Integer> getPositions() {
		List<Integer> positions = new ArrayList<>();
		for (Car car : cars) {
			positions.add(car.getPosition());
		}
		return Collections.unmodifiableList(positions);
	}

	public List<String> getNames() {
		return cars.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
