package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

	private List<Car> cars;

	private static final int COMPARE_VALUE = 4;

	public Racing(int carCount) {
		initCars(carCount);
	}

	public void initCars(int carCount) {
		cars = new ArrayList<>(carCount);

		for (int i = 0; i < carCount; i++) {
			cars.add(new Car());
		}
	}

	public List<Car> move() {
		for (Car car : cars) {
			moveCar(car, getRandomValue());
		}

		return cars;
	}

	private void moveCar(Car car, int randomValue) {
		if (randomValue >= COMPARE_VALUE) {
			car.move();
		}
	}

	private int getRandomValue() {
		Random random = new Random();

		return random.nextInt(10);
	}
}
