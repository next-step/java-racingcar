package racingcar.car;

import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {

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
}
