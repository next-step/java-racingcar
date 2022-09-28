package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.movestrategy.MoveStrategy;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = new ArrayList<>(cars);
	}

	public Cars(int count) {
		this(new ArrayList<>());
		for (int i = 0; i < count; ++i) {
			cars.add(new Car());
		}
	}

	public void move(MoveStrategy moveStrategy) {
		for (Car car : cars) {
			car.move(moveStrategy);
		}
	}

	public void move(MoveStrategy moveStrategy, int times) {
		for (int i = 0; i < times; ++i) {
			move(moveStrategy);
		}
	}

	public List<Integer> getPositions() {
		List<Integer> positions = new ArrayList<>();
		for (Car car : cars) {
			positions.add(car.getPosition());
		}
		return Collections.unmodifiableList(positions);
	}
}
