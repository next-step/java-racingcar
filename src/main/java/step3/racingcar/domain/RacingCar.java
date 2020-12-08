package step3.racingcar.domain;

public class RacingCar {

	private final String name;
	private int moveDistance;

	public RacingCar(final String name) {
		this.name = name;
	}

	public RacingCar(final String name, final int moveDistance) {
		this.name = name;
		this.moveDistance = moveDistance;
	}

	public void move(final int value) {
		final int CAR_MOVABLE_VALUE = 4;

		if (value < CAR_MOVABLE_VALUE) {
			return;
		}

		this.increaseMoveDistance();
	}

	private void increaseMoveDistance() {
		this.moveDistance += 1;
	}

	public int getMoveDistance() {
		return this.moveDistance;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final RacingCar racingCar = (RacingCar)o;

		if (moveDistance != racingCar.moveDistance)
			return false;
		return name != null ? name.equals(racingCar.name) : racingCar.name == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + moveDistance;
		return result;
	}

	public RacingCar copy() {
		return new RacingCar(this.name, this.moveDistance);
	}
}
