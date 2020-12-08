package racing.car;

import java.util.Random;

public class RandomMoveForwardStrategy implements MoveForwardStrategy {

	private final int BOUND_MAX = 10;
	private final int CHANCE_MINIMUM = 4;
	private final Random random;

	public RandomMoveForwardStrategy() {
		random = new Random();
	}

	@Override
	public int createMoveForwardChance() {
		return random.nextInt(BOUND_MAX);
	}

	@Override
	public boolean isSatisfiedToMoveForward(int chance) {
		return chance >= CHANCE_MINIMUM;
	}
}
