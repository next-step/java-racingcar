package racingcar;

import java.util.Random;

public class RandomUtils {
	public static int createRandomNumber() {
		Random random = new Random();
		return random.nextInt(10);
	}
}
