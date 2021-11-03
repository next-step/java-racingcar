package racingcar.model;

import racingcar.util.NumberUtils;

public class RacingGame {
	private final Cars cars;
	private final Round round;

	public RacingGame(int numberOfCars, int numberOfRounds) {
		validate(numberOfCars, numberOfRounds);

		this.cars = Cars.create(numberOfCars);
		this.round = Round.create(numberOfRounds);
	}

	private void validate(int numberOfCars, int numberOfRounds) {
		if (NumberUtils.isNotPositiveNumber(numberOfCars)) {
			throw new IllegalArgumentException("numberOfCars must be positive number");
		}
		if (NumberUtils.isNotPositiveNumber(numberOfRounds)) {
			throw new IllegalArgumentException("numberOfRounds must be positive number");
		}
	}
}
