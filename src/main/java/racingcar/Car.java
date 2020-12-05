package racingcar;

public class Car {
	int moveCount = 0;
	private static int STANDARD_TO_MOVE = 4;

	public int tryMove(int randomNumber) {
		if (randomNumber >= STANDARD_TO_MOVE) {
			this.move();
		}
		return this.moveCount;
	}

	private void move() {
		this.moveCount++;
	}
}
