package racingcar;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
	private static final Random random = new Random();
	private static final int RANDOM_NUMBER_LIMIT = 10;

	@Override
	public int createNumber() {
		return random.nextInt(RANDOM_NUMBER_LIMIT);
	}
}
