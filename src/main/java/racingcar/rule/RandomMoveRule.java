package racingcar.rule;

import racingcar.util.RandomUtils;

public class RandomMoveRule implements MoveRule {
	private static final int MIN_CONDITION_TO_MOVE = 4;
	private static final int MAX_OF_BOUND = 10;

	@Override
	public boolean canMove() {
		return MIN_CONDITION_TO_MOVE <= generateRandomNumber();
	}

	private int generateRandomNumber() {
		return RandomUtils.nextInt(MAX_OF_BOUND);
	}
}
