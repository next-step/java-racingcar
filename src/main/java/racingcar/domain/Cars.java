package racingcar.domain;

import java.util.List;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public int count() {
		return cars.size();
	}

	public Car get(int index) {
		return cars.get(index);
	}
}
