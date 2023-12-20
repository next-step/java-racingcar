package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
	private List<Car> winners;

	public Winners() {
		winners = new ArrayList<>();
	}

	public void findWinners(Cars cars) {
		int maxDistance = 0;
		for (int carNum = 0; carNum < cars.size(); carNum++) {
			if (cars.car(carNum).distance() == maxDistance) {
				winners.add(cars.car(carNum));
			}
			if (cars.car(carNum).distance() > maxDistance) {
				winners = new ArrayList<>();
				winners.add(cars.car(carNum));
				maxDistance = cars.car(carNum).distance();
			}
		}
	}

	public List<Car> winners() {
		return winners;
	}
}
