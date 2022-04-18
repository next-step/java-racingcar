package racingcar.domain;

import exception.OutOfRangeException;
import util.Range;

public class Car {
	public static final int RANDOM_MIN = 0;
	public static final int RANDOM_MAX = 9;
	public static final int ENGINE_START_MIN = 4;
	private final MoveCount moveCount;

	public Car() {
		this.moveCount = new MoveCount();
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
		return moveCount.toString();
	}

	public boolean isSamePosition(int position) {
		return moveCount.isSame(position);
	}
}
