package racing.game;

import java.util.Random;

public class RandomNextIntImpl implements RandomNextInt {

	private static final Random RANDOM = new Random();
	private final int BOUND;

	public RandomNextIntImpl(int bound) {
		BOUND = bound;
	}

	@Override
	public int nextInt() {
		return RANDOM.nextInt(BOUND);
	}
}
