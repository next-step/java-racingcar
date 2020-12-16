package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
	private static RandomNumberGenerator randomNumberGenerator;
	private static final Random random = new Random();

	public static RandomNumberGenerator getInstance() {
		if (randomNumberGenerator == null) {
			randomNumberGenerator = new RandomNumberGenerator();
		}

		return randomNumberGenerator;
	}

	@Override
	public int generate() {
		return random.nextInt(MAX_NUMBER_LESS_THAN);
	}
}
