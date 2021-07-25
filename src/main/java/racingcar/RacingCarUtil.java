package racingcar;

import java.util.Random;

public class RacingCarUtil {
	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 9;

	private static Random random = new Random();

	public static int generateForwardValue() {
		return random.nextInt(10);
	}
}
