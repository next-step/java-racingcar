package racing;

import java.util.Random;

public class RacingGame {

	private static final Random RANDOM = new Random();
	private static final int BOUND = 10;

	public static int random() {
		return RANDOM.nextInt(BOUND);
	}

	public static String move(String car, int random) {
		if (random >= 4) {
			return car + "-";
		}
		return car;
	}
}
