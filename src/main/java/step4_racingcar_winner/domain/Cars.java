package step4_racingcar_winner.domain;

import java.util.ArrayList;
import java.util.List;

import step4_racingcar_winner.service.GameRule;

public class Cars {
	private final List<Car> cars;

	public Cars(String[] carNames) {
		cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
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
