package step3.domain;

import java.util.Objects;

public class Car {
	private static final int MIN_MOVABLE_NUMBER = 4;

	private final Position position;

	public Car() {
		this.position = new Position();
	}

	public Car(int position) {
		this.position = new Position(position);
	}

	public void goOrStop(int value) {
		if (isGo(value)) {
			position.go();
		}
	}

	boolean isGo(int value) {
		return isGreaterThanOrEqualToMinMovableNumber(value);
	}

	private boolean isGreaterThanOrEqualToMinMovableNumber(int value) {
		return value >= MIN_MOVABLE_NUMBER;
	}

	public Position getPosition() {
		return this.position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return Objects.equals(position, car.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
