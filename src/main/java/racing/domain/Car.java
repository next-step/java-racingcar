package racing.domain;

public class Car {

	private int move;

	public Car() {
		this.move = 0;
	}

	public int getMove() {
		return move;
	}

	public void move() {
		this.move++;
	}
}
