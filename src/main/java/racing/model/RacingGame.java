package racing.model;

import java.util.List;

import racing.model.service.CarConditional;

public class RacingGame {

	private final RacingCars racingCars;

	public RacingGame(CarNames names) {

		this.racingCars = new RacingCars(names);
	}

	public void start(CarConditional carConditional) {

		this.racingCars.start(carConditional);
	}

	public List<RacingCar> getRacingCars() {

		return this.racingCars.getCars();
	}

	public String getWinner() {

		return this.racingCars.getWinnerNames();
	}
}
