package racingcar;

import racingcar.movestrategy.MoveStrategy;

public class Car implements Comparable<Car> {

	private int position = 0;

	public void move(MoveStrategy moveStrategy) {
		if (moveStrategy.isMovable()) {
			position += 1;
		}
	}

	@Override
	public int compareTo(Car other) {
		return Integer.compare(position, other.position);
	}
}
