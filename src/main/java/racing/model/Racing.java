package racing.model;

import java.util.List;
import java.util.Random;

public class Racing {

	private final Random random = new Random();
	private final List<Car> cars;

	public Racing(List<Car> cars) {
		this.cars = cars;
	}

	public void race() {
		for (Car car : cars) {
			car.move(random.nextInt(10));
		}
	}
}
