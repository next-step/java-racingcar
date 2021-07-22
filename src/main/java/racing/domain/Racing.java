package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

	private final int carCount;
	private final int tryCount;
	private List<Car> cars;

	private final int COMPARE_VALUE = 4;

	public Racing(int carCount, int tryCount) {
		this.carCount = carCount;
		this.tryCount = tryCount;
	}

	public List<Car> start() {
		cars = new ArrayList<>(carCount);

		for (int i = 0; i < tryCount; i++) {
			move();
		}

		return cars;
	}

	private void move() {
		for (Car car : cars) {
			moveCar(car, getRandomValue());
		}
	}

	private void moveCar(Car car, int randomValue) {
		if (randomValue >= COMPARE_VALUE) {
			car.move();
		}
	}

	private int getRandomValue() {
		Random random = new Random(System.currentTimeMillis());

		return random.nextInt(10);
	}
}
