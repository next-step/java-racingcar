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

	@Override
	public int compareTo(Car other) {
		return Integer.compare(position, other.position);
	}

	@Override
	public String toString() {
		return "Car{" +
			"position=" + position +
			'}';
	}
}
