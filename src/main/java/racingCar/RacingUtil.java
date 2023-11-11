package racingCar;

import java.util.Random;

public class RacingUtil {
	private static Random random = new Random();

	public static int getRandomNumber() {
		return random.nextInt(10);
	}

}
