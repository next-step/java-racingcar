package racingcar.strategy;

import racingcar.util.RandomNumber;

public class RandomMoveStrategy implements MoveStrategy {

	private static final int MOVABLE_MINIMUM_NUMBER = 4;

	@Override
	public boolean isMovable() {
		return RandomNumber.pick() >= MOVABLE_MINIMUM_NUMBER;
	}

}
