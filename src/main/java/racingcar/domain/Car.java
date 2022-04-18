package racingcar.domain;

import exception.OutOfRangeException;
import util.Range;

public class Car {
	public static final int RANDOM_MIN = 0;
	public static final int RANDOM_MAX = 9;
	private final MoveCount moveCount;

	public Car() {
		this.moveCount = new MoveCount();
	}

	public MoveCount run(int randomNumber) {
		if (isMoveCar(randomNumber)) {
			moveCount.add();
		}
		return moveCount;
	}

	public boolean isMoveCar(int randomNumber) {
		validateRandomNumber(randomNumber);
		return randomNumber >= 4;
	}

	private void validateRandomNumber(int randomNumber) {
		if (Range.of(RANDOM_MIN, RANDOM_MAX).contain(randomNumber)) {
			return;
		}
		throw new OutOfRangeException("랜덤숫자가 범위를 초과하였습니다.");
	}

	@Override
	public String toString() {
		return moveCount.toString();
	}
}
