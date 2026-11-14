package racingcar;

import java.util.Random;

public class RandomNumberGenerator {

	private static final int RANDOM_BOUND = 10;

	public int generate() {
		return new Random().nextInt(RANDOM_BOUND);
	}
}
