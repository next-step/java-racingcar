package racingcar;

import java.util.List;

public class Round {
	private final List<Car> cars;

	public Round(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}
}
