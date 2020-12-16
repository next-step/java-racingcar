package racinggame.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
	private final static int POSSIBLE_MOVE_CRITERIA = 4;
	private final static int RANDOM_NUMBER_BOUND = 10;
	private final static Random random = new Random();

	@Override
	public boolean isPossibleMove() {
		return random.nextInt(RANDOM_NUMBER_BOUND) < POSSIBLE_MOVE_CRITERIA;
	}
}
