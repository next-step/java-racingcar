package racingcar.domain;

import java.util.Objects;

public class Car {
	private static final int MOVING_CONDITION = 4;
	private Name name;
	private Position position;

	public Car(String name) {
		this.name = new Name(name);
		this.position = new Position();
	}

	public void movingOfRound(int random) {
		if (random >= MOVING_CONDITION) {
			this.position = this.position.increase();
		}
	}

	public boolean hasSamePosition(int max) {
		return position.hasSamePosition(max);
	}

	public Position getStatus() {
		return this.position;
	}

	public Name getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return Objects.equals(name, car.name) && Objects.equals(position, car.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}
