package racingcar.domain;

import java.util.Objects;

import exception.OutOfRangeException;
import util.Range;

public class Car {
	public static final int RANDOM_MIN = 0;
	public static final int RANDOM_MAX = 9;
	public static final int ENGINE_START_MIN = 4;
	public static final String CAR_TO_STRING_TEXT = " : ";
	private final MoveCount moveCount;
	private final CarName carName;

	public Car(CarName carName) {
		validateName(carName);
		this.moveCount = new MoveCount();
		this.carName = carName;
	}

	public Car(CarName carName, MoveCount moveCount) {
		validateName(carName);
		validateMoveCount(moveCount);
		this.moveCount = moveCount;
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

	private void validateName(CarName carName) {
		Objects.requireNonNull(carName, "Car 의 CarName 이 올바르지 않습니다. [carName is null]");
	}

	private void validateMoveCount(MoveCount moveCount) {
		Objects.requireNonNull(moveCount, "Car 의 MoveCount 가 올바르지 않습니다. [moveCount is null]");
	}

	@Override
	public String toString() {
		return carName.toString() + CAR_TO_STRING_TEXT + moveCount.toString();
	}

	public boolean isSamePosition(int position) {
		return moveCount.isSame(position);
	}
}
