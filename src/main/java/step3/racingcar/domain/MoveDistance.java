package step3.racingcar.domain;

public class MoveDistance {
	private int moveDistance;

	public MoveDistance() {
		this(0);
	}

	public MoveDistance(final int moveDistance) {
		this.moveDistance = moveDistance;
	}

	public int getMoveDistance() {
		return moveDistance;
	}

	public void increase() {
		this.moveDistance += 1;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final MoveDistance that = (MoveDistance)o;

		return moveDistance == that.moveDistance;
	}

	@Override
	public int hashCode() {
		return moveDistance;
	}

	@Override
	public String toString() {
		return "MoveDistance{" +
			"moveDistance=" + moveDistance +
			'}';
	}

}
