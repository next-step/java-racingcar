package racingcar.model;

import racingcar.util.NumberUtils;

public class Round {
	private final Integer round;

	private Round(int round) {
		validate(round);
		this.round = round;
	}

	private void validate(int round) {
		if (NumberUtils.isNotPositiveNumber(round)) {
			throw new IllegalArgumentException("round must be positive number");
		}
	}

	public static Round create(int numberOfRounds) {
		return new Round(numberOfRounds);
	}
}
