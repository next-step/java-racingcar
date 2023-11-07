package racing;

import java.util.Random;

public class Game {
	private static final Random RANDOM = new Random();
	private static final int RANDOM_BOUND = 10;

	public Game() {
	}

	public int bound() {
		return RANDOM.nextInt(RANDOM_BOUND);
	}

	public int[] bounds(int length) {
		int[] bounds = new int[length];
		for (int i = 0; i < length; i++) {
			bounds[i] = bound();
		}
		return bounds;
	}

}
