package racingcar.domain;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Winners {
	private final List<Car> cars;

	public Winners(List<Car> racingCars) {
		TreeSet<Car> rankCars = new TreeSet<>(racingCars);
		Car maxPositionCar = rankCars.last();

		cars = racingCars.stream()
			.filter(car -> car.isSamePositionCar(maxPositionCar))
			.collect(Collectors.toList());
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
