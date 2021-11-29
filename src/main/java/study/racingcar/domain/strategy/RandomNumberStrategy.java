package study.racingcar.domain.strategy;

import java.util.Random;

public class RandomNumberStrategy implements MoveStrategy {

	private static final int RANDOM_MAX_VALUE = 10;
	private static final int MOVE_MIN_VALUE = 4;

	@Override
	public boolean isMovable() {
		return checkMoveCondition(generate());
	}

	public static int generate() {
		Random random = new Random();
		return random.nextInt(RANDOM_MAX_VALUE);
	}

	private boolean checkMoveCondition(int randomNumber) {
		return randomNumber >= MOVE_MIN_VALUE;
	}
}
