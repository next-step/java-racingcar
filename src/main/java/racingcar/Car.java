package racingcar;

import java.util.Random;

public class Car {
	private boolean[] moving;
	public Car(int numberOfMove) {
		moving = new boolean[numberOfMove];
	}

	public void moveOrStop(int trial) {
		moving[trial] = new Random().nextInt(10) >= 4;
	}

	public boolean[] getMoving() {
		return moving;
	}
}
