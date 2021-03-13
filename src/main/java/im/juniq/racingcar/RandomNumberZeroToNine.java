package im.juniq.racingcar;

import java.util.Random;

public class RandomNumberZeroToNine implements RandomNumber {
	private static final int BOUND_OF_RANDOM = 10;

	@Override
	public int get() {
		return new Random().nextInt(BOUND_OF_RANDOM);
	}
}
