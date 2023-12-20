package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public final class Winners {
	private List<Car> winners;

	public Winners() {
		winners = new ArrayList<>();
	}

	public List<Car> winners() {
		return winners;
	}

	public void findWinners(final Cars cars) {
		int maxDistance = 0;
		for (int carNum = 0; carNum < cars.size(); carNum++) {
			addCarTheSameSpeedAsFastest(cars, maxDistance, carNum);
			maxDistance = addFasterCar(cars, maxDistance, carNum);
		}
	}

	private void addCarTheSameSpeedAsFastest(final Cars cars, final int maxDistance, final int carNum) {
		if (cars.car(carNum).distance() == maxDistance) {
			winners.add(cars.car(carNum));
		}
	}

	private int addFasterCar(final Cars cars, int maxDistance, final int carNum) {
		if (cars.car(carNum).distance() > maxDistance) {
			winners = new ArrayList<>();
			winners.add(cars.car(carNum));
			maxDistance = cars.car(carNum).distance();
		}
		return maxDistance;
	}
}
