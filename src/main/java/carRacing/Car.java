package carRacing;

import java.util.Random;

public class Car {

	private int index = 0;
	private static final int MINIMUM_TO_MOVE = 4;
	private static final int BOUND = 10;
	private Random random = new Random();
	private int randomNum = random.nextInt(BOUND);

	public int moveCar(int randomNum) {
		if (randomNum >= MINIMUM_TO_MOVE) {
			index++;
		}
		return index;
	}

	public int getIndex() {
		return index;
	}
}
