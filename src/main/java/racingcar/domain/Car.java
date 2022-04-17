package racingcar.domain;

import exception.OutOfRangeException;
import util.Range;

public class Car {
	public static final int RANDOM_MIN = 0;
	public static final int RANDOM_MAX = 9;
	private int move = 0;

	public int run(int randomNumber) {
		validateRandomNumber(randomNumber);
		if (isMoveCar(randomNumber)) {
			move++;
		}
		return move;
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

	public int getMove() {
		return move;
	}



}
