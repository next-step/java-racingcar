package racing.domain;

public class Car {

	private static final int FORWARD_STANDARD = 4;
	private int forwardCount = 0;


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
