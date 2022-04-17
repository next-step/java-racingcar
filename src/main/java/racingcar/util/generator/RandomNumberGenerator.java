package racingcar.util.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
	private static final Random RANDOM = new Random();
	public static final int LIMIT_RANDOM_NUMBER = 10;

	@Override
	public int generate() {
		return RANDOM.nextInt(LIMIT_RANDOM_NUMBER);
	}
}
