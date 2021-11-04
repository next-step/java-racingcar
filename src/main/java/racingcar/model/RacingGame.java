package racingcar.model;

import java.util.Objects;

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

	RacingGame(MoveRule moveRule, Round round, Cars cars) {
		this.moveRule = moveRule;
		this.round = round;
		this.cars = cars;
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

	public String getCurrentGameStatus() {
		return cars.getCurrentPosition();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		RacingGame that = (RacingGame)o;

		if (!Objects.equals(moveRule, that.moveRule))
			return false;
		if (!Objects.equals(round, that.round))
			return false;
		return Objects.equals(cars, that.cars);
	}

	@Override
	public int hashCode() {
		int result = moveRule != null ? moveRule.hashCode() : 0;
		result = 31 * result + (round != null ? round.hashCode() : 0);
		result = 31 * result + (cars != null ? cars.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "RacingGame{" +
			"moveRule=" + moveRule +
			", round=" + round +
			", cars=" + cars +
			'}';
	}
}
