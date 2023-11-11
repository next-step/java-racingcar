package carRacing.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

	private static final int MAXIMUM_BOUND = 10;
	private static final int MINIMUM_TO_MOVE = 4;

	private final Random random = new Random();

	@Override
	public boolean isForward() {
		return random.nextInt(MAXIMUM_BOUND) >= MINIMUM_TO_MOVE;
	}
}
