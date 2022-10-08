package step4.strategy;

import step4.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {

	private static final int MOVE_STANDARD_NUMBER = 4;

	@Override
	public boolean movable() {
		return new RandomNumberGenerator().generateNumber() > MOVE_STANDARD_NUMBER;
	}
}
