package racingcar.model;

import java.util.Objects;

import racingcar.rule.MoveRule;

public class Car implements Comparable<Car> {
	private static final int MAX_OF_CAR_NAME = 5;

	private final String name;
	private final Position position;

	Car(String name) {
		this(name, Position.create());
	}

	Car(String name, Position position) {
		validateSizeOfCarName(name);
		this.name = name;
		this.position = position;
	}

	public static Car create(String name) {
		return new Car(name);
	}

	private void validateSizeOfCarName(String name) {
		if (name.length() > MAX_OF_CAR_NAME) {
			throw new IllegalArgumentException("car name must be less than " + MAX_OF_CAR_NAME);
		}
	}

	public void move(MoveRule moveRule) {
		if (moveRule.canMove()) {
			position.increase();
		}
	}

	public String getName() {
		return this.name;
	}

	public int getCurrentPosition() {
		return position.getPosition();
	}

	public boolean equalsPosition(Car other) {
		return this.getCurrentPosition() == other.getCurrentPosition();
	}

	@Override
	public int compareTo(Car other) {
		return this.getCurrentPosition() - other.getCurrentPosition();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Car car = (Car)o;

		if (!Objects.equals(name, car.name))
			return false;
		return Objects.equals(position, car.position);
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (position != null ? position.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Car{" +
			"name='" + name + '\'' +
			", position=" + position +
			'}';
	}

}
