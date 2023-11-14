package racing.model.random;

import java.util.Random;

public class RandomReturnZeroToNine extends Random {

	private static final int BOUND = 10;

	@Override
	public int nextInt() {
		return nextInt(BOUND);
	}
}
