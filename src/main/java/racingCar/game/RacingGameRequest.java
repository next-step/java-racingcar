package racingCar.game;

import racingCar.car.Car;
import racingCar.util.RandomNumberSupplier;

import java.util.ArrayList;
import java.util.List;

public class RacingGameRequest {
	private final List<Car> cars;
	private final int tryCount;

	public RacingGameRequest(int carCount, int tryCount) {
		this.tryCount = tryCount;
		this.cars = carsByCarCount(carCount);
	}

	public RacingGameRequest(List<String> carNames, int tryCount) {
		this.tryCount = tryCount;
		this.cars = carsByCarNames(carNames);
	}

	private List<Car> carsByCarCount(int carCount) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car(0, new RandomNumberSupplier()));
		}
		return cars;
	}


	private List<Car> carsByCarNames(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(0, new RandomNumberSupplier(), name));
		}
		return cars;
	}

	public int tryCount() {
		return tryCount;
	}

	public List<Car> cars() {
		return cars;
	}
}
