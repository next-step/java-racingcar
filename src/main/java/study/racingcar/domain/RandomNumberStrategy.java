package study.racingcar.domain;

import study.racingcar.util.RandomNumberGenerator;

public class RandomNumberStrategy implements MoveStrategy {

	private static final int MOVE_MIN_VALUE = 4;

	@Override
	public boolean isMovable() {
		int randomNumber = RandomNumberGenerator.generate();
		return checkMoveCondition(randomNumber);
	}

	private boolean checkMoveCondition(int randomNumber) {
		return randomNumber >= MOVE_MIN_VALUE;
	}

}
