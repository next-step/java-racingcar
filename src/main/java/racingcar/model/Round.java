package racingcar.model;

import java.util.Objects;

import racingcar.util.NumberUtils;

public class Round {
	public static final Integer FIRST_ROUND = 1;

	private Integer currentRound;
	private final Integer endRound;

	Round(int endRound) {
		this(FIRST_ROUND, endRound);
	}

	Round(int currentRound, int endRound) {
		validate(endRound);
		this.currentRound = currentRound;
		this.endRound = endRound;
	}

	private void validate(int endRound) {
		if (NumberUtils.isNotPositiveNumber(endRound)) {
			throw new IllegalArgumentException("round must be positive number");
		}
	}

	public static Round create(int endRound) {
		return new Round(endRound);
	}

	public boolean hasNext() {
		return currentRound <= endRound;
	}

	public void increase() {
		currentRound++;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Round round = (Round)o;

		if (!Objects.equals(currentRound, round.currentRound))
			return false;
		return Objects.equals(endRound, round.endRound);
	}

	@Override
	public int hashCode() {
		int result = currentRound != null ? currentRound.hashCode() : 0;
		result = 31 * result + (endRound != null ? endRound.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Round{" +
			"currentRound=" + currentRound +
			", endRound=" + endRound +
			'}';
	}
}
