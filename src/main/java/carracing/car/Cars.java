package carracing.car;

import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		if (cars.isEmpty()) {
			throw new IllegalArgumentException("자동차는 최소 1대 이상이어야 합니다");
		}

		this.cars = cars;
	}

	public List<Car> winners(WinnerStrategy winnerStrategy) {
		return winnerStrategy.winners(cars);
	}

	public void race(MovingStrategy movingStrategy, int tryingTimes) {
		for (int i = 0; i < tryingTimes; i++) {
			this.race(movingStrategy);
		}
	}

	private void race(MovingStrategy movingStrategy) {
		for (Car car : cars) {
			car.move(movingStrategy);
		}
	}
}
