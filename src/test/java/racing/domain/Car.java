package racing.domain;

import java.util.Random;

public class Car {

	private static final int FORWARD_STANDARD = 4;

	public boolean canMoveForward(int randomValue) {
		return randomValue >= FORWARD_STANDARD;
	}

}
