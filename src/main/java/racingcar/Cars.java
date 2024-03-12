package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
	private static final Random RANDOM = new Random();
	private List<Car> cars = new ArrayList<>();

	public static Cars createCars(final String[] carNames) {
		Cars cars = new Cars();
		for (String carName : carNames) {
			cars.addCar(Car.createCar(carName));
		}
		return cars;
	}

	private void addCar(final Car car) {
		cars.add(car);
	}

	public void moveCars() {
		for (Car car : cars) {
			car.move(RANDOM.nextInt(10));
		}
	}

	public List<Car> getCars() {
		return cars;
	}
}
