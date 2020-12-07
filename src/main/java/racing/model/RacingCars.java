package racing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

	private final List<RacingCar> racingCars;

	public RacingCars(int racingCarNumber) {

		this.racingCars = getRacingCars(racingCarNumber);
	}

	private List<RacingCar> getRacingCars(int racingCarNumber) {

		List<RacingCar> racingCars    = new ArrayList<>();
		for (int i = 0; i < racingCarNumber; i++) {

			racingCars.add(new RacingCar());
		}

		return racingCars;
	}

	public void start(int racingCount) {

		for (int i = 0; i < racingCount; i++) {

			racingCars.forEach(RacingCar::racing);
		}
	}
}
