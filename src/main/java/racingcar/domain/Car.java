package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class Car {

	private Position position;
	private final Name name;

	public Car() {
		this.name = new Name();
		this.position = new Position();
	}

	public Car(String name) {
		this.name = new Name(name);
		this.position = new Position();
	}

	public void move(MoveStrategy moveStrategy) {
		if (moveStrategy.isMovable()) {
			position = position.increase();
		}
	}

	public boolean hasPositionSameAs(int position) {
		Position otherPosition = new Position(position);
		return this.position.equals(otherPosition);
	}

	public boolean hasPositionGreaterThan(Car other) {
		return this.position.compareTo(other.position) > 0;
	}

	public int getPosition() {
		return position.getPosition();
	}

	public String getName() {
		return name.getName();
	}

	@Override
	public String toString() {
		return "Car{" +
			"position=" + position +
			'}';
	}
}
