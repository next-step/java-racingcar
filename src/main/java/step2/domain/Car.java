package step2.domain;

public class Car {

	private static final int LUCKY_THRESHOLD = 4;

	private int step;

	public void moveIfLucky(int randomNumber) {
		if (isLuckyRound(randomNumber)) {
			step++;
		}
	}

	private boolean isLuckyRound(int randomNumber) {
		return randomNumber >= LUCKY_THRESHOLD;
	}

	int getStep() {
		return step;
	}

}
