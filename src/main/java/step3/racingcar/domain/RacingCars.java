package step3.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step3.racingcar.number.RandomNumberGenerator;

public class RacingCars {

	private final List<RacingCar> racingCars;

	public RacingCars(final List<RacingCar> cars) {
		this.racingCars = cars;
	}

	public void moveAll() {
		for (RacingCar racingCar : this.racingCars) {
			racingCar.move(RandomNumberGenerator.generate());
		}
	}

	public RacingCars copy() {
		List<RacingCar> copiedRacingCars = new ArrayList<>();
		for (RacingCar racingCar : this.racingCars) {
			copiedRacingCars.add(racingCar.copy());
		}
		return new RacingCars(copiedRacingCars);
	}

	public List<RacingCar> getRacingCars() {
		return racingCars;
	}

	public String getNames() {
		final String WINNER_CAR_NAMES_DELIMITER = ", ";
		return this.racingCars.stream().map(RacingCar::toString)
			.collect(Collectors.joining(WINNER_CAR_NAMES_DELIMITER));
	}

}
