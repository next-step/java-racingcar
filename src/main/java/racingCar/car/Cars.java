package racingCar.car;

import racingCar.game.RacingCarGame;
import racingCar.util.RandomNumberSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> carList;

	public Cars(List<Car> carList) {
		this.carList = carList;
	}

	public List<Car> carList() {
		return carList;
	}

	public static Cars of(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(0, new RandomNumberSupplier(), new CarName(name)));
		}
		return new Cars(cars);
	}

	public void moveByTryCount(int tryCount, RacingCarGame.Callback callback) {
		for (int i = 0; i < tryCount; i++) {
			moveOnce(callback);
		}
	}

	public void moveOnce(RacingCarGame.Callback callback) {
		for (Car car : carList) {
			car.move();
		}
		if (callback != null) {
			callback.printCallBack(Cars.this);
		}
	}

	public List<Car> winners() {
		int maxDistance = maxDistance();
		return findWinners(maxDistance);
	}

	private int maxDistance() {
		int maxDistance = 0;
		for (Car car : carList) {
			maxDistance = car.maxDistance(maxDistance);
		}
		return maxDistance;
	}

	private List<Car> findWinners(int maxDistance) {
		return carList
				.stream()
				.filter(car -> car.matchMaxDistance(maxDistance))
				.collect(Collectors.toList());
	}
}
