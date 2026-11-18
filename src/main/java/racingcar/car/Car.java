package racingcar.car;

public class Car {

	private static final int MIN_MOVE_VALUE = 4;

	private int position = 0;
	private String carName;

	public Car() {
	}

	public Car(String carName) {
		this.carName = carName;
	}

	public void go(int number) {
		if (number < MIN_MOVE_VALUE) {
			return;
		}
		position++;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return carName;
	}
}
