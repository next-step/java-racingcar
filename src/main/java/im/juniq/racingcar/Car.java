package im.juniq.racingcar;

public class Car {
	private static final int BOUND_OF_CAR_MOVEMENT = 4;
	private int id;
	private int moveCount = 0;

	public Car(int id) {
		this.id = id;
	}

	public void move(RandomNumber randomNumber) {
		if (randomNumber.get() > BOUND_OF_CAR_MOVEMENT) {
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
