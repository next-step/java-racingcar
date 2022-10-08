package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class Car implements Comparable<Car> {

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

	public int getPosition() {
		return position.getPosition();
	}

	public String getName() {
		return name.getName();
	}

	@Override
	public int compareTo(Car other) {
		return position.compareTo(other.position);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Car car = (Car)o;

		return position == car.position;
	}

	@Override
	public int hashCode() {
		return position;
	}

	@Override
	public String toString() {
		return "Car{" +
			"position=" + position +
			'}';
	}
}
