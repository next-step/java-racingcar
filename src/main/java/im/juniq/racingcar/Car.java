package im.juniq.racingcar;

public class Car {
	private int id;
	private int moveCount = 0;

	public Car(int id) {
		this.id = id;
	}

	public void move(MovingStrategy movingStrategy) {
		if (movingStrategy.isMoving()) {
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
