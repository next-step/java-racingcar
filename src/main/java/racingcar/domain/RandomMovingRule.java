package racingcar.domain;

import exception.OutOfRangeException;
import util.Range;

public class RandomMovingRule implements MovingRule {
	public static final int RANDOM_MIN = 0;
	public static final int RANDOM_MAX = 9;
	private final RandomGenerator randomGenerator;

	public RandomMovingRule(RandomGenerator randomGenerator) {
		this.randomGenerator = randomGenerator;
	}

	public boolean isMoveCar() {
		int randomNumber = randomGenerator.generate();
		validateRandomNumber(randomNumber);
		return randomNumber >= 4;
	}

	private void validateRandomNumber(int randomNumber) {
		if (Range.of(RANDOM_MIN, RANDOM_MAX).contain(randomNumber)) {
			return;
		}
		throw new OutOfRangeException("랜덤숫자가 범위를 초과하였습니다.");
	}
}
