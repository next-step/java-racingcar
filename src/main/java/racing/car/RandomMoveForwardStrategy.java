package racing.car;

import java.util.Random;

public class RandomMoveForwardStrategy implements MoveForwardStrategy {

	public final int BOUND_MAX = 10;
	public final int CHANCE_MINIMUM = 4;
	private final Random random;

	public RandomMoveForwardStrategy() {
		this.random = new Random();
	}

	@Override
	public int createMoveForwardChance() {
		return this.random.nextInt(BOUND_MAX);
	}

	@Override
	public boolean isSatisfiedToMoveForward(int chance) {
		return chance >= CHANCE_MINIMUM;
	}
}
