package racingcar.generator;

import racingcar.util.RandomUtils;

public class RandomGenerator implements Generator {
	@Override
	public int generate() {
		return RandomUtils.nextInt();
	}
}
