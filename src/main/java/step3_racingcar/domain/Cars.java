package step3_racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import step3_racingcar.service.GameRule;

public class Cars {
	private final List<Car> cars;

	public Cars(int carCount) {
		cars = new ArrayList<>();
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car());
		}
	}

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public void playRound() {
		for (Car car : cars) {
			car.tryMove(GameRule.isCarMoving(GameRule.randomValue()));
		}
	}
}
