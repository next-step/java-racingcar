package racingcar.domain;

import exception.OutOfRangeException;
import util.Range;

public class Car {
	public static final int RANDOM_MIN = 0;
	public static final int RANDOM_MAX = 9;
	public static final int ENGINE_START_MIN = 4;
	public static final String CAR_TO_STRING_TEXT = " : ";
	private final MoveCount moveCount;
	private CarName carName;

	public Car() {
		this.moveCount = new MoveCount();
	}

	public Car(CarName carName) {
		this();
		this.carName = carName;
	}

	public void run(int enginePower) {
		if (isMoveCar(enginePower)) {
			moveCount.add();
		}
	}

	public boolean isMoveCar(int enginePower) {
		validateRandomNumber(enginePower);
		return enginePower >= ENGINE_START_MIN;
	}

	private void validateRandomNumber(int enginePower) {
		if (Range.of(RANDOM_MIN, RANDOM_MAX).contain(enginePower)) {
			return;
		}
		throw new OutOfRangeException("랜덤숫자가 범위를 초과하였습니다.");
	}

	@Override
	public String toString() {
		return carName.toString() + CAR_TO_STRING_TEXT + moveCount.toString();
	}

	public boolean isSamePosition(int position) {
		return moveCount.isSame(position);
	}
}
