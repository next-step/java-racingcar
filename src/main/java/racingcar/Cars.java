package racingcar;

import java.util.List;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void move() {
		for (Car car : cars) {
			car.move();
		}
	}
}
