package racinggame.util;

import java.util.Random;

public class RandomValueUtil {

	private static final int BOUND_VALUE = 10;
	private static Random random = new Random();


	public static int getRandomValue() {
		return random.nextInt(BOUND_VALUE);
	}
}
