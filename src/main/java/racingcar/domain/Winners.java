package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Winners {
	private final List<Car> cars;

	public Winners(List<Car> racingCars) {
		cars = findWinners(racingCars, maxPosition(racingCars));
	}

	private static List<Car> findWinners(List<Car> cars, MoveCount maxPosition) {
		return cars.stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.collect(Collectors.toList());
	}

	private static MoveCount maxPosition(List<Car> cars) {
		MoveCount maxPosition = MoveCount.of(0);
		for (Car car : cars) {
			// 최대값비교하기
			maxPosition = car.maxPosition(maxPosition);
		}
		return maxPosition;
	}

	public boolean contains(Car car) {
		return cars.contains(car);
	}

	@Override
	public String toString() {
		return cars.stream()
			.map(Car::carName)
			.collect(Collectors.joining(","));
	}
}
