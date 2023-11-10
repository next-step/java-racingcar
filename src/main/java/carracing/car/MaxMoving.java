package carracing.car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxMoving implements WinnerStrategy {
	@Override
	public List<Car> winners(List<Car> cars) {
		int maxMovingDistance = maxMovingDistance(cars);
		List<Car> winners = winnersWithMaxMovingDistance(cars, maxMovingDistance);

		return winners;
	}

	private int maxMovingDistance(List<Car> cars) {
		return cars.stream()
				.map(Car::movingDistance)
				.max(Comparator.comparingInt(movingDistance -> movingDistance))
				.orElseThrow(IllegalArgumentException::new);
	}

	private List<Car> winnersWithMaxMovingDistance(List<Car> cars, int maxMovingDistance) {
		return cars.stream()
				.filter(car -> car.sameDistance(maxMovingDistance))
				.collect(Collectors.toList());
	}
}
