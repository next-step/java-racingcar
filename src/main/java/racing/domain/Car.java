package racing.domain;

public class Car {

	private int move;

	private static final int COMPARE_VALUE = 4;

	public Car() {
		this.move = 0;
	}

	public void move(int randomValue) {
		if (randomValue >= COMPARE_VALUE) {
			this.move++;
		}
	}

	public int getMove() {
		return move;
	}
}
