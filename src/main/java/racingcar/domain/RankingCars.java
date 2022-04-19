package racingcar.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class RankingCars {
	private final TreeSet<Car> cars;

	public RankingCars(List<Car> racingCars) {
		this.cars = new TreeSet<>(racingCars);
	}

	public List<String> results() {
		Car last = cars.last();
		return cars.stream()
			.filter(car -> car.isSamePositionCar(last))
			.map(Car::toString)
			.collect(Collectors.toList());
	}
}
