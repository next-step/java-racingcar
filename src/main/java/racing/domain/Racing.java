package racing.domain;

import java.util.ArrayList;
import java.util.List;

import racing.utils.RandomUtils;

public class Racing {

	private List<Car> cars;

	private static final int COMPARE_VALUE = 4;

	public Racing(int carCount) {
		initCars(carCount);
	}

	private void initCars(int carCount) {
		cars = new ArrayList<>(carCount);

		for (int i = 0; i < carCount; i++) {
			cars.add(new Car());
		}
	}

	public List<Car> move() {
		for (Car car : cars) {
			car.move(RandomUtils.getRandomValue(), COMPARE_VALUE);
		}

		return cars;
	}
}
