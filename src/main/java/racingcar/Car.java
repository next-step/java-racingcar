package racingcar;

public class Car {
	private int position;

	public int getPosition() {
		return this.position;
	}

	public void move() {
		this.position += 1;
	}

	public void moveOrStop(int randomNumber) {
		if (randomNumber >= 4) {
			this.move();
		}
	}
}
