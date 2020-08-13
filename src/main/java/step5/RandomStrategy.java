package step5;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {
	private static final Random RANDOM = new Random();
	private static final int RANDOM_LIMIT = 9;

	@Override
	public int getMovingNumber() {
		return RANDOM.nextInt(RANDOM_LIMIT);
	}
}
