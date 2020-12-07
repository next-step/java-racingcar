package racing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

	private final List<RacingCar> racingCars;

	public RacingCars(int racingCarNumber) {

		this.racingCars = initRacingCars(racingCarNumber);
	}

	private List<RacingCar> initRacingCars(int racingCarNumber) {

		List<RacingCar> racingCars    = new ArrayList<>();
		for (int i = 0; i < racingCarNumber; i++) {

			racingCars.add(new RacingCar());
		}

		return racingCars;
	}

	public void start() {

		racingCars.forEach(RacingCar::racing);
	}

	public List<RacingCar> getRacingCars() {

		return this.racingCars;
	}
}
