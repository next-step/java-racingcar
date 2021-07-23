package racingcar.car;

import java.util.ArrayList;
import java.util.List;

import racingcar.strategy.MoveStrategy;

public class Cars {

	private final List<Car> cars;
	private final MoveStrategy moveStrategy;

	public Cars(List<Car> cars, MoveStrategy moveStrategy) {
		this.cars = cars;
		this.moveStrategy = moveStrategy;
	}

	public static Cars of(int numberOfCars, MoveStrategy moveStrategy) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(new Car());
		}
		return new Cars(cars, moveStrategy);
	}

	public void move() {
		for (Car car : cars) {
			car.move(moveStrategy);
		}
	}

	public List<Car> cars() {
		return cars;
	}
}
