package racing.game;

import java.util.Random;

public class Game {
	private final Random RANDOM;

	public Game(Random random) {
		RANDOM = random;
	}

	public int bound() {
		return RANDOM.nextInt();
	}

	public int[] bounds(int length) {
		int[] bounds = new int[length];
		for (int i = 0; i < length; i++) {
			bounds[i] = bound();
		}
		return bounds;
	}

}
