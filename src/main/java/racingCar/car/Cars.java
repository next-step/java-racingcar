package racingCar.car;

import racingCar.util.RandomNumberSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> carList;

	private CallBack callBack;

	public interface CallBack {
		void printCallBack(Cars cars);
	}

	public static Cars of(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(0, new RandomNumberSupplier(), new CarName(name)));
		}
		return new Cars(cars);
	}

	public Cars(List<Car> carList) {
		this.carList = carList;
		this.callBack = null;
	}

	public void setCallBack(CallBack callBack) {
		this.callBack = callBack;
	}

	public List<Car> carList() {
		return carList;
	}

	public void moveOnce() {
		for (Car car : carList) {
			car.move();
		}
		if (this.callBack != null) {
			this.callBack.printCallBack(Cars.this);
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

	public void moveByTryCount(int tryCount) {
		for (int i = 0; i < tryCount; i++) {
			moveOnce();
		}
	}
}
