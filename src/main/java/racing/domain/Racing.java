package racing.domain;

import java.util.ArrayList;
import java.util.List;

import racing.utils.RandomUtils;

public class Racing {

	private List<Car> cars;

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
		cars.forEach(car -> car.move(RandomUtils.getRandomValue()));

		return cars;
	}
}
