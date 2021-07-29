package racing.domain;

import java.util.Random;

import racing.utils.Validation;

public class Car {

	public static final String NUMBER_RANCE_CHECK_MESSAGE = "랜덤 숫자는 0~9 사이입니다.";
	private static final int RANDOM_RANGE = 10;
	private static final Random random = new Random();

	private final Name name;
	private Position position;

	public Car(String carName) {
		name = new Name(carName);
		position = new Position(0);
	}

	public Car(String carName, int position) {
		name = new Name(carName);
		this.position = new Position(position);
	}

	public void move(RandomMoving randomMoving) {
		if (randomMoving.movable(randomValue())) {
			position = position.move();
		}
	}

	public int randomValue() {
		int randomValue = random.nextInt(RANDOM_RANGE);
		Validation.validRandomRangeCheck(randomValue, NUMBER_RANCE_CHECK_MESSAGE);
		return randomValue;
	}

	public String printCarName() {
		return name.printName();
	}

	public int printPosition() {
		return position.resultPosition();
	}

	public boolean isWinner(int maxPosition) {
		return position.maxPositionCheck(maxPosition);
	}
}
