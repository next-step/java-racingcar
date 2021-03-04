package camp.nextstep.edu.racingcar.module;

import java.util.Random;

public class RandomGenerator {

	private static final Random random;
	private static final int RANDOM_RANGE;

	static {
		random = new Random();
		RANDOM_RANGE = 10;
	}

	private RandomGenerator() {
	}

	private static class LazyHolder {
		static final RandomGenerator INSTANCE = new RandomGenerator();
	}

	public static RandomGenerator getInstance() {
		return RandomGenerator.LazyHolder.INSTANCE;
	}

	public int generateRandomNumber() {
		return random.nextInt(RANDOM_RANGE);
	}
}
