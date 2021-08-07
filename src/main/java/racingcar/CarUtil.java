package racingcar;

import java.util.Random;

public class CarUtil {

	public static final int MAXIMUM_VALUE = 10;
	private static Random random = new Random();

	public static int makeRandomNumber() {
		return random.nextInt(MAXIMUM_VALUE);
	}
}
