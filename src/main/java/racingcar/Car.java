package racingcar;

public class Car {
	private int position;

	public int getPosition() {
		return this.position;
	}

	public void move() {
		this.position += 1;
	}
}
