package racing.domain;

import racing.exception.ErrorMessage;
import racing.exception.InvalidCarNameLengthException;

public class Car implements Comparable<Car> {

	private static final int START_POINT = 1;
	private static final int MOVE_PIVOT = 4;
	private static final int CAR_NAME_MAX_LENGTH = 5;

	private final RandomNum randomNum;
	private String name;
	private int location;

	public Car(String name, RandomNum randomNum) {
		this(name, START_POINT, randomNum);
	}

	public Car(String name, int location, RandomNum randomNum) {
		if (!isValidCarNameLength(name)) {
			throw new InvalidCarNameLengthException(ErrorMessage.INVALID_CAR_NAME_LENGTH, name);
		}
		this.name = name;
		this.location = location;
		this.randomNum = randomNum;
	}

	private boolean isValidCarNameLength(String name) {
		return name.length() <= CAR_NAME_MAX_LENGTH;
	}

	public int move() {
		if (isMovable(randomNum.getRandomNumber())) {
			moveForward();
			return 1;
		}
		return 0;
	}

	private boolean isMovable(int randomNum) {
		return randomNum >= MOVE_PIVOT;
	}

	private void moveForward() {
		this.location += 1;
	}

	public int getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Car car) {
		if (this.location > car.getLocation())
			return 1;
		else if (this.location < car.getLocation())
			return -1;
		return 0;
	}
}
