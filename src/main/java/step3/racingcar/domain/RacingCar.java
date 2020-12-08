package step3.racingcar.domain;

public class RacingCar {

	private final String name;
	private int moveDistance;

	public RacingCar(final String name) {
		validate(name);
		this.name = name;
	}

	private void validate(final String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름은 필수 값입니다");
		}
	}

	public RacingCar(final String name, final int moveDistance) {
		this(name);
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

	public RacingCar copy() {
		return new RacingCar(this.name, this.moveDistance);
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

	@Override
	public String toString() {
		return this.name;
	}
}
