package racingcar;

import java.util.Random;

public class Util {
	public static int MIN_VALUE = 0;
	public static int MAX_VALUE = 9;

	private static Random random = new Random();

	public static int generateForwardValue() {
		return random.nextInt(10);
	}
}
