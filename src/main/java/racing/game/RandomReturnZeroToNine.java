package racing.game;

import java.util.Random;

public class RandomReturnZeroToNine extends Random {

	private final int BOUND;

	public RandomReturnZeroToNine(int bound) {
		BOUND = bound;
	}

	@Override
	public int nextInt() {
		return nextInt(BOUND);
	}
}
