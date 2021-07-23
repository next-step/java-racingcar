package racing.domain;

public class Car {

	private int move;

	public Car() {
		this.move = 0;
	}

	public void move(int randomValue, int compareValue) {
		if (randomValue >= compareValue) {
			this.move++;
		}
	}

	public int getMove() {
		return move;
	}
}
