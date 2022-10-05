package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class Car implements Comparable<Car> {

	private static final int MOVE_AMOUNT = 1;

	private int position = 0;
	private final Name name;

	public Car() {
		this.name = new Name();
	}

	public Car(String name) {
		this.name = new Name(name);
	}

	public void move(MoveStrategy moveStrategy) {
		if (moveStrategy.isMovable()) {
			position += MOVE_AMOUNT;
		}
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name.getName();
	}

	@Override
	public int compareTo(Car other) {
		return Integer.compare(position, other.position);
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
