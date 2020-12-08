package step3.racingcar.domain;

public class RacingCar {

	private final int id;
	private int moveDistance;

	public RacingCar(final int id) {
		this.id = id;
	}

	public RacingCar(final int id, final int moveDistance) {
		this.id = id;
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

		return id == racingCar.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	public int getId() {
		return this.id;
	}
}
