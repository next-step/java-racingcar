package racing.model;

import java.util.Random;

public class MoveStrategy {

	private static final int MOVABLE_NUMBER = 4;
	private static final int RANGE_OF_RANDOM_NUMBER = 10;
	private static final Random random = new Random();

	public int getRandomNumber() {
		return random.nextInt(RANGE_OF_RANDOM_NUMBER);
	}

	public boolean isMovable(int random) {
		return random >= MOVABLE_NUMBER;
	}
}
