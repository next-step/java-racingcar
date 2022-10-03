package racing.domain;

import java.util.Random;

public class Car {

	private final static int START_POINT = 1;
	private final static int MOVE_PIVOT = 4;
	private int location;

	public Car() {
		this(START_POINT);
	}

	public Car(int location) {
		this.location = location;
	}

	public void move() {
		Random random = new Random();
		int randomNumber = random.nextInt(10);

		if (randomNumber >= MOVE_PIVOT) {
			moveForward();
		}
	}

	private void moveForward() {
		this.location += 1;
	}

	public int getLocation() {
		return location;
	}
}
