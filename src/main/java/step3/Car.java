package step3;

public class Car {
	private int position;
	private int moveTimes;
	private int[] movedPosition = new int[100];

	public Car() {
		this.position = 0;
		this.moveTimes = 0;
	}

	public void move(int randVal) {
		if (randVal >= 4) {
			this.position++;
		}
		movedPosition[moveTimes] = position;
		this.moveTimes++;
	}

	public int getMoveTimes() {
		return moveTimes;
	}

	public int getPosition() {
		return position;
	}

	public int getPositionAtMove(int moveTime) {
		return movedPosition[moveTime];
	}
}
