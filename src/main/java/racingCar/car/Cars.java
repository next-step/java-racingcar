package racingCar.car;

import racingCar.util.RandomNumberSupplier;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> carList = new ArrayList<>();

	private Cars() {
	}

	public static Cars of(int carCount) {
		Cars cars = new Cars();
		cars.addCar(carCount);
		return cars;
	}

	public static Cars of(List<String> carNameList) {
		Cars cars = new Cars();
		cars.addCar(carNameList);
		return cars;
	}

	public List<Car> carList() {
		return carList;
	}

	private void addCar(List<String> carNames) {
		for (String name : carNames) {
			carList.add(new Car(0, new RandomNumberSupplier(), name));
		}
	}

	private void addCar(int carCount) {
		for (int i = 0; i < carCount; i++) {
			carList.add(new Car(0, new RandomNumberSupplier()));
		}
	}

	public void moveOnce() {
		for (Car car : carList) {
			car.move();
		}
	}
}
