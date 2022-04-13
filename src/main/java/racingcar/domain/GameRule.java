package racingcar.domain;

import exception.OutOfRangeException;
import util.Range;

public class GameRule {
	private GameRule() {}

	public static boolean isMoveCar(int randomNumber) {
		validateRandomNumber(randomNumber);
		return randomNumber >= 4;
	}

	private static void validateRandomNumber(int randomNumber) {
		if (Range.of(1, 9).contain(randomNumber)) {
			return;
		}
		throw new OutOfRangeException("랜덤숫자가 범위를 초과하였습니다.");
	}
}
