package racingcar.model;

import java.util.Objects;

import racingcar.rule.MoveRule;

public class Car {
	private final Position position;

	Car() {
		this(Position.create());
	}

	Car(Position position) {
		this.position = position;
	}

	public static Car create() {
		return new Car();
	}

	public void move(MoveRule moveRule) {
		if (moveRule.canMove()) {
			position.increase();
		}
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
		return position != null ? position.hashCode() : 0;
	}

	@Override
	public String toString() {
		return position.toString();
	}
}
