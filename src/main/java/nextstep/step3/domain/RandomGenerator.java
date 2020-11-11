package nextstep.step3.domain;

import java.util.Random;

public class RandomGenerator {
	private static final Random random = new Random();
	private final int bound;

	public RandomGenerator(int bound) {
		this.bound = bound;
	}
	public int getRandomNumber() {
		return random.nextInt(bound);
	}
}
