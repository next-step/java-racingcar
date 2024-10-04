package step3.domain;

public class Car {
	private int position;
	private int moveCalledCount;

	public Car() {
		this.position = 0;
		this.moveCalledCount = 0;
	}

	public void move(int randVal) {
		if (randVal >= 4) {
			this.position++;
		}
		this.moveCalledCount++;
	}

	public int getMoveCalledCount() {
		return moveCalledCount;
	}

	public int getPosition() {
		return position;
	}
}
