package im.juniq.racingcar;

import java.util.Random;

public class RandomNumberZeroToNine implements RandomNumber {
	private static final int BOUND_OF_RANDOM = 10;
	private Random random;

	public RandomNumberZeroToNine(Random random) {
		this.random = random;
	}

	@Override
	public int get() {
		return random.nextInt(BOUND_OF_RANDOM);
	}
}
