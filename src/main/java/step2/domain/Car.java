package step2.domain;

public class Car {

	private static final int LUCKY_THRESHOLD = 4;

	private String name;
	private int step;

	public Car(String name, int step) {
		this.name = name;
		this.step = step;
	}

	public void moveIfLucky(int randomNumber) {
		if (isLuckyRound(randomNumber)) {
			step++;
		}
	}

	private boolean isLuckyRound(int randomNumber) {
		return randomNumber >= LUCKY_THRESHOLD;
	}

	public int getStep() {
		return step;
	}

	public String getName() {
		return name;
	}

}
