package racing.domain;

import java.util.Random;

public class RandomNumber implements RandomNum {
	private static final Random RANDOM = new Random();
	private static final int RANDOM_MAX_BOUND = 10;

	@Override
	public int getRandomNumber() {
		return RANDOM.nextInt(RANDOM_MAX_BOUND);
	}
}
