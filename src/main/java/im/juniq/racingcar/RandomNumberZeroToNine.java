package im.juniq.racingcar;

import java.util.Random;

public class RandomNumberZeroToNine implements RandomNumber {
	private static final int BOUND_OF_RANDOM = 10;
	private final Random random = new Random();

	@Override
	public int get() {
		return random.nextInt(BOUND_OF_RANDOM);
	}
}
