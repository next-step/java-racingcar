package strategy;

import java.util.Random;

public class AutoMoveable implements Moveable{

	private static final int RANDOM_MAX_VALUE = 9;
	private static final int REF_MOVE_VALUE = 4;

	@Override
	public boolean isMoveable() {
		if (getRandomNumber() >= REF_MOVE_VALUE) {
			return true;
		}

		return false;
	}

	private int getRandomNumber() {
		Random random = new Random();

		return random.nextInt(RANDOM_MAX_VALUE + 1);
	}
}
