package racingcar.strategy;

import racingcar.util.RandomNumber;

public class RandomMoveStrategy implements MoveStrategy {

	private static final int MOVABLE_MINIMUM_NUMBER = 4;

	@Override
	public boolean isMovable() {
		return isMovable(RandomNumber.pick());
	}

	@Override
	public boolean isMovable(int number) {
		return number >= MOVABLE_MINIMUM_NUMBER;
	}

}
