package racingcar.model;

import racingcar.generator.Generator;
import racingcar.util.NumberUtils;

public class RacingGame {
	private final Generator generator;
	private final Round round;
	private final Cars cars;

	private RacingGame(Generator generator, int numberOfRounds, int numberOfCars) {
		validate(numberOfRounds, numberOfCars);

		this.generator = generator;
		this.round = Round.create(numberOfRounds);
		this.cars = Cars.create(numberOfCars);
	}

	private void validate(int numberOfRounds, int numberOfCars) {
		if (NumberUtils.isNotPositiveNumber(numberOfRounds)) {
			throw new IllegalArgumentException("numberOfRounds must be positive number");
		}
		if (NumberUtils.isNotPositiveNumber(numberOfCars)) {
			throw new IllegalArgumentException("numberOfCars must be positive number");
		}
	}

	public static RacingGame create(Generator generator, int numberOfRounds, int numberOfCars) {
		return new RacingGame(generator, numberOfRounds, numberOfCars);
	}

	public boolean hasNextRound() {
		return round.hasNext();
	}

	public void moveOnce() {
		round.increase();
		cars.move(generator);
	}

	@Override
	public String toString() {
		return cars.toString();
	}
}
