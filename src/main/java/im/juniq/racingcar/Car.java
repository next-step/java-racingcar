package im.juniq.racingcar;

import java.util.Random;

public class Car {
	private static final int BOUND_OF_RANDOM = 10;
	private static final int BOUND_OF_CAR_MOVEMENT = 4;
	private int id;
	private int moveCount = 0;
	private Random random;

	public Car(int id) {
		this.id = id;
		this.random = new Random();
	}

	public void move() {
		int randomNumber = random.nextInt(BOUND_OF_RANDOM);
		if (randomNumber > BOUND_OF_CAR_MOVEMENT) {
			moveCount++;
		}
	}

	public int getId() {
		return id;
	}

	public int getMoveCount() {
		return moveCount;
	}
}
