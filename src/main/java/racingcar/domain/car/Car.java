package racingcar.domain.car;

public class Car {

	private static final int START_POSITION = 0;
	private static final int MIN_MOVE_VALUE = 4;
	private static final int MAX_NAME_LENGTH = 5;

	private int position;
	private String carName;

	public Car(String carName) {
		this(carName, START_POSITION);
	}

	public Car(String carName, int position) {
		if (carName.isEmpty() || isTooLong(carName)) {
			throw new IllegalArgumentException("이름은 1자 이상 5자 이하로 작성해야합니다.");
		}
		this.carName = carName;
		this.position = position;
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

	public boolean isSamePosition(int position) {
		return this.position == position;
	}
}
