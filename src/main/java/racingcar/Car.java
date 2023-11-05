package racingcar;

import java.util.Random;

public class Car {
	private int location;
	private final static int STANDARD_SHUFFLE_NUM = 4;

	public Car(int location) {
		this.location = location;
	}

	public int getLocation() {
		return location;
	}

	public void moveByRule() {
		if (isOverNum()) {
			moveForward();
		}
	}

	public void moveForward() {
		this.location++;
	}

	private boolean isOverNum() {
		return new Random().nextInt(10) >= STANDARD_SHUFFLE_NUM;
	}
}
