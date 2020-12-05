package race;

import java.util.Random;

public class RandomMovePolicy implements MovePolicy {
	private static final int INCREASE_DISTANCE = 1;

	@Override
	public boolean move() {
		return randomNumber() >= 4;
	}

	@Override
	public int distance() {
		return INCREASE_DISTANCE;
	}

	private int randomNumber() {
		return new Random().nextInt(10);
	}
}
