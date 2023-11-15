package racingCar.car;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> carList;

	public Cars(List<Car> carList) {
		this.carList = carList;
	}

	public List<Car> carList() {
		return carList;
	}

	public void moveOnce() {
		for (Car car : carList) {
			car.move();
		}
	}

	public List<Car> winners() {
		int maxDistance = maxDistance();

		return findWinners(maxDistance);
	}

	private int maxDistance() {
		int maxDistance = 0;
		for (Car car : carList) {
			maxDistance = car.maxDistance(maxDistance);
		}
		return maxDistance;
	}

	private List<Car> findWinners(int maxDistance) {
		return carList
				.stream()
				.filter(car -> car.matchMaxDistance(maxDistance))
				.collect(Collectors.toList());
	}
}
