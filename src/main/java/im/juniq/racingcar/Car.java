package im.juniq.racingcar;

import java.util.Random;

public class Car {
	private int id;
	private int moveCount = 0;
	private Random random;

	public Car(int id) {
		this.id = id;
		this.random = new Random();
	}

	public void move() {
		int i = random.nextInt(10);
		if (i > 4) {
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
