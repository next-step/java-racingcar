package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public final class Winners {

	public static List<Car> findWinners(final List<Car> cars) {
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			if (getMaxDistance(cars).equals(car.distance())) {
				winners.add(car);
			}
		}
		return winners;
	}

	private static Distance getMaxDistance(List<Car> cars) {
		Distance maxDistance = new Distance();
		for (Car car : cars) {
			if (maxDistance.compareTo(car.distance())) {
				maxDistance = car.distance();
			}
		}
		return maxDistance;
	}
}
