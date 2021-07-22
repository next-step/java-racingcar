package racing.domain;

public class Car {

	private int forwardCount = 0;
	private static final int FORWARD_STANDARD = 4;


	public void moveForward() {
		int randomValue = RandomGenerator.generate();
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
