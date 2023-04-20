package step5_racingcar_refactoring.service;

import java.util.Random;

public class RandomNumber implements RandomUtil {
	private static final Random random = new Random();
	@Override
	public int randomNumber(int bound)
	{
		return random.nextInt(bound + 1);
	}
}
