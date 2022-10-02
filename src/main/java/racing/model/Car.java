package racing.model;

import java.util.Objects;

public class Car {

	private Position position;
	private final Name name;

	public Car(Name name) {
		this.position = Position.ZERO;
		this.name = name;
	}

	public void move(boolean isMovable) {
		if (isMovable) {
			position = position.move();
		}
	}

	public boolean isSamePosition(Position position) {
		return this.position.equals(position);
	}

	public Position getPosition() {
		return position;
	}

	public Name getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return Objects.equals(position, car.position) && Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(position, name);
	}
}
