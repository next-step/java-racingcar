package nextstep.step3.domain;

import java.util.Random;

public class RandomGenerator {
	private static final int RANDOM_BOUND = 10;
	private static final Random random = new Random();

	public int getRandomNumber() {
		return random.nextInt(RANDOM_BOUND);
	}
}
