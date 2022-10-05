package racingcar.domain;

import java.util.Random;

public class RandomMaker implements RandomStrategy {

	private static final int MAX_OF_RANDOM = 10;

	@Override
	public int makeRandom() {
		return new Random().nextInt(MAX_OF_RANDOM);
	}
}
