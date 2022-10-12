package study.step5.domain.movestrategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
	private static final int STANDARD = 4;
	private static final Random RANDOM = new Random();
	private static final int BOUND = 10;

	@Override
	public boolean isMovable() {
		return generateRandomNumber() >= STANDARD;
	}

	private int generateRandomNumber() {
		return RANDOM.nextInt(BOUND);
	}
}