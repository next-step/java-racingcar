package step5.domain.movestrategy;

import java.util.Random;

public class RandomMoveStrategy implements CarMoveStrategy {
	private static final int MIN_MOVE_VALUE = 4;
	private static final int RANDOM_BOUND = 10;
	private final Random random;

	public RandomMoveStrategy(Random random) {
		this.random = random;
	}

	@Override
	public boolean movable() {
		return random.nextInt(RANDOM_BOUND) >= MIN_MOVE_VALUE;
	}
}
