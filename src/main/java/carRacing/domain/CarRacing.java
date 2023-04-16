package carRacing.domain;

import java.util.List;

import carRacing.utils.RandomUtils;

public class CarRacing {

	private final Cars cars;

	public CarRacing() {
		this.cars = new Cars();
	}

	public CarRacing(String carNames) {
		this.cars = new Cars(carNames);
	}

	public void race() {
		for (Car car : this.cars.getCars()) {
			car.move(RandomUtils.getRandomValue());
		}
	}

	public List<Car> findWinners() {
		return this.cars.findWinners();
	}

	public Cars getCars() {
		return this.cars;
	}
}
