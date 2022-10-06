package racingcar.domain;

import java.util.Random;

public class RandomMaker implements RandomStrategy {

	private static final int MAX_OF_RANDOM = 10;
	private static final Random random = new Random();

	@Override
	public int makeRandom() {
		return random.nextInt(MAX_OF_RANDOM);
	}
}
