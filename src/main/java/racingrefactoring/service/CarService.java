package racingrefactoring.service;

import racingrefactoring.domain.Cars;

public class CarService {

	private final Cars cars;

	public CarService(String[] carNames) {
		this.cars = new Cars(carNames);
	}

	public Cars moveCars() {
		return cars.moveForward();
	}

	public Cars getCars() {
		return cars;
	}

	public Cars winners() {
		return cars.findWinners();
	}

}
