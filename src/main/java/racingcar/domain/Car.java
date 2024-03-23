package racingcar.domain;

public class Car {
	public static final int MIN_THRESHOLD = 4;
	private static final int CAR_NAME_LENGTH_LIMIT = 5;

	private int position = 0;
	private String name;

	public Car() {
	}

	public Car(String name) {
		this(name, 0);
	}

	public Car(String name, int position) {
		if (CAR_NAME_LENGTH_LIMIT < name.length()) {
			throw new IllegalArgumentException("car name should under 5");
		}
		this.name = name;
		this.position = position;
	}

	public void moveForward(int randomNum) {
		if (randomNum >= MIN_THRESHOLD) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

}
