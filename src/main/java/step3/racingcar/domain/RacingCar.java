package step3.racingcar.domain;

public class RacingCar {
	private final int id;
	private int moveDistance;

	public RacingCar(final int id) {
		this.id = id;
	}

	public void move(final int value) {
		if (value < 4) {
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

}
