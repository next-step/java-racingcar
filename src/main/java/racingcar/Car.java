package racingcar;

public class Car {

	private static final int MIN_MOVE_VALUE = 4;

	private int position = 0;

	public void go(int number) {
		if (number < MIN_MOVE_VALUE) {
			return;
		}
		position++;
	}

	public int getPosition() {
		return position;
	}
}
