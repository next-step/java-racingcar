package edu.nextstep.racing.domain;

import java.util.Objects;

public class MoveCount {
	private final int max;
	private int current;

	public MoveCount(int max) {
		this.max = max;
	}

	public void countUp() {
		if (current < max) {
			current++;
		}
	}

	public boolean isContinue() {
		return current < max;
	}

	public int getCurrent() {
		return current;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof MoveCount)) {
			return false;
		}
		MoveCount moveCount = (MoveCount)o;
		return max == moveCount.max && current == moveCount.current;
	}

	@Override
	public int hashCode() {
		return Objects.hash(max, current);
	}
}
