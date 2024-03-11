package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
	public static final Random RANDOM = new Random();
	private List<Car> cars = new ArrayList<>();

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(int carNumber) {
		for (int i = 0; i < carNumber; i++) {
			cars.add(new Car());
		}
	}

	public void moveCars() {
		for (Car car : cars) {
			car.move(RANDOM.nextInt(10));
		}
	}
}
