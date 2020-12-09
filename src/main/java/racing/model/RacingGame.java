package racing.model;

import java.util.List;

public class RacingGame {

	private RacingCars cars;

	public RacingGame(int carNumber) {

		this.cars = new RacingCars(carNumber);
	}

	public void start() {

		this.cars.start();
	}

	public List<RacingCar> getCars() {

		return this.cars.getRacingCars();
	}
}
