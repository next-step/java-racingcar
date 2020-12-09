package study.racingcar;

public class Car {
	private int position;

	public Car() {
		this.position = 0;
	}

	public void advanced() {
		this.position += 1;
	}

	public int getPosition() {
		return position;
	}
}
