package racingcar.domain;

import java.util.Objects;

import exception.OutOfRangeException;
import util.Range;

public class Car implements Comparable<Car> {
	private static final int RANDOM_MIN = 0;
	private static final int RANDOM_MAX = 9;
	private static final int ENGINE_START_MIN = 4;
	private static final String CAR_TO_STRING_TEXT = " : ";
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

	public String carName() {
		return carName.toString();
	}

	public boolean isSamePosition(MoveCount moveCount) {
		return this.moveCount.equals(moveCount);
	}

	@Override
	public int compareTo(Car target) {
		return this.moveCount.compareTo(target.moveCount);
	}

	MoveCount max(MoveCount maxPosition) {
		return this.moveCount.max(maxPosition);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Car car = (Car)o;

		return carName.equals(car.carName);
	}

	@Override
	public int hashCode() {
		return carName.hashCode();
	}
}
