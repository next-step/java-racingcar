package racingCar.car;

import java.util.LinkedList;
import java.util.List;

public class Winners {
	private final List<Car> winners;

	public Winners(Cars cars) {
		this.winners = cars.winners();
	}


	public List<Car> winners() {
		return winners;
	}
}
