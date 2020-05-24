package study3;

public class Car {

	private int position = 0; // 위치

	public Car() {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public int move(int inNum) {
		if (inNum >= 4) {
			return position += 1;
		}
		return position;
	}

}
