package racingcar;

import java.util.Random;

public class CarUtil {
	private static Random random = new Random();

	public static int makeRandomNumber(int maximum) {
		return random.nextInt(maximum+1);
	}
}
