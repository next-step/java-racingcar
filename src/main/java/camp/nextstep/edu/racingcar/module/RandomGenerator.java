package camp.nextstep.edu.racingcar.module;

import java.util.Random;

public class RandomGenerator {

	private final Random random;
	private final int RANDOM_RANGE;

	private RandomGenerator() {
		this.random = new Random();
		this.RANDOM_RANGE = 10;
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
