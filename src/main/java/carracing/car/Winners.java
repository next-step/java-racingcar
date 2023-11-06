package carracing.car;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Winners {
	private final List<Car> cars;

	public Winners(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> winners() {
		int maxMovingDistance = this.cars.stream()
				.map(Car::movingDistance)
				.max(Comparator.comparingInt(movingDistance -> movingDistance))
				.orElseThrow(NoSuchElementException::new);

		List<Car> winners = this.cars.stream()
				.filter(car -> car.movingDistance() == maxMovingDistance)
				.collect(Collectors.toList());

		return winners;
	}
}
