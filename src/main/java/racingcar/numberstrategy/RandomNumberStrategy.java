package racingcar.numberstrategy;

import java.util.Random;

public class RandomNumberStrategy implements NumberStrategy {

	private static final int BOUNDARY_OFFSET = 1;

	private final int boundInclusive;

	public RandomNumberStrategy(int boundInclusive) {
		this.boundInclusive = boundInclusive;
	}

	public int generate() {
		Random random = new Random();
		return random.nextInt(boundInclusive + BOUNDARY_OFFSET);
	}
}
