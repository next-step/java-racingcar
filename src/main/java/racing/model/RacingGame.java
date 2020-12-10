package racing.model;

import java.util.List;

public class RacingGame {

	private final RacingCars racingCars;

	public RacingGame(int carNumber) {

		this.racingCars = new RacingCars(carNumber);
	}

	public void start() {

		this.racingCars.start();
	}

	public List<RacingCar> getRacingCars() {

		return this.racingCars.getCars();
	}
}
