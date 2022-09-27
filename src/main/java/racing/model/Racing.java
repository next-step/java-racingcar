package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

	private static final int RANGE_OF_RANDOM_NUMBER = 10;
	private final Random random = new Random();
	private List<Car> cars;

	public Racing(int carCount) {
		generateCars(carCount);
	}

	private void generateCars(int carCount) {
		this.cars = new ArrayList<>();
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car());
		}
	}

	public void race() {
		for (Car car : cars) {
			car.move(random.nextInt(RANGE_OF_RANDOM_NUMBER));
		}
	}

	public List<Car> getCars() {
		return cars;
	}
}
