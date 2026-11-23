package racingcar.domain.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

	private static final int RANDOM_BOUND = 10;
	private static final Random RANDOM = new Random();

	@Override
	public int generate() {
		return RANDOM.nextInt(RANDOM_BOUND);
	}
}
