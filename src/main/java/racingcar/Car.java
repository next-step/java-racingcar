package racingcar;

public class Car {
	private String name;
	private int moveCount = 0;
	private static final int STANDARD_TO_MOVE = 4;

	public Car(String name) {
		if (!validateName(name)) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

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

	private boolean validateName(String name) {
		return name.length() <= 5;
	}
}
