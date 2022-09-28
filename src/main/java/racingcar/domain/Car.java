package racingcar.domain;

import racingcar.movestrategy.MoveStrategy;

public class Car implements Comparable<Car> {

	private static final int MOVE_AMOUNT = 1;

	private int position = 0;

	public void move(MoveStrategy moveStrategy) {
		if (moveStrategy.isMovable()) {
			position += MOVE_AMOUNT;
		}
	}

	public int getPosition() {
		return position;
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
