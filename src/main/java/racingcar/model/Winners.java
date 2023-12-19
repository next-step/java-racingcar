package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
	private List<String> winners;

	public Winners() {
		winners = new ArrayList<>();
	}

	public void findWinners(Cars cars) {
		int maxDistance = 0;
		for (int carNum = 1; carNum <= cars.size(); carNum++) {
			if (cars.car(carNum).distance() == maxDistance) {
				winners.add(cars.car(carNum).name());
			}
			if (cars.car(carNum).distance() > maxDistance) {
				winners = new ArrayList<>();
				winners.add(cars.car(carNum).name());
				maxDistance = cars.car(carNum).distance();
			}
		}
	}

	public List<String> winners() {
		return winners;
	}
}
