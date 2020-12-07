package step3;

import java.util.Random;

public class NumberUtil {

	private static final Random random = new Random();

	private NumberUtil() {
	}

	public static int generateRandomDigit() {
		return random.nextInt(10);
	}
}
