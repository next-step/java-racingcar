package racingcar.model;

import java.util.List;
import java.util.Objects;

import racingcar.rule.MoveRule;

public class RacingGame {
	private final MoveRule moveRule;
	private final Cars cars;
	private final Round round;

	RacingGame(MoveRule moveRule, String nameOfCars, int numberOfRounds) {
		this(moveRule, Cars.create(nameOfCars), Round.create(numberOfRounds));
	}

	RacingGame(MoveRule moveRule, Cars cars, Round round) {
		this.moveRule = moveRule;
		this.cars = cars;
		this.round = round;
	}

	public static RacingGame create(MoveRule moveRule, String nameOfCars, int numberOfRounds) {
		return new RacingGame(moveRule, nameOfCars, numberOfRounds);
	}

	public boolean hasNextRound() {
		return round.hasNext();
	}

	public void moveOnce() {
		round.increase();
		cars.move(moveRule);
	}

	public List<String> getWinnerNames() {
		if (hasNextRound()) {
			throw new IllegalStateException("game is not over");
		}
		return cars.getCarNamesWithHighestPosition();
	}

	public List<Car> getCars() {
		return cars.getCars();
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
		if (!Objects.equals(cars, that.cars))
			return false;
		return Objects.equals(round, that.round);
	}

	@Override
	public int hashCode() {
		int result = moveRule != null ? moveRule.hashCode() : 0;
		result = 31 * result + (cars != null ? cars.hashCode() : 0);
		result = 31 * result + (round != null ? round.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "RacingGame{" +
			"moveRule=" + moveRule +
			", cars=" + cars +
			", round=" + round +
			'}';
	}
}
