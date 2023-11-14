package racingCar.car;

import java.util.LinkedList;
import java.util.List;

public class Winners {
	private final List<Car> winners;

	public Winners(Cars cars) {
		this.winners = selectWinners(cars);
	}

	private List<Car> selectWinners(Cars cars) {
		LinkedList<Car> winners = new LinkedList<>();
		List<Car> carList = cars.carList();
		for (int i = 0; i < carList.size(); i++) {
			Car currentCar = carList.get(i);
			if (i == 0) {
				winners.add(currentCar);
				continue;
			}
			Car winner = winners.getLast();
			if (winner.distance < currentCar.distance) {
				winners.clear();
				winners.add(currentCar);
				continue;
			}
			if (winner.distance == currentCar.distance) {
				winners.add(currentCar);
			}
		}
		return winners;
	}

	public List<Car> winnerList() {
		return winners;
	}
}
