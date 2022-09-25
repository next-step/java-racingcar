package racingcar;

import racingcar.movestrategy.MoveStrategy;

public class Car implements Comparable<Car> {

	private static final int MOVE_COUNT = 1;

	private int position = 0;

	public void move(MoveStrategy moveStrategy) {
		if (moveStrategy.isMovable()) {
			position += MOVE_COUNT;
		}
	}

	protected int getPosition() {
		return position;
	}

	@Override
	public int compareTo(Car other) {
		return Integer.compare(position, other.position);
	}
}
