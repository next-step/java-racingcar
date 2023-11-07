package carracing.car;

import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> winners(WinnerStrategy winnerStrategy) {
		return winnerStrategy.winners(cars);
	}
}
