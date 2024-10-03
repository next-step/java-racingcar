package step3;

public class Car {
	private int position;
	private int moveTimes;

	public Car() {
		this.position = 0;
		this.moveTimes = 0;
	}

	public void move() {
		this.position++;
		this.moveTimes++;
	}

	public int getMoveTimes() {
		return moveTimes;
	}
}
