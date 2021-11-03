package racingcar.model;

import racingcar.rule.MoveRule;
import racingcar.util.NumberUtils;

public class RacingGame {
	private final MoveRule moveRule;
	private final Round round;
	private final Cars cars;

	RacingGame(MoveRule moveRule, int numberOfRounds, int numberOfCars) {
		validate(numberOfRounds, numberOfCars);

		this.moveRule = moveRule;
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

	public static RacingGame create(MoveRule moveRule, int numberOfRounds, int numberOfCars) {
		return new RacingGame(moveRule, numberOfRounds, numberOfCars);
	}

	public boolean hasNextRound() {
		return round.hasNext();
	}

	public void moveOnce() {
		round.increase();
		cars.move(moveRule);
	}

	@Override
	public String toString() {
		return cars.toString();
	}
}
