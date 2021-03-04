package camp.nextstep.edu.racingcar.entity;

import java.util.Random;

public class RandomGenerator {

	private static final Random random;
	private static final int RANDOM_RANGE;

	static {
		random = new Random();
		RANDOM_RANGE = 10;
	}

	public static int generateRandomNumber() {
		return random.nextInt(RANDOM_RANGE);
	}
}
