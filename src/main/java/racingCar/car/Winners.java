package racingCar.car;

import java.util.LinkedList;
import java.util.List;

public class Winners {
	private final LinkedList<Car> winners;

	public Winners(Cars cars) {
		winners = new LinkedList<>();
		setWinners(cars);
	}

	private void setWinners(Cars cars) {
		List<Car> carList = cars.carList();

		for (Car currentCar : carList) {
			setWinnerByCondition(winners, currentCar);
		}
	}

	private void setWinnerByCondition(LinkedList<Car> winners, Car currentCar) {
		if (winners.isEmpty() || winners.getLast().distance < currentCar.distance) {
			winners.clear();
			winners.add(currentCar);
			return;
		}
		if (winners.getLast().distance == currentCar.distance) {
			winners.add(currentCar);
		}
	}

	public List<Car> winners() {
		return winners;
	}
}
