package racingcar;

public class Car {
	private int moveCount = 0;
	private static final int STANDARD_TO_MOVE = 4;

	public int tryMove(int randomNumber) {
		if (randomNumber >= STANDARD_TO_MOVE) {
			this.move();
		}
		return this.moveCount;
	}

	public int getMoveCount() {
		return this.moveCount;
	}

	private void move() {
		this.moveCount++;
	}
}
