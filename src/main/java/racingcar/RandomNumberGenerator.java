package racingcar;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

	private static final int RANDOM_BOUND = 10;

	@Override
	public int generate() {
		return new Random().nextInt(RANDOM_BOUND);
	}
}
