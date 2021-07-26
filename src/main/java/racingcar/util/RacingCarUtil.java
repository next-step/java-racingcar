package racingcar.util;

import java.util.Random;

public class RacingCarUtil {
	public static final int VALUE_RANGE = 10;

	private static Random random = new Random();

	private RacingCarUtil() {}

	public static int generateForwardValue() {
		return random.nextInt(VALUE_RANGE);
	}
}
