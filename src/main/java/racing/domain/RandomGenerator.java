package racing.domain;

import java.util.Random;

public class RandomGenerator implements RandomUtil {

	private static final Random random = new Random();

	@Override
	public int randomGenerate(int rangeValue) {
		int randomValue = random.nextInt(rangeValue);
		validRandomRangeCheck(randomValue);
		return randomValue;
	}

	public void validRandomRangeCheck(int randomValue) {
		if (randomValue < 0 || randomValue > 9) {
			throw new IllegalArgumentException();
		}
	}
}
