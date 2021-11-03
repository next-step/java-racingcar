package racingcar.model;

import racingcar.util.NumberUtils;

public class Round {
	private static final Integer FIRST_ROUND = 1;

	private Integer currentRound;
	private final Integer endRound;

	private Round(int endRound) {
		validate(endRound);
		this.currentRound = FIRST_ROUND;
		this.endRound = endRound;
	}

	private void validate(int round) {
		if (NumberUtils.isNotPositiveNumber(round)) {
			throw new IllegalArgumentException("round must be positive number");
		}
	}

	public static Round create(int numberOfRounds) {
		return new Round(numberOfRounds);
	}

	public boolean hasNext() {
		return currentRound <= endRound;
	}

	public void increase() {
		currentRound++;
	}

}
