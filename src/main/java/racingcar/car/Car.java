package racingcar.car;

public class Car {

	private static final int MIN_MOVE_VALUE = 4;
	private static final int MAX_NAME_LENGTH = 5;

	private int position = 0;
	private String carName;

	public Car(String carName) {
		if (isTooLong(carName)) {
			throw new IllegalArgumentException("이름은 5자이하로 작성해야합니다.");
		}
		this.carName = carName;
	}

	public void go(int number) {
		if (number < MIN_MOVE_VALUE) {
			return;
		}
		position++;
	}

	private static boolean isTooLong(String carName) {
		return carName.length() > MAX_NAME_LENGTH;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return carName;
	}
}
