package racingcar.car;

import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {

	private static final int INITIAL_POSITION = 0;
	private static final String DELIMITER = ",";
	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars of(String carNames, int carCount) {
		List<Car> cars = new ArrayList<>();
		String[] names = carNames.split(DELIMITER);
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car(new Name(names[i])));
		}
		return new Cars(cars);
	}

	public void move(MoveStrategy moveStrategy) {
		for (Car car : cars) {
			car.move(moveStrategy);
		}
	}

	public List<Car> cars() {
		return cars;
	}

	public List<Car> getRaceWinners() {
		List<Car> raceWinners = new ArrayList<>();
		int maxPosition = getMaxPosition();
		for (Car car : cars) {
			if (car.isMaxPosition(maxPosition)) {
				raceWinners.add(car);
			}
		}
		return raceWinners;
	}

	private int getMaxPosition() {
		int maxPosition = INITIAL_POSITION;
		for (Car car : cars) {
			maxPosition = max(car, maxPosition);
		}
		return maxPosition;
	}

	private int max(Car car, int maxPosition) {
		int position = car.getPosition();
		if (position > maxPosition) {
			maxPosition = position;
		}
		return maxPosition;
	}
}
