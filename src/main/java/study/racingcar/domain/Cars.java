package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {



	private final List<Car> cars;

	public Cars(int carCount) {
		this.cars = new ArrayList<>();

		for (int i = 0; i < carCount; i++) {
			this.cars.add(new Car());
		}
	}

	public void goRace(MoveStrategy strategy) {
		for (Car car : this.cars) {
			car.go(strategy.isMovable());
		}
	}

	public List<Position> positionOfCars() {
		List<Position> positions = new ArrayList<>();
		for (Car car : this.cars) {
			Position position = car.carPosition();
			positions.add(position);
		}
		return positions;
	}

}
