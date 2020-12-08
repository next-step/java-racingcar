package racingcar.domain;

import java.util.Objects;

public class RacingResult {
	private final String name;
	private final int moveCount;

	public RacingResult(String name, int moveCount) {
		this.name = name;
		this.moveCount = moveCount;
	}

	public String getName() {
		return name;
	}

	public int getMoveCount() {
		return moveCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof RacingResult))
			return false;
		RacingResult that = (RacingResult)o;
		return moveCount == that.moveCount &&
			Objects.equals(name, that.name);
	}
}
