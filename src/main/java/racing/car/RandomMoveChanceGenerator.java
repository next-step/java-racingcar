package racing.car;

import java.util.Random;

public class RandomMoveChanceGenerator implements MoveChanceGenerator {

	private static final int BOUND_MAX = 10;
	private static final int CHANCE_MINIMUM = 4;
	private final Random random;

	public RandomMoveChanceGenerator() {
		this.random = new Random();
	}

	@Override
	public boolean getMoveChance() {
		final int moveChance = this.random.nextInt(BOUND_MAX);
		return moveChance >= CHANCE_MINIMUM;
	}
}
