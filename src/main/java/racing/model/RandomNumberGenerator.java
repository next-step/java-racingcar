package racing.model;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

	private static final int RANGE_OF_RANDOM_NUMBER = 10;
	private static final Random random = new Random();

	@Override
	public int generate() {
		return random.nextInt(RANGE_OF_RANDOM_NUMBER);
	}
}
