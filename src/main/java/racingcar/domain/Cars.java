package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.exception.CarCountException;
import racingcar.strategy.MoveStrategy;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		validateCarCount(cars);
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
		Position maxPosition = getMaxPosition();
		return cars.stream()
			.filter(car -> car.hasPositionSameAs(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private Position getMaxPosition() {
		return cars.stream()
			.reduce(this::getFartherCar)
			.orElseThrow(CarCountException::new)
			.getPosition();
	}

	private Car getFartherCar(Car farthestCar, Car car) {
		if (car.hasPositionGreaterThan(farthestCar)) {
			return car;
		}
		return farthestCar;
	}

	private void validateCarCount(List<Car> cars) {
		if (cars.size() <= 0) {
			throw new CarCountException("자동차는 1개 이상이어야 합니다");
		}
	}

	public List<Integer> getPositions() {
		return cars.stream()
			.map(Car::getPosition)
			.map(Position::value)
			.collect(Collectors.toUnmodifiableList());
	}

	public List<String> getNames() {
		return cars.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
