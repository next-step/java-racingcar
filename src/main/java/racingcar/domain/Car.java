package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class Car implements Comparable<Car> {

	private static final int MOVE_AMOUNT = 1;
	private static final String DEFAULT_NAME = "이름 없음";

	private int position = 0;
	private final String name;

	public Car() {
		this(DEFAULT_NAME);
	}

	public Car(String name) {
		validateNameLength(name);
		validateNameNotBlank(name);
		this.name = name;
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
		return name;
	}

	public void validateNameLength(String name) {
		if (name.length() < 1) {
			throw new RuntimeException("이름은 1글자 이상입니다");
		}
		if (name.length() > 5) {
			throw new RuntimeException("이름은 5글자 이하입니다");
		}
	}

	public void validateNameNotBlank(String name) {
		if(name.isBlank()){
			throw new RuntimeException("이름은 공백이 될 수 없습니다");
		}
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
