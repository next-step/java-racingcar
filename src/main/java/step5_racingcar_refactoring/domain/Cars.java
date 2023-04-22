package step5_racingcar_refactoring.domain;

import java.util.ArrayList;
import java.util.List;

import step5_racingcar_refactoring.service.RandomNumber;

public class Cars {
	private List<Car> cars;

	public Cars(String[] carNames) {
		cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName, 0 , new RandomNumber()));
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
			car.tryMove();
		}
	}

}
