package racingcar;

import exception.OutOfRangeException;
import util.Range;

public class Car {
	private int move = 0;

	public int run(int randomNumber) {
		validateRandomNumber(randomNumber);
		if (GameRule.isMoveCar(randomNumber)) {
			move++;
		}
		return move;
	}

	private void validateRandomNumber(int randomNumber) {
		if (Range.of(1, 9).contain(randomNumber)) {
			return;
		}
		throw new OutOfRangeException("랜덤숫자가 범위를 초과하였습니다.");
	}
}
