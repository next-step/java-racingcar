package racing.domain;

import java.util.Random;

public class Car {

	private int forwardCount = 0;
	private static final int FORWARD_STANDARD = 4;
	private static final int RANDOM_BOUND = 10;

	public void moveForward() {
		int randomValue = new Random().nextInt(RANDOM_BOUND);
		if (canMoveForward(randomValue)) {
			forwardCount++;
		}
	}

	public boolean canMoveForward(int randomValue) {
		return randomValue >= FORWARD_STANDARD;
	}

	public int getForwardCount() {
		return forwardCount;
	}

}
