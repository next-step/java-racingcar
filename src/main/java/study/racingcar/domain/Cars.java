package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import study.racingcar.util.RandomNumberGenerator;

public class Cars {

	public static final int MOVE_MIN_VALUE = 4;

	private final List<Car> cars;

	public Cars(int carCount) {
		this.cars = new ArrayList<>();

		for (int i = 0; i < carCount; i++) {
			this.cars.add(new Car());
		}
	}

	public void goRace() {
		for (Car car : this.cars) {
			boolean isMoveCar = isMove();
			car.go(isMoveCar);
		}
	}

	public List<Position> positionOfCars() {
		List<Position> positions = new ArrayList<>();
		for (Car car : this.cars) {
			Position pos = car.carPosition();
			positions.add(pos);
		}
		return positions;
	}

	private boolean isMove() {
		int randomNumber = RandomNumberGenerator.RandomNumber();
		return checkMoveCondition(randomNumber);
	}

	private boolean checkMoveCondition(int randomNumber) {
		return randomNumber >= MOVE_MIN_VALUE;
	}

}
